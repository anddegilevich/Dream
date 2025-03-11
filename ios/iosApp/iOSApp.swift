import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate
    
    var body: some Scene {
        WindowGroup {
            RootView(rootComponent: appDelegate.rootComponent)
                .edgesIgnoringSafeArea(Edge.Set.all)
        }
    }
    
    init() {
        initLogger()
        initDI()
    }
    
    private func initLogger() {
        #if DEBUG
            LoggerHelperKt.doInitLogger()
        #endif
    }
    
    private func initDI() {
        DIHelperKt.doInitDI()
    }
}
