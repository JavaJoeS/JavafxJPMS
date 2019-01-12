#!/bin/bash

jlink --module-path D:\java\jdk-11\jmods;out --add-modules test.example --output build

jlink --launcher test-app=test.example/com.logicbig.example.Test  --module-path D:\java\jdk-11\jmods;out --add-modules test.example --output build