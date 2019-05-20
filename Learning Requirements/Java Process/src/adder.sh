#!/bin/bash
cd /home/roozbeh/MyApps/university/Term\ 4/SBU-AI-Challenge/Learning\ Requirements/Java\ Process/src/
CLASSFILE=TwoNumbersAdder.class
if [ -f "$CLASSFILE" ]; then
	java TwoNumbersAdder
else
	javac TwoNumbersAdder.java
	java TwoNumbersAdder
fi
