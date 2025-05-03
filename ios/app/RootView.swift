import SwiftUI
import Shared

struct RootView: UIViewControllerRepresentable {
    let rootComponent: RootComponent

    func makeUIViewController(context: Context) -> UIViewController {
        return RootViewControllerKt.rootViewController(rootComponent: rootComponent)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}
