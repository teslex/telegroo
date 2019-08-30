#!/usr/bin/env bash

"[ $(./gradlew properties -q | grep 'isSnapshot:' | awk '{print $2}') == 'true' ] && exit 1"

mkdir -p telegroo/src/test/resources

echo "token=${TEST_BOT_TOKEN}" > telegroo/src/test/resources/test.properties

./gradlew test

./gradlew bintrayUpload