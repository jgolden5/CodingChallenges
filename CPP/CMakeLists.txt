cmake_minimum_required(VERSION 4.2)

project(Codewars)

set(SOURCES
  src/main.cpp
  src/combat.cpp
  #src/basic.cpp
  #src/correct.cpp
  #src/sentence_smash.cpp
  #include/correct.h
  #include/sentence_smash.h
  #include/basic.h
  include/combat.h
)

add_executable(codewars_run ${SOURCES})
