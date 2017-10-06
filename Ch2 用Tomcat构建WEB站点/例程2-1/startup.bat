01 @echo off
02 if "%OS%" == "Windows_NT" setlocal
03 rem Guess CATALINA_HOME if not defined
04 if not "%CATALINA_HOME%" == "" goto gotHome
05 set CATALINA_HOME=.
06 if exist "%CATALINA_HOME%\bin\catalina.bat" goto okHome
07 set CATALINA_HOME=..
08 :gotHome
09 if exist "%CATALINA_HOME%\bin\catalina.bat" goto okHome
10 echo The CATALINA_HOME environment variable is not defined correctly
11 goto end
12 :okHome
13 set EXECUTABLE=%CATALINA_HOME%\bin\catalina.bat
14 set CMD_LINE_ARGS=
15 :setArgs
16 if ""%1""=="""" goto doneSetArgs
17 set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
18 shift
19 goto setArgs
20 :doneSetArgs
21 call "%EXECUTABLE%" start %CMD_LINE_ARGS%
22 :end