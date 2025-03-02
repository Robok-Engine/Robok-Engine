# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


# Keep
-keep class io.github.rosemoe.sora.widget.** { *; }

-keep class org.eclipse.jdt.internal.compiler.** { *; }

-keep class com.android.sdklib.** { *; }
-keep class sun.security.** { *; }

# Robok
# Engine
-keep class org.robok.engine.ui.core.components.edges.StretchEdgeEffect { *; }
-keep class org.robok.engine.feature.modeling.** { *; }
-keep class org.robok.engine.navigation.routes.** { *; }

# Easy UI
-keep class org.robok.easyui.GUIBuilder { *; }
-keep class org.robok.easyui.components.Components { *; }
-keep class org.robok.easyui.config.Config { *; }
# Keep the no-args constructor of the deserialized class
-keepclassmembers class org.robok.easyui.config.Config {
  <init>();
}

# LibGDX
-keep class com.badlogic.gdx.** { *; }

# Warns

# Robok
-dontwarn org.robok.engine.feature.component.compose.edge.StretchEdgeEffect

# Other
-dontwarn org.eclipse.jdt.internal.compiler.**
-dontwarn com.android.SdkConstants
-dontwarn com.android.dvlib.DeviceSchema
-dontwarn com.android.io.FolderWrapper
-dontwarn com.android.io.IAbstractFile$PreferredWriteMode
-dontwarn com.android.io.IAbstractFile
-dontwarn com.android.io.IAbstractFolder$FilenameFilter
-dontwarn com.android.io.IAbstractFolder
-dontwarn com.android.io.IAbstractResource
-dontwarn com.android.io.NonClosingInputStream$CloseBehavior
-dontwarn com.android.io.NonClosingInputStream
-dontwarn com.android.io.StreamException
-dontwarn com.android.prefs.AndroidLocation$AndroidLocationException
-dontwarn com.android.prefs.AndroidLocation
-dontwarn com.android.repository.Revision$PreviewComparison
-dontwarn com.android.repository.Revision
-dontwarn com.android.repository.api.Channel
-dontwarn com.android.repository.api.ConsoleProgressIndicator
-dontwarn com.android.repository.api.ConstantSourceProvider
-dontwarn com.android.repository.api.Dependency
-dontwarn com.android.repository.api.Downloader
-dontwarn com.android.repository.api.FallbackLocalRepoLoader
-dontwarn com.android.repository.api.FallbackRemoteRepoLoader
-dontwarn com.android.repository.api.Installer
-dontwarn com.android.repository.api.InstallerFactory$StatusChangeListenerFactory
-dontwarn com.android.repository.api.InstallerFactory
-dontwarn com.android.repository.api.License
-dontwarn com.android.repository.api.LocalPackage
-dontwarn com.android.repository.api.PackageOperation$InstallStatus
-dontwarn com.android.repository.api.PackageOperation$StatusChangeListener
-dontwarn com.android.repository.api.PackageOperation$StatusChangeListenerException
-dontwarn com.android.repository.api.PackageOperation
-dontwarn com.android.repository.api.ProgressIndicator
-dontwarn com.android.repository.api.ProgressIndicatorAdapter
-dontwarn com.android.repository.api.RemoteListSourceProvider
-dontwarn com.android.repository.api.RemotePackage
-dontwarn com.android.repository.api.RemoteSource
-dontwarn com.android.repository.api.RepoManager$RepoLoadedCallback
-dontwarn com.android.repository.api.RepoManager
-dontwarn com.android.repository.api.RepoPackage
-dontwarn com.android.repository.api.Repository
-dontwarn com.android.repository.api.RepositorySource
-dontwarn com.android.repository.api.RepositorySourceProvider
-dontwarn com.android.repository.api.SchemaModule
-dontwarn com.android.repository.api.SettingsController
-dontwarn com.android.repository.api.Uninstaller
-dontwarn com.android.repository.api.UpdatablePackage
-dontwarn com.android.repository.impl.generated.v1.RepositoryType
-dontwarn com.android.repository.impl.generated.v1.TypeDetails
-dontwarn com.android.repository.impl.installer.BasicInstallerFactory
-dontwarn com.android.repository.impl.meta.Archive$CompleteType
-dontwarn com.android.repository.impl.meta.Archive
-dontwarn com.android.repository.impl.meta.CommonFactory
-dontwarn com.android.repository.impl.meta.GenericFactory
-dontwarn com.android.repository.impl.meta.LocalPackageImpl
-dontwarn com.android.repository.impl.meta.RemotePackageImpl
-dontwarn com.android.repository.impl.meta.RepoPackageImpl
-dontwarn com.android.repository.impl.meta.RepositoryPackages
-dontwarn com.android.repository.impl.meta.RevisionType
-dontwarn com.android.repository.impl.meta.TypeDetails$GenericType
-dontwarn com.android.repository.impl.meta.TypeDetails
-dontwarn com.android.repository.impl.sources.LocalSourceProvider
-dontwarn com.android.repository.impl.sources.RemoteListSourceProviderImpl$SiteList
-dontwarn com.android.repository.impl.sources.generated.v1.SiteListType
-dontwarn com.android.repository.impl.sources.generated.v1.SiteType
-dontwarn com.android.repository.io.FileOp
-dontwarn com.android.repository.io.FileOpUtils
-dontwarn com.android.repository.io.impl.FileSystemFileOp
-dontwarn com.android.repository.testframework.MockFileOp
-dontwarn com.android.repository.util.InstallerUtil
-dontwarn com.android.resources.Density
-dontwarn com.android.resources.Keyboard
-dontwarn com.android.resources.KeyboardState
-dontwarn com.android.resources.Navigation
-dontwarn com.android.resources.NavigationState
-dontwarn com.android.resources.ScreenOrientation
-dontwarn com.android.resources.ScreenRatio
-dontwarn com.android.resources.ScreenRound
-dontwarn com.android.resources.ScreenSize
-dontwarn com.android.resources.TouchScreen
-dontwarn com.android.resources.UiMode
-dontwarn com.android.sdklib.AndroidVersion$AndroidVersionException
-dontwarn com.android.sdklib.AndroidVersion
-dontwarn com.android.utils.FileUtils
-dontwarn com.android.utils.GrabProcessOutput$IProcessOutput
-dontwarn com.android.utils.GrabProcessOutput$Wait
-dontwarn com.android.utils.GrabProcessOutput
-dontwarn com.android.utils.ILogger
-dontwarn com.android.utils.IReaderLogger
-dontwarn com.android.utils.Pair
-dontwarn com.android.utils.SdkUtils
-dontwarn com.google.common.annotations.VisibleForTesting
-dontwarn com.google.common.base.Charsets
-dontwarn com.google.common.base.MoreObjects$ToStringHelper
-dontwarn com.google.common.base.MoreObjects
-dontwarn com.google.common.base.Objects
-dontwarn com.google.common.base.Preconditions
-dontwarn com.google.common.base.Splitter
-dontwarn com.google.common.base.Strings
-dontwarn com.google.common.collect.BiMap
-dontwarn com.google.common.collect.ComparisonChain
-dontwarn com.google.common.collect.HashBasedTable
-dontwarn com.google.common.collect.HashBiMap
-dontwarn com.google.common.collect.HashMultimap
-dontwarn com.google.common.collect.ImmutableList$Builder
-dontwarn com.google.common.collect.ImmutableList
-dontwarn com.google.common.collect.ImmutableMap$Builder
-dontwarn com.google.common.collect.ImmutableMap
-dontwarn com.google.common.collect.ImmutableSet
-dontwarn com.google.common.collect.Lists
-dontwarn com.google.common.collect.Maps
-dontwarn com.google.common.collect.Multimap
-dontwarn com.google.common.collect.Range
-dontwarn com.google.common.collect.Sets
-dontwarn com.google.common.collect.Table
-dontwarn com.google.common.collect.TreeMultimap
-dontwarn com.google.common.hash.HashCode
-dontwarn com.google.common.hash.HashFunction
-dontwarn com.google.common.hash.Hasher
-dontwarn com.google.common.hash.Hashing
-dontwarn com.google.common.io.ByteStreams
-dontwarn com.google.common.io.Closeables
-dontwarn com.google.common.io.Closer
-dontwarn com.google.common.io.Files
-dontwarn java.awt.Dimension
-dontwarn java.awt.Point
-dontwarn javax.xml.bind.DatatypeConverter
-dontwarn javax.xml.bind.JAXBContext
-dontwarn javax.xml.bind.JAXBElement
-dontwarn javax.xml.bind.JAXBException
-dontwarn javax.xml.bind.Marshaller
-dontwarn javax.xml.bind.Unmarshaller
-dontwarn javax.xml.bind.ValidationEvent
-dontwarn javax.xml.bind.ValidationEventHandler
-dontwarn javax.xml.bind.annotation.XmlAccessType
-dontwarn javax.xml.bind.annotation.XmlAccessorType
-dontwarn javax.xml.bind.annotation.XmlAttribute
-dontwarn javax.xml.bind.annotation.XmlElement
-dontwarn javax.xml.bind.annotation.XmlElementDecl
-dontwarn javax.xml.bind.annotation.XmlElements
-dontwarn javax.xml.bind.annotation.XmlNsForm
-dontwarn javax.xml.bind.annotation.XmlRegistry
-dontwarn javax.xml.bind.annotation.XmlRootElement
-dontwarn javax.xml.bind.annotation.XmlSchema
-dontwarn javax.xml.bind.annotation.XmlSchemaType
-dontwarn javax.xml.bind.annotation.XmlTransient
-dontwarn javax.xml.bind.annotation.XmlType
-dontwarn javax.xml.bind.annotation.adapters.CollapsedStringAdapter
-dontwarn javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter
-dontwarn sun.misc.BASE64Encoder
-dontwarn sun.security.pkcs.ContentInfo
-dontwarn sun.security.pkcs.PKCS7
-dontwarn sun.security.pkcs.SignerInfo
-dontwarn sun.security.util.DerValue
-dontwarn sun.security.util.ObjectIdentifier
-dontwarn sun.security.x509.AlgorithmId
-dontwarn sun.security.x509.X500Name

