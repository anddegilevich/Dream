# Exceptions
-keep public class * extends java.lang.Exception
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Emums
-keepclassmembers class * extends java.lang.Enum {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Serialization
-keep @kotlinx.serialization.Serializable class * { *; }

# Room
-keep @androidx.room.Entity class * { *; }

# Annotations
-keepattributes *Annotation*
-dontwarn com.google.errorprone.annotations.CanIgnoreReturnValue
-dontwarn com.google.errorprone.annotations.CheckReturnValue
-dontwarn com.google.errorprone.annotations.Immutable
-dontwarn com.google.errorprone.annotations.RestrictedApi

# Other
-dontwarn org.slf4j.impl.StaticLoggerBinder
-dontwarn org.slf4j.impl.StaticMarkerBinder
-repackageclasses