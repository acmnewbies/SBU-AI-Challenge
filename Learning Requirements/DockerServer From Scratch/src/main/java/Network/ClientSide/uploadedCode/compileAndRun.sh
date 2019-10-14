#!/bin/bash
cd Network/ClientSide/uploadedCode/
g++ uploadedCode.cpp -o uploadedCode -Wall -g -O2 -std=c++11
./uploadedCode

#python3 uploadedCode.py

#javac UploadedCode.java
#java UploadedCode
