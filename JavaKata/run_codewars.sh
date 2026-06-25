#!/bin/bash

JAVA_COMPILE_FAIL=1
JAVA_RUN_FAIL=2

rm Codewars/*.class 2>/dev/null
javac Codewars/*.java
if [[ $? != 0 ]]; then
  exit $JAVA_COMPILE_FAIL
fi
java Codewars/Main
if [[ $? != 0 ]]; then
  exit $JAVA_RUN_FAIL
fi
rm Codewars/*.class
