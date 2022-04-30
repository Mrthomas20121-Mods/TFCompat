import wtf.gofancy.fancygradle.patch.Patch
import wtf.gofancy.fancygradle.script.extensions.createDebugLoggingRunConfig
import wtf.gofancy.fancygradle.script.extensions.curse
import wtf.gofancy.fancygradle.script.extensions.curseForge
import wtf.gofancy.fancygradle.script.extensions.deobf

import java.time.format.DateTimeFormatter
import java.time.Instant

plugins {
    java
    idea
    id("net.minecraftforge.gradle") version "4.1.10"
    id("wtf.gofancy.fancygradle") version "1.0.1"
}

version = "1.3.1"
group = "mrthomas20121.tfcompat"

fancyGradle {
    patches {
        patch(Patch.CODE_CHICKEN_LIB, Patch.RESOURCES, Patch.COREMODS, Patch.ASM)
    }
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))
idea.module.inheritOutputDirs = true

repositories {
	curseForge()
    maven {
        name = "Craftweaker"
        url = uri("http://maven.blamejared.com")
    }
    maven { 
        name = "Slimeknight maven"
        url = uri("http://dvs1.progwml6.com/files/maven")
    }
    maven {
        name = "TOP maven"
        url = uri("http://maven.tterrag.com/")
    }
    maven {
        name = "Cofh Maven"
        url = uri("http://maven.covers1624.net")
    }
}

minecraft {
    mappings("stable", "39-1.12")

    runs {
        createDebugLoggingRunConfig("client")
        createDebugLoggingRunConfig("server") { args("nogui") }
    }
}

dependencies {
    minecraft(group = "net.minecraftforge", name = "forge", version = "1.12.2-14.23.5.2855")
    
    // jei
    implementation(fg.deobf(group = "mezz.jei", name = "jei_1.12.2", version = "4.16.1.302"))

    // construct armory
    implementation(fg.deobf(curse(mod = "constructs-armory", projectId = 287683L, fileId = 3174535L)))

    // crafttweaker
    implementation(fg.deobf(group = "CraftTweaker2", name = "ZenScript", version = "4.1.20.658"))
    implementation(fg.deobf(group = "CraftTweaker2", name = "CraftTweaker2-API", version = "4.1.20.658"))
    implementation(fg.deobf(group = "CraftTweaker2", name = "CraftTweaker2-MC1120-Main", version = "1.12-4.1.20.656"))

    // tfc
    implementation(fg.deobf(curse(mod = "tfcraft", projectId = 302973L, fileId = 3645502)))

    // tfc metallum
    implementation(fg.deobf(curse(mod = "tfc-metallum", projectId = 339156L, fileId = 3062588L)))

    // tfc tech
    implementation(fg.deobf(curse(mod = "tfctech-unofficial", projectId = 340660L, fileId = 3209033L)))

    // rocksalt version 1.0.4b
    implementation(fg.deobf(curse(mod = "rocksalt", projectId = 398969L, fileId = 3419071L)))

	// forestry
	implementation(fg.deobf(curse(mod = "improvedbackpacks", projectId = 59751L, fileId = 2918418L)))

	// improved backpacks
	implementation(fg.deobf(curse(mod = "improvedbackpacks", projectId = 270457L, fileId = 2918455L)))

	// actuallyadditions
	implementation(fg.deobf(curse(mod = "actually-additions", projectId = 228404L, fileId = 3117927L)))

	// Better With Mods Library
	implementation(fg.deobf(curse(mod = "bwm-core", projectId = 294335L, fileId = 2624990L)))
	
	// techreborn
	implementation(fg.deobf(curse(mod = "bwm-suite", projectId = 246760L, fileId = 3289033L)))

	// reborncore dep of techreborn
	implementation(fg.deobf(curse(mod = "reborncore", projectId = 237903L, fileId = 3330308L)))
	
	// techreborn
	implementation(fg.deobf(curse(mod = "techreborn", projectId = 233564L, fileId = 2966851L)))

	// bauble
	implementation(fg.deobf(curse(mod = "thaumcraft", projectId = 227083L, fileId = 2518667L)))
	
	// thaumcraft
	implementation(fg.deobf(curse(mod = "thaumcraft", projectId = 223628L, fileId = 2629023L)))

	// bloodmagic
	implementation(fg.deobf(curse(mod = "blood-magic", projectId = 224791L, fileId = 2822288L)))

	// ceramics
	implementation(fg.deobf(curse(mod = "ceramics", projectId = 250617L, fileId = 3158763L)))

	// inspirations
	implementation(fg.deobf(curse(mod = "inspirations", projectId = 284007L, fileId = 2843007L)))

    // more cauldrons
    implementation(fg.deobf(curse(mod = "mekanism", projectId = 268560L, fileId = 2835175L)))

	// more cauldrons
	implementation(fg.deobf(curse(mod = "more-cauldrons", projectId = 290545L, fileId = 2786201L)))

    // Iron backpacks
    implementation(fg.deobf(curse(mod = "iron-backpacks", projectId = 227049L, fileId = 2564573L)))
	
	// Pyrotech
    implementation(fg.deobf(curse(mod = "pyrotech", projectId = 306676L, fileId = 3425713L)))
    implementation(fg.deobf(curse(mod = "athenaeum", projectId = 284350L, fileId = 3466382L)))

    // rustic
    implementation(fg.deobf(curse(mod = "rustic", projectId = 256141L, fileId = 3107974L)))

    // nuclearcraft overhauled
    implementation(fg.deobf(curse(mod = "nuclearcraft-overhauled", projectId = 336895L, fileId = 3386487L)))

    // ember and soot
    implementation(fg.deobf(curse(mod = "embers-rekindled", projectId = 300777L, fileId = 3225431L)))
    implementation(fg.deobf(curse(mod = "soot", projectId = 281528L, fileId = 3056967L)))

	// Thermal Mods
	// loading the mods from curseforge because the maven doesn't have the latest 1.12.2 thermal build.
    // yes I know I'm missing code chicken lib.
    implementation(fg.deobf(curse(mod = "cofh-world", projectId = 271384L, fileId = 2920434L)))
	implementation(fg.deobf(curse(mod = "thermal-foundation", projectId = 222880L, fileId = 2926428L)))
	implementation(fg.deobf(curse(mod = "thermal-expansion", projectId = 69163L, fileId = 2926431L)))
	implementation(fg.deobf(curse(mod = "cofh-core", projectId = 69162L, fileId = 2920433L)))
	implementation(fg.deobf(curse(mod = "redstone-flux", projectId = 270789L, fileId = 2920436L)))
}

tasks {
    jar {
        archiveBaseName.set("tfcompat")
        finalizedBy("reobfJar")
        manifest {
            attributes(
                "Specification-Title" to project.name,
                "Specification-Version" to project.version,
                "Specification-Vendor" to "Mrthomas20121",
                "Implementation-Title" to "${project.group}.${project.name}",
                "Implementation-Version" to project.version,
                "Implementation-Vendor" to "Mrthomas20121",
                "Implementation-Timestamp" to DateTimeFormatter.ISO_INSTANT.format(Instant.now())
            )
        }
    }

    processResources {
        inputs.property("version", project.version)

        filesMatching("mcmod.info") {
            expand("version" to project.version,"mcversion" to "1.12.2")
        }
    }
}
