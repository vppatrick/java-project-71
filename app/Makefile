.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	./gradlew clean

build: lint test
	./gradlew clean build

install:
	./gradlew clean install

run-dist: # запуск исполняемого файла
	./build/install/app/bin/app

inst-dist:
	./gradlew clean installDist

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build