# Keep class TypeToken (respectively its generic signature) if present
-if class com.google.gson.reflect.TypeToken
-keep,allowobfuscation class com.google.gson.reflect.TypeToken

# Keep any (anonymous) classes extending TypeToken
-keep,allowobfuscation class * extends com.google.gson.reflect.TypeToken

# Keep classes with @JsonAdapter annotation
-keep,allowobfuscation,allowoptimization @com.google.gson.annotations.JsonAdapter class *

# Keep fields with any other Gson annotation
# Also allow obfuscation, assuming that users will additionally use @SerializedName or
# other means to preserve the field names
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.Expose <fields>;
  @com.google.gson.annotations.JsonAdapter <fields>;
  @com.google.gson.annotations.Since <fields>;
  @com.google.gson.annotations.Until <fields>;
}

-keep class com.google.gson.** { *; }

# Keep no-args constructor of classes which can be used with @JsonAdapter
# By default their no-args constructor is invoked to create an adapter instance
-keepclassmembers class * extends com.google.gson.TypeAdapter {
  <init>();
}
-keepclassmembers class * implements com.google.gson.TypeAdapterFactory {
  <init>();
}
-keepclassmembers class * implements com.google.gson.JsonSerializer {
  <init>();
}
-keepclassmembers class * implements com.google.gson.JsonDeserializer {
  <init>();
}

# Keep fields annotated with @SerializedName for classes which are referenced.
# If classes with fields annotated with @SerializedName have a no-args
# constructor keep that as well. Based on
# https://issuetracker.google.com/issues/150189783#comment11.
# See also https://github.com/google/gson/pull/2420#discussion_r1241813541
# for a more detailed explanation.
-if class *
-keepclasseswithmembers,allowobfuscation class <1> {
  @com.google.gson.annotations.SerializedName <fields>;
}
-if class * {
  @com.google.gson.annotations.SerializedName <fields>;
}
-keepclassmembers,allowobfuscation,allowoptimization class <1> {
  <init>();
}
