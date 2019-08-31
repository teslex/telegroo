#!/usr/bin/env bash

[[ $(./gradlew properties -q | grep 'isSnapshot:' | awk '{print $2}') != 'true' ]] && exit 1

__telegroo_version=$(./gradlew properties -q | grep 'telegrooVersion:' | awk '{print $2}')
__here=$(pwd)

mkdir -p telegroo/src/test/resources
echo "token=${TEST_BOT_TOKEN}" > telegroo/src/test/resources/test.properties

#./gradlew test
./gradlew clean publish

git clone https://gitlab.com/teslex/repo || exit 2

cd ${__here}/repo/snapshots/tech/teslex/telegroo/telegroo &&
 find . -type d -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 1)" -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 2 | sort | head -n 1)" -printf '%P\n' |
 xargs rm -rf
cd ${__here}/repo/snapshots/tech/teslex/telegroo/telegroo-api &&
 find . -type d -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 1)" -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 2 | sort | head -n 1)" -printf '%P\n' |
 xargs rm -rf
cd ${__here}/repo/snapshots/tech/teslex/telegroo/telegram-api &&
 find . -type d -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 1)" -not -name "$(find . -type d -printf '%P\n' | sort -r | head -n 2 | sort | head -n 1)" -printf '%P\n' |
 xargs rm -rf

cd ${__here}

cp -r ${__here}/telegram-api/build/repo/* repo || exit 3
cp -r ${__here}/telegroo-api/build/repo/* repo || exit 3
cp -r ${__here}/telegroo/build/repo/* repo || exit 3

cd ${__here}/repo

git config user.name 'teslex.bot'
git config user.email 'teslex.bot@gmail.com'

bash update_readme.sh "telegroo-snapshot" "$__telegroo_version" || exit 4

git add .
git commit -m "Update telegroo snapshot"

git push https://teslex.bot:${GITLAB_PRIVATE_KEY}@gitlab.com/teslex/repo || exit 5