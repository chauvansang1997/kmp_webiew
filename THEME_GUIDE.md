# Theme Guide

A comprehensive guide to the theme system in this KMP project.

## Overview

The project uses a shared theme system that ensures consistent design across Android and iOS platforms. All theme values are defined in the shared module and implemented platform-specifically.

## Architecture

```
shared/core/theme/          # Shared theme definitions
├── ColorPalette.kt         # All color values (hex strings)
└── ThemeConstants.kt       # Typography, spacing, dimensions

androidApp/core/theme/      # Android implementation
├── ColorProvider.kt        # Android color conversion
└── ThemeHelper.kt          # Theme utilities

iosApp/Theme/              # iOS implementation
├── ColorConstants.swift   # iOS color definitions
└── ThemeConstants.swift   # iOS theme values
```

## Color System

### Shared Colors (ColorPalette.kt)

All colors are defined as hex strings in the shared module for cross-platform consistency.

#### Primary Colors
```kotlin
ColorPalette.Primary.DEFAULT  // #6200EE - Main brand color
ColorPalette.Primary.VARIANT  // #3700B3 - Darker variant
ColorPalette.Primary.LIGHT    // #9C4DFF - Lighter variant
```

#### Secondary Colors
```kotlin
ColorPalette.Secondary.DEFAULT  // #03DAC6 - Accent color
ColorPalette.Secondary.VARIANT  // #018786 - Darker variant
ColorPalette.Secondary.LIGHT    // #66FFF5 - Lighter variant
```

#### Background Colors
```kotlin
ColorPalette.Background.LIGHT         // #FFFFFF - Light mode background
ColorPalette.Background.DARK          // #121212 - Dark mode background
ColorPalette.Background.SURFACE_LIGHT // #F5F5F5 - Light mode surface
ColorPalette.Background.SURFACE_DARK  // #1E1E1E - Dark mode surface
```

#### Text Colors
```kotlin
ColorPalette.Text.PRIMARY_LIGHT    // #000000 - Primary text (light mode)
ColorPalette.Text.PRIMARY_DARK     // #FFFFFF - Primary text (dark mode)
ColorPalette.Text.SECONDARY_LIGHT  // #666666 - Secondary text (light mode)
ColorPalette.Text.SECONDARY_DARK   // #B3B3B3 - Secondary text (dark mode)
ColorPalette.Text.DISABLED_LIGHT   // #9E9E9E - Disabled text (light mode)
ColorPalette.Text.DISABLED_DARK    // #616161 - Disabled text (dark mode)
```

#### Status Colors
```kotlin
ColorPalette.Status.ERROR      // #B00020 - Error state
ColorPalette.Status.ERROR_DARK // #CF6679 - Error (dark mode)
ColorPalette.Status.SUCCESS    // #4CAF50 - Success state
ColorPalette.Status.WARNING    // #FF9800 - Warning state
ColorPalette.Status.INFO       // #2196F3 - Info state
```

#### Neutral Grays (50-900 scale)
```kotlin
ColorPalette.Neutral.GRAY_50   // #FAFAFA - Lightest
ColorPalette.Neutral.GRAY_100  // #F5F5F5
ColorPalette.Neutral.GRAY_200  // #EEEEEE
ColorPalette.Neutral.GRAY_300  // #E0E0E0
ColorPalette.Neutral.GRAY_400  // #BDBDBD
ColorPalette.Neutral.GRAY_500  // #9E9E9E - Medium gray
ColorPalette.Neutral.GRAY_600  // #757575
ColorPalette.Neutral.GRAY_700  // #616161
ColorPalette.Neutral.GRAY_800  // #424242
ColorPalette.Neutral.GRAY_900  // #212121 - Darkest
```

#### Dividers & Overlays
```kotlin
ColorPalette.Divider.LIGHT    // #E0E0E0 - Light mode divider
ColorPalette.Divider.DARK     // #424242 - Dark mode divider

ColorPalette.Overlay.LIGHT    // #33000000 - 20% black
ColorPalette.Overlay.MEDIUM   // #66000000 - 40% black
ColorPalette.Overlay.DARK     // #99000000 - 60% black
```

### Platform Implementation

#### Android
```kotlin
// Android uses ColorProvider to convert hex to Color
import com.kmp.example.core.theme.ColorProvider

val primaryColor = ColorProvider.getColor(ColorPalette.Primary.DEFAULT)
```

