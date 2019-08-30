#!/usr/bin/env bash

"[ $(./gradlew properties -q | grep 'isSnapshot:' | awk '{print $2}') != 'true' ] && exit 1"

__telegroo_version=$(./gradlew properties -q | grep 'telegrooVersion:' | awk '{print $2}')
__here=$(pwd)

mkdir -p telegroo/src/test/resources
echo "token=${TEST_BOT_TOKEN}" > telegroo/src/test/resources/test.properties

./gradlew test
./gradlew clean publish

git clone https://gitlab.com/teslex/repo

cd ${__here}/repo/snapshots/tech/teslex/telegroo/telegroo &&
 find . -type d -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 1)" -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 2 | sort | head -n 1)" -printf '%P\n' |
 xargs rm -rf
cd ${__here}/repo/snapshots/tech/teslex/telegroo/telegroo-api &&
 find . -type d -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 1)" -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 2 | sort | head -n 1)" -printf '%P\n' |
 xargs rm -rf
cd ${__here}/repo/snapshots/tech/teslex/telegroo/telegram-api &&
 find . -type d -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 1)" -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 2 | sort | head -n 1)" -printf '%P\n' |
 xargs rm -rf


cp -r telegram-api/build/repo/* repo
cp -r telegroo-api/build/repo/* repo
cp -r telegroo/build/repo/* repo

cd repo

git add .
git commit -m "Update telegroo snapshot"

bash update_readme.sh "telegroo-snapshot" "$__telegroo_version"

git push https://teslex.bot:${GITLAB_PRIVATE_KEY}@gitlab.com/teslex/repo