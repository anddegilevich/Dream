import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate
    
    init() {
        LoggerHelperKt.doInitLogger()
        KoinHelperKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            RootView(rootComponent: appDelegate.rootComponent)
                .edgesIgnoringSafeArea(Edge.Set.all)
        }
    }
}
