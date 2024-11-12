import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    id("org.jetbrains.intellij.platform") version "2.1.0"
}

group = "com.marketplace.plugins"
version = "2023.2.1"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("LATEST-EAP-SNAPSHOT", useInstaller = false)
        bundledPlugin("com.intellij.java")
        pluginVerifier()
        instrumentationTools()
    }
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellijPlatform {
    pluginConfiguration {
        id = "com.marketplace.makeMeCoffee"
        name = "MakeMeCoffee"
        version = "2024.1.1"
        description =
            """
                Remember all those times when you would say: "Good IDE, the only thing missing is a 'Make Coffee' button."?
                Well, today is a brew-tiful day for coffee addicts! At JetBrains, we give a Frappe about our customer's Irishs,
                with this very little (20Kb) plugin you can finally brew that Caramel-Skinny-Vanilla-de-caff-Macchiato right from the IDE's toolbar
            """.trimIndent()
        changeNotes =
            """
                We listened a Latte to what you have been Espresso your feelings for,
                so to Cappuccino it all off: now MakeMeCoffee connects with all the coffee machines
                in the network and will Mocha a delicious beverage at the one closest to your location.
                No more rushing through the whole building looking for that caffeine fix.
                It's the American dream.
            """.trimIndent()
        productDescriptor {
            code = "PMAKECOFFEE"
            releaseDate = "20241101"
            releaseVersion = "20241"
            optional = true
        }
        ideaVersion {
            sinceBuild.set("243")
        }
        vendor {
            name = "Marketplace"
            url = "https://plugins.jetbrains.com"
            email = "marketplace@jetbrains.com"
        }
    }

    pluginVerification {
        ides {
            ide(IntelliJPlatformType.IntellijIdeaCommunity, "2024.3")
        }
    }
}
