import Foundation
import UIKit

@objc public class BlockContextMenu: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
