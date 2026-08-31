package and.degilevich.dream.shared.core.webauth.impl.launcher

import platform.AuthenticationServices.ASPresentationAnchor
import platform.AuthenticationServices.ASWebAuthenticationPresentationContextProvidingProtocol
import platform.AuthenticationServices.ASWebAuthenticationSession
import platform.UIKit.UIApplication
import platform.UIKit.UIWindow
import platform.UIKit.UIWindowScene
import platform.darwin.NSObject

internal class WebAuthPresentationContextProvider :
    NSObject(),
    ASWebAuthenticationPresentationContextProvidingProtocol {

    override fun presentationAnchorForWebAuthenticationSession(
        session: ASWebAuthenticationSession
    ): ASPresentationAnchor {
        return keyWindow() ?: UIWindow()
    }

    private fun keyWindow(): UIWindow? {
        return UIApplication.sharedApplication.connectedScenes
            .filterIsInstance<UIWindowScene>()
            .flatMap { scene -> scene.windows.filterIsInstance<UIWindow>() }
            .firstOrNull { window -> window.isKeyWindow() }
    }
}
