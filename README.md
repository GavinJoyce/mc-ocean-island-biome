# Ocean Island Biome

A Minecraft Forge mod that adds ocean island biome content including Pure Sand and more.

## Requirements

- Java 17 JDK
- Minecraft 1.20.1
- Forge 47.2.0+

## Quick Start

### Build the mod

```bash
./gradlew build
```

The JAR file will be generated at `build/libs/oceanislandbiome-1.0.0.jar`.

### Run the mod in development

```bash
./gradlew runClient
```

This launches Minecraft with the mod loaded for testing.

### Run a development server

```bash
./gradlew runServer
```

## IDE Setup

### IntelliJ IDEA

1. Import the project as a Gradle project
2. Run `./gradlew genIntellijRuns`
3. Refresh Gradle in the IDE
4. Use the generated run configurations

### Eclipse

1. Run `./gradlew genEclipseRuns`
2. Import as an existing project

### VS Code

Run directly from terminal using the Gradle commands above.

## Project Structure

```
src/main/java/com/oceanislandbiome/    # Mod source code
src/main/resources/                     # Assets and configuration
  ├── META-INF/mods.toml               # Mod metadata
  └── pack.mcmeta                      # Resource pack metadata
```

## Troubleshooting

### Java version issues

Ensure Java 17 is installed and available. Check with:

```bash
java -version
```

If you have multiple Java versions, the project uses Gradle toolchains to automatically find Java 17.

### Refresh dependencies

```bash
./gradlew --refresh-dependencies
```

### Clean build

```bash
./gradlew clean build
```

## License

MIT
