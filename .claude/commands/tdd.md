Implement `$ARGUMENTS` using the contract-first TDD workflow.

Load the `tdd-contract` skill and follow its four phases. If `$ARGUMENTS` is empty, ask what behavior to implement before doing anything else.

Before Phase 0, state which modules the behavior touches (`data/api`, `data/impl`, `domain/api`, `domain/impl`, `ui/*`, `component/<screen>/*`, and any sibling `test` modules that need to exist) and which layer skills apply — `data-module-rules`, `domain-module-rules`, `ui-module-rules`, `component-module-rules`, `data-mapper-module-rules`, `model-module-rules`. Load them as each phase needs them.

Stop at every phase gate and wait for confirmation before continuing:

* End of Phase 0 — list the skeleton types and signatures created, so the API shape can be reviewed before any test is written against it
* End of Phase 1 — paste the baseline run output showing every contract test red, then commit the contract before touching an implementation body
* End of Phase 2 — report the passing run
* End of Phase 3 — report the full verification, including the `git diff` of test files against the contract commit

Do not run the phases together as a single pass. The gates are the point of the workflow: each one is a place where a wrong contract is cheap to fix and an unreviewed one becomes expensive.
