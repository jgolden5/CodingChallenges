#!/bin/bash

og_dir="$(pwd)"
args="$@"
debug="$1"
ERROR_GENERIC=1
ERROR_COMPILE_FAIL=2
ERROR_LAUNCH_FAIL=3

cd ~/CodingChallenges/JavaKata

javac Leetcode/*.java
if [[ "$debug" == '-d' ]]; then
  if [[ $? == 0 ]]; then
    echo "✅ Java compiled successfully"
  else
    echo "❌ Java failed to compile"
    exit $ERROR_COMPILE_FAIL
  fi
fi

java Leetcode/Main
if [[ "$debug" == '-d' ]]; then
  if [[ $? == 0 ]]; then
    echo "✅ Java launched successfully"
  else
    echo "❌ Java failed to launch"
    exit $ERROR_LAUNCH_FAIL
  fi
fi
rm -I Leetcode/*.class
cd "$og_dir"