#### iOS
```swift
// iOS has pre-converted Color constants
import ColorConstants

let primaryColor = ColorConstants.Primary.default
```

## Typography Scale

Based on Material Design type scale, measured in SP (Android) / Points (iOS).

```kotlin
ThemeConstants.Typography.H1       // 32 - Large headlines
ThemeConstants.Typography.H2       // 24 - Medium headlines
ThemeConstants.Typography.H3       // 20 - Titles
ThemeConstants.Typography.H4       // 18 - Subtitles
ThemeConstants.Typography.BODY1    // 16 - Primary body text
ThemeConstants.Typography.BODY2    // 14 - Secondary body text
ThemeConstants.Typography.BUTTON   // 14 - Button labels
ThemeConstants.Typography.CAPTION  // 12 - Captions
ThemeConstants.Typography.OVERLINE // 10 - Overline text
```

### Usage Examples

#### Android
```kotlin
textView.textSize = ThemeConstants.Typography.H1  // 32sp
```

#### iOS
```swift
Text("Title")
    .font(.system(size: ThemeConstants.Typography.h1))  // 32pt
```

## Spacing System

Following the 8dp grid system for consistent spacing.

```kotlin
ThemeConstants.Spacing.NONE  // 0
ThemeConstants.Spacing.XXS   // 2dp  - Minimal
ThemeConstants.Spacing.XS    // 4dp  - Very small
ThemeConstants.Spacing.S     // 8dp  - Small (base unit)
ThemeConstants.Spacing.M     // 16dp - Medium (2x base)
ThemeConstants.Spacing.L     // 24dp - Large (3x base)
ThemeConstants.Spacing.XL    // 32dp - Extra large (4x base)
ThemeConstants.Spacing.XXL   // 48dp - Very large (6x base)
ThemeConstants.Spacing.XXXL  // 64dp - Maximum (8x base)
```

### Usage Examples

#### Android (XML)
```xml
<View
    android:layout_margin="16dp"  <!-- Use M spacing -->
    android:padding="8dp" />       <!-- Use S spacing -->
```

#### iOS (SwiftUI)
```swift
VStack(spacing: ThemeConstants.Spacing.m) {  // 16pt spacing
    Text("Item 1")
        .padding(ThemeConstants.Spacing.s)   // 8pt padding
}
```

## Corner Radius

Rounded corner values for consistent UI elements.

```kotlin
ThemeConstants.CornerRadius.NONE    // 0  - Sharp corners
ThemeConstants.CornerRadius.SMALL   // 4  - Subtle rounding
ThemeConstants.CornerRadius.MEDIUM  // 8  - Standard rounding
ThemeConstants.CornerRadius.LARGE   // 16 - Prominent rounding
ThemeConstants.CornerRadius.XLARGE  // 24 - Very rounded
ThemeConstants.CornerRadius.CIRCLE  // 999 - Fully rounded (pill)
```

### Usage Examples

#### Android (XML)
```xml
<shape>
    <corners android:radius="8dp" />  <!-- MEDIUM -->
</shape>
```

#### iOS (SwiftUI)
```swift
RoundedRectangle(cornerRadius: ThemeConstants.CornerRadius.medium)
```

## Elevation (Shadows)

Shadow/depth values for Material Design elevation.

```kotlin
ThemeConstants.Elevation.NONE    // 0  - No shadow
ThemeConstants.Elevation.LOW     // 2  - Subtle
ThemeConstants.Elevation.MEDIUM  // 4  - Standard
ThemeConstants.Elevation.HIGH    // 8  - Prominent
ThemeConstants.Elevation.HIGHEST // 16 - Maximum
```

### Usage Examples

#### Android (XML)
```xml
<View android:elevation="4dp" />  <!-- MEDIUM -->
```

#### iOS (SwiftUI)
```swift
.shadow(radius: ThemeConstants.Elevation.medium)
```

## Icon Sizes

Standard icon dimensions.

```kotlin
ThemeConstants.IconSize.SMALL   // 16 - Small icons
ThemeConstants.IconSize.MEDIUM  // 24 - Standard icons
ThemeConstants.IconSize.LARGE   // 32 - Large icons
ThemeConstants.IconSize.XLARGE  // 48 - Extra large icons
```

## Component Sizes

Common UI component dimensions.

