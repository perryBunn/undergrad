#!/bin/bash
make -f ./Makefile || exit
echo "Running output file in \"out\" directory..."
echo "> ./out/output"
./out/output