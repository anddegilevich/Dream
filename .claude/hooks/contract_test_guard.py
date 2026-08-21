#!/usr/bin/env python3
"""Advisory PreToolUse guard for the contract-first TDD workflow.

See .claude/skills/tdd-contract/SKILL.md.

Fires when an *existing* test or fake file is about to be modified — i.e. a contract that was
already written is being changed. Creating new test files (Phase 1) is silent.
Never blocks: it injects a reminder into context and exits 0.
"""

import json
import os
import re
import sys

REMINDER = (
    "Contract-first TDD: this is an existing contract test/fake. Editing it during "
    "implementation is only valid as an approved contract amendment (impossible signature, "
    "missing error case) — not as a way to make the current implementation pass. If an "
    "assertion is being relaxed to fit the code, fix the code instead. If it is a real "
    "amendment, state why, re-run the baseline, and re-commit. "
    "See .claude/skills/tdd-contract/SKILL.md."
)

CONTRACT_PATTERNS = (
    # <Class>Test in a module's own commonTest
    re.compile(r"/commonTest/.*Test\.kt$"),
    # Fakes of an internal interface, inline in that module's commonTest
    re.compile(r"/commonTest/.*/Fake[^/]*\.kt$"),
    # Fakes of a public api interface, in a sibling test module (data/test, ui/test, ...)
    re.compile(r"/test/src/.*/Fake[^/]*\.kt$"),
)


def main() -> int:
    try:
        payload = json.load(sys.stdin)
    except (json.JSONDecodeError, ValueError):
        return 0

    tool_input = payload.get("tool_input") or {}
    path = tool_input.get("file_path") or ""

    if not any(pattern.search(path) for pattern in CONTRACT_PATTERNS):
        return 0

    # Only nag when the file already exists — a brand new contract test is Phase 1, not an amendment.
    if not os.path.exists(path):
        return 0

    print(json.dumps({
        "hookSpecificOutput": {
            "hookEventName": "PreToolUse",
            "additionalContext": REMINDER,
        }
    }))
    return 0


if __name__ == "__main__":
    sys.exit(main())
