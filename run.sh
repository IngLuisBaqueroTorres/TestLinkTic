#!/bin/bash

dos2unix gradlew

./gradlew bootRun -PjvmArgs="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" &

while true; do
  inotifywait -e modify,create,delete,move -r ./src/ && ./gradlew classes
done
