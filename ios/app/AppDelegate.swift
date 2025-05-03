import SwiftUI
import Shared

class AppDelegate: NSObject, UIApplicationDelegate {
    let rootComponent: RootComponent = RootComponentImpl(
        componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle())
    )
}
