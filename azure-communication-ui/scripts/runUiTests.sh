#!/usr/bin/env bash

unset ANDROID_SERIAL
DEVICE=($(adb devices | grep "device$" | sed -e "s|device||g"))
if [ -z "$DEVICE" ]; then
  ./installEmulator.sh
fi

cd ..
#Replace ACS Token with expired token
cat ./local.properties | sed -e '/^ACS_TOKEN=/d' > ./temp_file
printf "ACS_TOKEN=\"$1\"\n" >> ./temp_file
mv -f ./temp_file ./local.properties

# run Ui tests with the required parameters
./gradlew clean cDAT -Pandroid.testInstrumentationRunnerArguments.teamsUrl="$2" -Pandroid.testInstrumentationRunnerArguments.groupId="$3" -Pandroid.testInstrumentationRunnerArguments.acsToken=$4

# clean up
if [ -z "$DEVICE" ]; then
  adb emu kill
  $ANDROID_HOME/tools/bin/avdmanager delete avd -n xamarin_android_emulator
fi
