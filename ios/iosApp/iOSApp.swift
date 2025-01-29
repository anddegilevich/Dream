import SwiftUI
import Shared

@main
struct iOSApp: App {
    
    init() {
        LoggerHelperKt.doInitLogger()
        KoinHelperKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
