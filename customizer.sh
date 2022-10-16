#!/bin/bash

# Verify bash version. macOS comes with bash 3 preinstalled.
if [[ ${BASH_VERSINFO[0]} -lt 4 ]]
then
  echo "You need at least bash 4 to run this script."
  exit 1
fi

# exit when any command fails
set -e

if [[ $# -lt 2 ]]; then
   echo "Usage: bash customizer.sh my.new.package [ApplicationName]" >&2
   exit 2
fi

PACKAGE=$1
APPNAME=$2
SUBDIR=${PACKAGE//.//} # Replaces . with /

for n in $(find . -type d -path '*/src/main')
do
  if [[ $n != *"buildSrc"* ]]; then
    echo "Creating $n/java/$SUBDIR"
    mkdir -p $n/java/$SUBDIR
    echo "Moving files to $n/java/$SUBDIR"
    mv $n/java/tech/antee/compose_multimodule_template/* $n/java/$SUBDIR
    echo "Removing old $n/java/tech/antee/compose_multimodule_template"
    rm -rf mv $n/java/android
  fi
done

# Rename package and imports
echo "Renaming packages to $PACKAGE"
find ./ -type f -name "*.kt" -exec sed -i.bak "s/package tech.antee.compose_multimodule_template/package $PACKAGE/g" {} \;
find ./ -type f -name "*.kt" -exec sed -i.bak "s/import tech.antee.compose_multimodule_template/import $PACKAGE/g" {} \;
find ./ -type f -name "*.xml" -exec sed -i.bak "s/tech.antee.compose_multimodule_template/$PACKAGE/g" {} \;

# Gradle files
find ./ -type f -name "*.kts" -exec sed -i.bak "s/tech.antee.compose_multimodule_template/$PACKAGE/g" {} \;


echo "Cleaning up"
find . -name "*.bak" -type f -delete

#  Rename app
if [[ $APPNAME ]]
then
    echo "Renaming app to $APPNAME"
    find ./ -type f \( -name "MyApplication.kt" -or -name "settings.gradle.kts" -or -name "*.xml" \) -exec sed -i.bak "s/MyApplication/$APPNAME/g" {} \;
    find ./ -name "MyApplication.kt" | sed "p;s/MyApplication/$APPNAME/" | tr '\n' '\0' | xargs -0 -n 2 mv
    find . -name "*.bak" -type f -delete
fi

echo "Done"

