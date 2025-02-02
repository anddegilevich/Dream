package and.degilevich.dream.shared.compose.theme.api.colors

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface DreamColors : DreamThemeIndifferentColors {
    // Common
    val background: Color
        @Composable
        get
    val ripple: Color
        @Composable
        get
    val icon: Color
        @Composable
        get

    // Text
    val textPrimary: Color
        @Composable
        get
    val textSecondary: Color
        @Composable
        get
    val textLabel: Color
        @Composable
        get

    // Button
    val buttonPrimary: Color
        @Composable
        get
    val buttonPrimaryDisabled: Color
        @Composable
        get
    val buttonPrimaryText: Color
        @Composable
        get
    val buttonPrimaryTextDisabled: Color
        @Composable
        get

    val buttonSecondary: Color
        @Composable
        get
    val buttonSecondaryDisabled: Color
        @Composable
        get
    val buttonSecondaryText: Color
        @Composable
        get
    val buttonSecondaryTextDisabled: Color
        @Composable
        get

    val buttonOutlined: Color
        @Composable
        get
    val buttonOutlinedDisabled: Color
        @Composable
        get
    val buttonOutlinedText: Color
        @Composable
        get
    val buttonOutlinedTextDisabled: Color
        @Composable
        get

    val buttonBorderlessText: Color
        @Composable
        get
    val buttonBorderlessTextDisabled: Color
        @Composable
        get
}