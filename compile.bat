@echo off
echo Deleting prevorious release...
rm -r -f bin
mkdir bin
echo Compiling...
cd src
javac -d ../bin/ fearlesscode/*.java
javac -d ../bin/ fearlesscode/util/*.java
cd ..
@echo on