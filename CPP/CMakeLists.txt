cmake_minimum_required(VERSION 4.2)

project(Codewars)

set(SOURCES
  src/main.cpp
  src/findDeletedNumber.cpp
  include/findDeletedNumber.h
)

add_executable(codewars_run ${SOURCES})
