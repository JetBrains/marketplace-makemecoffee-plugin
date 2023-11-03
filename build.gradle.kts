plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    id("org.jetbrains.intellij") version "1.13.3"
}

group = "com.marketplace.plugins"
version = "2023.2.1"

repositories {
    mavenCentral()
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    updateSinceUntilBuild.set(false)
    version.set("IC-2023.2")
}
tasks {
    patchPluginXml {
        changeNotes.set("""
      We listened a Latte to what you have been Espresso your feelings for,
      so to Cappuccino it all off: now MakeMeCoffee connects with all the coffee machines
      in the network and will Mocha a delicious beverage at the one closest to your location.
      No more rushing through the whole building looking for that caffeine fix.
      It's the American dream.""")
    }

    runPluginVerifier {
        ideVersions.add("IC-2023.2")
    }
}
