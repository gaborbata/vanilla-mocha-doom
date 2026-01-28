# Vanilla Mocha Doom

![Top Language](https://img.shields.io/github/languages/top/gaborbata/vanilla-mocha-doom.svg?style=flat)
![Code Size](https://img.shields.io/github/languages/code-size/gaborbata/vanilla-mocha-doom.svg?style=flat)
![License](https://img.shields.io/github/license/gaborbata/vanilla-mocha-doom.svg?style=flat&logo=gnu)
[![Java CI with Gradle](https://github.com/gaborbata/vanilla-mocha-doom/workflows/Java%20CI%20with%20Gradle/badge.svg)](https://github.com/gaborbata/vanilla-mocha-doom/actions/workflows/gradle.yml)

Mocha Doom is a pure Java Doom source port. Most of the hard work of porting Doom to Java has already been done,
thanks to Velktron (Maes) (see [Programming tricks](PROGRAMMING.md) for technical details), but he has stopped working on it in 2013.

Although the port is almost complete and many bugs have been fixed by contributors,
some work remains to do, most importantly the network code for the multiplayer is missing.

This fork of Mocha Doom is intended to support the classic (vanilla) key controls,
fix some bugs, and provide some pre-compiled binaries and startup scripts for convenience.

## Download

You can find the latest distribution package under the [releases](https://github.com/gaborbata/vanilla-mocha-doom/releases/latest) link.

Mocha Doom can play original variants of Doom. If you don't own any, the easiest way to obtain them is to purchase them from Steam or GOG.
You may also use the freely distributable Shareware version of Doom (also included in this repository).

Supported versions:

| WAD file                 | Name                     |
| ------------------------ | ------------------------ |
| `doom.wad`               | Doom Registered          |
| `doom1.wad`              | Doom Shareware           |
| `doom2.wad`              | Doom II: Hell on Earth   |
| `doomu.wad`, `udoom.wad` | The Ultimate Doom        |
| `plutonia.wad`           | The Plutonia Experiment  |
| `tnt.wad`                | TNT: Evilution           |
| `freedoom1.wad`          | Freedoom phase 1         |
| `freedoom2.wad`          | Freedoom phase 2         |
| `doom2f.wad`             | French Doom II           |
| `xbla.wad`               | Doom Xbox Live Arcade    |
| `freedm.wad`             | FreeDM (free deathmatch) |

> WAD (acronym for "Where's All the Data?") is the file format used by Doom and all Doom-engine-based games for storing data.

## How to run

1. Mocha Doom requires Java, so first of all make sure you have installed Java and please make sure `PATH`,
   or `JAVA_HOME` environment variables point to that installation.
2. Download the latest [release](https://github.com/gaborbata/vanilla-mocha-doom/releases/latest)
3. Then you can run Mocha Doom with one of the following batch/scripts/commands.
   Each script has a `classic` and `modern` version which launches Doom with classic or modern key controls, respectively.

   * Linux
     * `mochadoom-classic.sh`
     * `mochadoom-modern.sh`
     * `mochadoom.sh` (default configuration)
   * Windows
     * `mochadoom-classic.bat`
     * `mochadoom-modern.bat`
     * `mochadoom.bat` (default configuration)
   * Platform independent
     * `java -jar mochadoom.jar -config classic.cfg mochadoom.cfg`
     * `java -jar mochadoom.jar -config modern.cfg mochadoom.cfg`
     * `java -jar mochadoom.jar` (default configuration)

   Mocha Doom tries to find a valid Doom WAD file in the directory
   defined by the `DOOMWADDIR` environment variable (defaults to the current directory).

   If it is not found, you can use the `-iwad` parameter to provide a valid WAD file, e.g.:

   `mochadoom -iwad wads/DOOM1.WAD`.

### Configuration

Check [CONFIG.md](CONFIG.md) for more options to tune rendering performance and quality of Mocha Doom.

### Doom with classic or modern key controls

You can use `classic.cfg` configuration in order to have the old-school classic key controls (i.e. arrow keys).
If you prefer the modern keyboard/mouse layout (WASD), use the `modern.cfg` configuration.
If no configuration is provided, the `default.cfg` will be used which is currently the same as `classic.cfg`.

| Configuration   | Classic (Default)              | Modern (WASD)         |
| --------------- | ------------------------------ | --------------------- |
| key_right       | 77 (right arrow)               | 77 (right arrow)      |
| key_left        | 75 (left arrow)                | 75 (left arrow)       |
| key_up          | 72 (up arrow)                  | 17 (W)                |
| key_down        | 80 (down arrow)                | 31 (S)                |
| key_strafeleft  | 51 (Alt+left arrow) or comma   | 30 (A)                |
| key_straferight | 52 (Alt+right arrow) or period | 32 (D)                |
| key_fire        | 29 (Control)                   | 29 (Control)          |
| key_use         | 57 (Space)                     | 18 (E)                |
| key_strafe      | 56 (Alt)                       | 56 (Alt)              |
| key_speed       | 54 (Shift)                     | 54 (Shift)            |
| use_mouse       | 1 (enabled)                    | 1 (enabled)           |
| mouseb_fire     | 0 (left button)                | 0 (left button)       |
| mouseb_strafe   | 1 (right button)               | 1 (right button)      |
| mouseb_forward  | 2 (mid button)                 | 2 (mid button)        |

## How to build

You can also build Mocha Doom from sources with your preferred method.

### IDE

1. Open the project with IntelliJ IDEA, Eclipse or NetBeans
2. Build and run the project (entry point: `mochadoom.Engine`)

### Linux shell scripts

On Linux, two different scripts can be used.

1. `build-and-run.sh` which will build Mocha Doom and run it. You can use it as such:

   `./build-and-run.sh -iwad wads/DOOM1.WAD`.

   This is the preferred way to quickly test changes for developers.

2. `build-jar.sh` which will build a JAR file. You can then run the JAR file as such:

   `java -jar build/libs/mochadoom.jar -iwad wads/DOOM1.WAD`.

   This is the preferred way for distributing a Mocha Doom executable.

### Gradle

[Gradle](https://gradle.org/) is a cross-platform build tool, which can be also used to run and build Mocha Doom.
First of all, you have to install Gradle following its [installation notes](https://gradle.org/install/).
After that you can use one of the following commands:

* Run Mocha Doom:

  `gradle clean run --args="-iwad wads/DOOM1.WAD"`

* Build a JAR file:

  `gradle clean build`

  This creates a JAR file in the `build/libs/` folder.
  You can then run the JAR file as such:

  `java -jar build/libs/mochadoom.jar -iwad wads/DOOM1.WAD`.

  The build task also creates a distribution package with startup scripts under:

  `build/distributions/mochadoom.zip`

## License

Mocha Doom contains work from many contributors. Here are the main contributors,
but it's no limited to this list. Others are listed in the copyright headers of the files where they own copyright.

- Copyright (C) 1993-1996 [id Software, Inc.](http://www.idsoftware.com/)
- Copyright (C) 2010-2013 [Victor Epitropou](https://sourceforge.net/projects/mochadoom/)
- Copyright (C) 2016-2017 [Alexandre-Xavier Labonté-Lamoureux](https://github.com/AXDOOMER/)
- Copyright (C) 2017 [Good Sign](https://github.com/GoodSign2017)
- Copyright (C) 2023 [Gabor Bata](https://github.com/gaborbata)

Mocha Doom is distributed under the [GNU GPLv3 License](https://www.gnu.org/licenses/gpl-3.0.en.html).

Shareware Doom is distributed under the [Doom WAD Shareware License](wads/doom-wad-shareware-license.txt).

## Mocha Doom in action

https://github.com/user-attachments/assets/62ea0241-6b30-4527-9a65-68ceb27e74da
