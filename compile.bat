@echo off
echo Deleting prevorious release...
cd bin
rm -r -f *
cd ..
echo Compiling...
cd src
javac -d ../bin/ fearlesscode/*.java
javac -d ../bin/ fearlesscode/util/*.java
cd ..
@echo on