@echo off
echo Deleting prevorious release...
rm -r -f bin
mkdir bin
echo Compiling...
cd src
javac -encoding UTF-8 -d ../bin/ fearlesscode/*.java
javac -encoding UTF-8 -d ../bin/ fearlesscode/util/*.java
cd ..
@echo on