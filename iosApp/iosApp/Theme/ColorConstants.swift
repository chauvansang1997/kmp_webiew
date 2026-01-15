import SwiftUI

struct ColorConstants {

    struct Primary {
        static let `default` = Color(hex: "#6200EE")
        static let variant = Color(hex: "#3700B3")
        static let light = Color(hex: "#9C4DFF")
    }

    struct Secondary {
        static let `default` = Color(hex: "#03DAC6")
        static let variant = Color(hex: "#018786")
        static let light = Color(hex: "#66FFF5")
    }

    struct Background {
        static let light = Color(hex: "#FFFFFF")
        static let dark = Color(hex: "#121212")
        static let surfaceLight = Color(hex: "#F5F5F5")
        static let surfaceDark = Color(hex: "#1E1E1E")
    }

    struct Text {
        static let primaryLight = Color(hex: "#000000")
        static let primaryDark = Color(hex: "#FFFFFF")
        static let secondaryLight = Color(hex: "#666666")
        static let secondaryDark = Color(hex: "#B3B3B3")
        static let disabledLight = Color(hex: "#9E9E9E")
        static let disabledDark = Color(hex: "#616161")
    }

    struct Status {
        static let error = Color(hex: "#B00020")
        static let errorDark = Color(hex: "#CF6679")
        static let success = Color(hex: "#4CAF50")
        static let warning = Color(hex: "#FF9800")
        static let info = Color(hex: "#2196F3")
    }

    struct Neutral {
        static let gray50 = Color(hex: "#FAFAFA")
        static let gray100 = Color(hex: "#F5F5F5")
        static let gray200 = Color(hex: "#EEEEEE")
        static let gray300 = Color(hex: "#E0E0E0")
        static let gray400 = Color(hex: "#BDBDBD")
        static let gray500 = Color(hex: "#9E9E9E")
        static let gray600 = Color(hex: "#757575")
        static let gray700 = Color(hex: "#616161")
        static let gray800 = Color(hex: "#424242")
        static let gray900 = Color(hex: "#212121")
    }

    struct Divider {
        static let light = Color(hex: "#E0E0E0")
        static let dark = Color(hex: "#424242")
    }

    struct Overlay {
        static let light = Color(hex: "#33000000")
        static let medium = Color(hex: "#66000000")
        static let dark = Color(hex: "#99000000")
    }
}

extension Color {
    init(hex: String) {
        let hex = hex.trimmingCharacters(in: CharacterSet.alphanumerics.inverted)
        var int: UInt64 = 0
        Scanner(string: hex).scanHexInt64(&int)
        let a, r, g, b: UInt64
        switch hex.count {
        case 3:
            (a, r, g, b) = (255, (int >> 8) * 17, (int >> 4 & 0xF) * 17, (int & 0xF) * 17)
        case 6:
            (a, r, g, b) = (255, int >> 16, int >> 8 & 0xFF, int & 0xFF)
        case 8:
            (a, r, g, b) = (int >> 24, int >> 16 & 0xFF, int >> 8 & 0xFF, int & 0xFF)
        default:
            (a, r, g, b) = (255, 0, 0, 0)
        }

        self.init(
            .sRGB,
            red: Double(r) / 255,
            green: Double(g) / 255,
            blue:  Double(b) / 255,
            opacity: Double(a) / 255
        )
    }
}
