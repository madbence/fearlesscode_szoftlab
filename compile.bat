@echo off
echo Deleting prevorious release...
rm -r -f build
mkdir build
echo Compiling...
javac -classpath .\src\ -encoding UTF-8 -d .\build\ .\src\fearlesscode\app\Grafikus.java

echo Copy resources...
xcopy .\src\fearlesscode\gui\images .\build\fearlesscode\gui\images\
xcopy .\src\fearlesscode\gui\images\menus .\build\fearlesscode\gui\images\menus\

@echo on