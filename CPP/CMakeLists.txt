cmake_minimum_required(VERSION 4.2)

project(Codewars)

set(SOURCES
  main.cpp
  sentence_smash.cpp
)

add_executable(codewars_run ${SOURCES})