```kotlin
ThemeConstants.ComponentSize.BUTTON_HEIGHT       // 48 - Standard button
ThemeConstants.ComponentSize.BUTTON_HEIGHT_SMALL // 36 - Small button
ThemeConstants.ComponentSize.INPUT_HEIGHT        // 56 - Text field
ThemeConstants.ComponentSize.APP_BAR_HEIGHT      // 56 - Toolbar
ThemeConstants.ComponentSize.BOTTOM_NAV_HEIGHT   // 56 - Bottom nav
ThemeConstants.ComponentSize.FAB_SIZE            // 56 - FAB
ThemeConstants.ComponentSize.AVATAR_SMALL        // 32 - Small avatar
ThemeConstants.ComponentSize.AVATAR_MEDIUM       // 48 - Medium avatar
ThemeConstants.ComponentSize.AVATAR_LARGE        // 64 - Large avatar
```

## Animation Durations

Standard animation timing in milliseconds.

```kotlin
ThemeConstants.Animation.INSTANT  // 100ms - Instant feedback
ThemeConstants.Animation.QUICK    // 200ms - Quick transitions
ThemeConstants.Animation.NORMAL   // 300ms - Standard animations
ThemeConstants.Animation.SLOW     // 500ms - Slower animations
```

### Usage Examples

#### Android (Kotlin)
```kotlin
view.animate()
    .alpha(1f)
    .setDuration(ThemeConstants.Animation.NORMAL)  // 300ms
```

#### iOS (SwiftUI)
```swift
withAnimation(.easeInOut(duration: ThemeConstants.Animation.normal)) {
    // Animation
}
```

## Opacity Values

Standard opacity/alpha values.

```kotlin
ThemeConstants.Opacity.INVISIBLE // 0.0  - Fully transparent
ThemeConstants.Opacity.DISABLED  // 0.38 - Disabled state
ThemeConstants.Opacity.MEDIUM    // 0.6  - Medium emphasis
ThemeConstants.Opacity.HIGH      // 0.87 - High emphasis
ThemeConstants.Opacity.FULL      // 1.0  - Fully opaque
```

## Dark Mode Support

The theme system includes built-in dark mode support:

- Background colors: `LIGHT` and `DARK` variants
- Text colors: `PRIMARY_LIGHT/DARK`, `SECONDARY_LIGHT/DARK`
- Status colors: `ERROR` and `ERROR_DARK`

### Android Dark Mode

```xml
<!-- res/values/themes.xml (Light) -->
<color name="background">@color/background_light</color>

<!-- res/values-night/themes.xml (Dark) -->
<color name="background">@color/background_dark</color>
```

### iOS Dark Mode

```swift
Color(uiColor: .systemBackground)  // Automatically switches
// Or manually:
@Environment(\.colorScheme) var colorScheme
let bgColor = colorScheme == .dark ?
    ColorConstants.Background.dark :
    ColorConstants.Background.light
```

## Best Practices

1. **Always use theme constants** - Never hardcode values
2. **Follow 8dp grid** - Use spacing constants for all margins/padding
3. **Use semantic colors** - Choose colors by purpose (Primary, Status, etc.)
4. **Respect elevation hierarchy** - Higher components have higher elevation
5. **Consistent animation timing** - Use standard durations
6. **Support dark mode** - Use light/dark variants where provided
7. **Test both platforms** - Ensure consistency across Android and iOS

## Adding New Colors

To add a new color to the system:

1. **Add to shared ColorPalette.kt**
```kotlin
object Brand {
    const val TERTIARY = "#FF5722"
}
```

2. **Add to Android colors.xml**
```xml
<color name="brand_tertiary">#FF5722</color>
```

3. **Add to iOS ColorConstants.swift**
```swift
struct Brand {
    static let tertiary = Color(hex: "#FF5722")
}
```

## Adding New Dimensions

To add a new dimension:

1. **Add to shared ThemeConstants.kt**
```kotlin
object CustomSize {
    const val SPECIAL = 42f
}
```

2. **Add to Android dimens.xml**
```xml
<dimen name="custom_special">42dp</dimen>
```

3. **Add to iOS ThemeConstants.swift**
```swift
struct CustomSize {
    static let special: CGFloat = 42
}
```

## Resources

- Material Design Guidelines: https://material.io/design
- Human Interface Guidelines: https://developer.apple.com/design/human-interface-guidelines
- 8dp Grid System: https://material.io/design/layout/spacing-methods.html
