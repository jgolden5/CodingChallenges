cmake_minimum_required(VERSION 4.2)

project(Codewars)

set(SOURCES
  src/main.cpp
  src/friendOrFoe.cpp
  include/friendOrFoe.h
)

add_executable(codewars_run ${SOURCES})
