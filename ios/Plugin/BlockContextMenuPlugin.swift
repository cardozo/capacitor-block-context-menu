import Foundation
import Capacitor
import UIKit

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(BlockContextMenuPlugin)
public class BlockContextMenuPlugin: CAPPlugin {
    
    public override func load() {
        guard let webview = self.bridge?.webView else {return}
        //Choose one way OR the other
        
        //Not recommended due to App Store Implications: Apps using method swizzling could face increased scrutiny or potential rejection during the App Store review process.
        WKWebView.swizzleCanPerformAction()
        
        //another way but not as relaiable and may break something in capacitor
        //webview.uiDelegate = self
        
        NotificationCenter.default.addObserver(self, selector: #selector(willShowMenuNotif), name: UIMenuController.willShowMenuNotification, object: nil)
        print("Hello from plugin init")
    }
    
    @objc func willShowMenuNotif() {
        print("will show menu")
        UIMenuController.shared.hideMenu()
    }
    
    
    
}

extension BlockContextMenuPlugin: WKUIDelegate {
    @available(iOS 16.0, *)
    public func webView(_ webView: WKWebView, willPresentEditMenuWithAnimator animator: UIEditMenuInteractionAnimating) {
        print("ello from edit")
        DispatchQueue.main.asyncAfter(deadline: .now() + 0.1) {
            let tempView = UIView()
            self.bridge?.webView?.addSubview(tempView)
            UIMenuController.shared.showMenu(from:tempView , rect: CGRect(x: 0, y: 0, width: 0, height: 0))
            UIMenuController.shared.hideMenu(from: tempView)
            tempView.removeFromSuperview()
        }
    }
    
    //iOS 15 or earlier
    public func webView(_ webView: WKWebView, contextMenuWillPresentForElement elementInfo: WKContextMenuElementInfo) {
        print("ello from context")
        UIMenuController.shared.hideMenu()
    }
}

extension WKWebView {
    static func swizzleCanPerformAction() {
        guard let originalMethod = class_getInstanceMethod(WKWebView.self, #selector(canPerformAction(_ :withSender:))) else { return }
        guard let swizzledMethod = class_getInstanceMethod(WKWebView.self, #selector(swizzledCanPerformAction(_:withSender:))) else { return }
        method_exchangeImplementations(originalMethod, swizzledMethod)
    }
    
    @objc func swizzledCanPerformAction(_ action: Selector, withSender sender: Any?) -> Bool {
        return false
    }
}
