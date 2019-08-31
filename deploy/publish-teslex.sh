#!/usr/bin/env bash

[[ $(./gradlew properties -q | grep 'isSnapshot:' | awk '{print $2}') == 'true' ]] && exit 1

__telegroo_version=$(./gradlew properties -q | grep 'telegrooVersion:' | awk '{print $2}')

mkdir -p telegroo/src/test/resources
echo "token=${TEST_BOT_TOKEN}" > telegroo/src/test/resources/test.properties

./gradlew test
./gradlew clean publish

git clone https://gitlab.com/teslex/repo

cp -r telegram-api/build/repo/* repo
cp -r telegroo-api/build/repo/* repo
cp -r telegroo-dsl/build/repo/* repo
cp -r telegroo/build/repo/* repo

cd repo

git config user.name 'teslex.bot'
git config user.email 'teslex.bot@gmail.com'

bash update_readme.sh "telegroo-stable" "$__telegroo_version"

git add .
git commit -m "Update stable telegroo"

git push https://teslex.bot:${GITLAB_PRIVATE_KEY}@gitlab.com/teslex/repo