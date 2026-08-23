package and.degilevich.dream.shared.core.webauth.impl.launcher

import platform.AuthenticationServices.ASPresentationAnchor
import platform.AuthenticationServices.ASWebAuthenticationPresentationContextProvidingProtocol
import platform.AuthenticationServices.ASWebAuthenticationSession
import platform.UIKit.UIApplication
import platform.UIKit.UIWindow
import platform.darwin.NSObject

internal class WebAuthPresentationContextProvider :
    NSObject(),
    ASWebAuthenticationPresentationContextProvidingProtocol {

    override fun presentationAnchorForWebAuthenticationSession(
        session: ASWebAuthenticationSession
    ): ASPresentationAnchor {
        return UIApplication.sharedApplication.keyWindow ?: UIWindow()
    }
}
