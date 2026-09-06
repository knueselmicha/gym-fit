# Gym-Fit

Kurz: Gym-Fit ist eine native Android-App (Kotlin, Jetpack Compose, Material3) zum Erfassen von Krafttraining, Sätzen, PRs und mehr. Alle Daten werden lokal mit Room gespeichert. Einstellungen werden via DataStore persistiert. Die App ist offline-fähig und benötigt kein Konto.

Wichtige Features
- Trainingseinheiten erstellen, Übungen hinzufügen, Sätze dokumentieren
- Room DB (Workout, Exercises, Sets, PRs, PR-Historie)
- Timer mit persistiertem Endzeitpunkt (DataStore)
- PR-Share als PNG über FileProvider (content://)
- DataStore-Einstellungen (Einheit, Timer usw.)
- Compose UI (Material 3) mit dunklem, modernen Design
- Unit-Tests für Kernberechnungen

Voraussetzungen
- Android Studio (Electric Eel oder neuer empfohlen; AGP 8.1.1 kompatibel)
- JDK 17
- Gradle 8.4+ (Wrapper in gradle/wrapper wird benötigt)

Projekt öffnen
1. Repository/Ordner in Android Studio öffnen (File → Open).
2. Falls gradle-wrapper.jar fehlt: in einem Terminal im Projekt-Root ausführen:
   ./gradlew wrapper --gradle-version 8.4.1
   Android Studio kann auch beim Import die Wrapper-Dateien erstellen.
3. Gradle Sync ausführen (Tools → Kotlin → Sync).

Starten
- Starte einen Emulator mit API 26+ oder ein physisches Gerät.
- Run 'app' (Debug) in Android Studio.

Tests
- Ausführen über Run → Run Tests (app/src/test).

Besondere Hinweise
- gradle-wrapper.jar: Falls nicht enthalten, erzeugt Android Studio beim ersten Sync oder verwende den oben genannten wrapper Befehl.
- Launcher-Icons: vektorbasierte adaptive icon ist definiert; raster mipmap PNGs können für verschiedene Dichten hinzugefügt werden. Falls die PNGs fehlen, erstellt Android Studio beim Import automatisch geeignete mipmap-Versionen.
- FileProvider: Share-Bilder werden im cache/images abgelegt und über `ch.gymfit.app.fileprovider` geteilt.

Ordnerstruktur (Kurz)
- app/src/main/java/ch/gymfit/app
  - data/local (entity, dao, database, seed)
  - data/repository
  - data/preferences (DataStore)
  - ui (navigation, theme, screens)
  - util (Timer, Converter)
  - viewmodel
- app/src/test: Unit-Tests inklusive DB-Seed-Test

Fehlerbehebung Gradle
- "Could not find com.android.tools.build:gradle:...": sicherstellen, dass in build.gradle.kts die AGP-Version mit installiertem Android Studio kompatibel ist.
- Kapt/Room: Kapt-Plugin aktivieren (build.gradle.kts enthält `kapt`).

Wenn du möchtest, kann ich:
- Den vollständigen Projekt-Ordner als ZIP erstellen (wenn Upload möglich).
- Eine kleinere, gezielte Erweiterung (z. B. vollständiger Active-Workout-Editor mit Satz-CRUD) als nächsten Schritt implementieren.
- Screenshots oder ein kurzes Video (Anleitung) beifügen.
