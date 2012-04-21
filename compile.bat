@echo off
echo Deleting prevorious release...
rm -r -f build
mkdir build
echo Compiling...
javac -classpath .\src\ -encoding UTF-8 -d .\build\ .\src\fearlesscode\app\Grafikus.java
@echo on