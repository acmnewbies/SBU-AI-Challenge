#!/bin/bash
cd src/main/java/Network/ClientSide/uploadedCode/
g++ uploadedCode.cpp -o uploadedCode -Wall -g -O2 -std=c++11
./uploadedCode
