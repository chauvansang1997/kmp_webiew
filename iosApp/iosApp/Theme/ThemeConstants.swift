import SwiftUI

struct ThemeConstants {

    struct Typography {
        static let h1: CGFloat = 32
        static let h2: CGFloat = 24
        static let h3: CGFloat = 20
        static let h4: CGFloat = 18
        static let body1: CGFloat = 16
        static let body2: CGFloat = 14
        static let button: CGFloat = 14
        static let caption: CGFloat = 12
        static let overline: CGFloat = 10
    }

    struct Spacing {
        static let none: CGFloat = 0
        static let xxs: CGFloat = 2
        static let xs: CGFloat = 4
        static let s: CGFloat = 8
        static let m: CGFloat = 16
        static let l: CGFloat = 24
        static let xl: CGFloat = 32
        static let xxl: CGFloat = 48
        static let xxxl: CGFloat = 64
    }

    struct CornerRadius {
        static let none: CGFloat = 0
        static let small: CGFloat = 4
        static let medium: CGFloat = 8
        static let large: CGFloat = 16
        static let xlarge: CGFloat = 24
        static let circle: CGFloat = 999
    }

    struct Elevation {
        static let none: CGFloat = 0
        static let low: CGFloat = 2
        static let medium: CGFloat = 4
        static let high: CGFloat = 8
        static let highest: CGFloat = 16
    }

    struct IconSize {
        static let small: CGFloat = 16
        static let medium: CGFloat = 24
        static let large: CGFloat = 32
        static let xlarge: CGFloat = 48
    }

    struct ComponentSize {
        static let buttonHeight: CGFloat = 48
        static let buttonHeightSmall: CGFloat = 36
        static let inputHeight: CGFloat = 56
        static let appBarHeight: CGFloat = 56
        static let bottomNavHeight: CGFloat = 56
        static let fabSize: CGFloat = 56
        static let avatarSmall: CGFloat = 32
        static let avatarMedium: CGFloat = 48
        static let avatarLarge: CGFloat = 64
    }

    struct Animation {
        static let instant: Double = 0.1
        static let quick: Double = 0.2
        static let normal: Double = 0.3
        static let slow: Double = 0.5
    }

    struct Opacity {
        static let invisible: Double = 0
        static let disabled: Double = 0.38
        static let medium: Double = 0.6
        static let high: Double = 0.87
        static let full: Double = 1
    }
}
