### Hexlet tests and linter status:
[![Actions Status](https://github.com/vppatrick/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/vppatrick/java-project-71/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=vppatrick_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=vppatrick_java-project-71)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=vppatrick_java-project-71&metric=bugs)](https://sonarcloud.io/summary/new_code?id=vppatrick_java-project-71)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=vppatrick_java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=vppatrick_java-project-71)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=vppatrick_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=vppatrick_java-project-71)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=vppatrick_java-project-71&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=vppatrick_java-project-71)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=vppatrick_java-project-71&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=vppatrick_java-project-71)

## Overview

Utility for comparing two configuration files and displaying the differences between them. The utility supports JSON and YAML formats as input, and offers several options for displaying differences: stylish,. plain, and json. 
- stylish: Output format, presented as structured text.
- plain: Simple text format, which shows only changes.
- json: Output format in JSON style, which is convenient for processing by other programs.

## Help command

```bash
./build/install/app/bin/app -h
```

## Stylish output format

```bash
./build/install/app/bin/app -f stylish file1.json file2.json
```

## Plain output format

```bash
./build/install/app/bin/app -f plain file1.json file2.json
```

## Json output format

```bash
./build/install/app/bin/app -f json file1.json file2.json
```

## Info

- To compare two files, use the command with the paths to these files.
- To get help for the utility, use the command with the -h parameter.
- You can specify the output format using the -f option to choose between stylish, plain and json. The default output format (if you don't specify the option) is stylish.


## Example

[![asciicast](https://asciinema.org/a/lUUv9k4ibZ1RojL3UVoOId6I3.svg)](https://asciinema.org/a/lUUv9k4ibZ1RojL3UVoOId6I3)
