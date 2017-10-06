01 if exist "%CATALINA_HOME%\bin\setenv.bat" call "%CATALINA_HOME%\bin\setenv.bat"
02 if exist "%CATALINA_HOME%\bin\setclasspath.bat" goto okSetclasspath
03 echo Cannot find %CATALINA_HOME%\bin\setclasspath.bat
04 goto end
05 :okSetclasspath
06 set BASEDIR=%CATALINA_HOME%
07 call "%CATALINA_HOME%\bin\setclasspath.bat"
08 set CLASSPATH=%CLASSPATH%;%CATALINA_HOME%\bin\bootstrap.jar
09 if not "%CATALINA_BASE%" == "" goto gotBase
10 set CATALINA_BASE=%CATALINA_HOME%
11 :gotBase
12 if not "%CATALINA_TMPDIR%" == "" goto gotTmpdir
13 set CATALINA_TMPDIR=%CATALINA_BASE%\temp
14 :gotTmpdir
15 echo Using CATALINA_BASE:   %CATALINA_BASE%
16 echo Using CATALINA_HOME:   %CATALINA_HOME%
17 echo Using CATALINA_TMPDIR: %CATALINA_TMPDIR%
18 echo Using JAVA_HOME:       %JAVA_HOME%
19 set _EXECJAVA=%_RUNJAVA%
20 set MAINCLASS=org.apache.catalina.startup.Bootstrap
21 set ACTION=start
22 if ""%1"" == ""start"" goto doStart
23 if ""%1"" == ""stop"" goto doStop
24 :doStart
25 if not "%OS%" == "Windows_NT" goto noTitle
26 set _EXECJAVA=start "Tomcat" %_RUNJAVA%
27 goto gotTitle
28 :noTitle
29 set _EXECJAVA=start %_RUNJAVA%
30 :gotTitle
31 goto execCmd
32 :doStop
33 set ACTION=stop
34 :execCmd
35 %_EXECJAVA% %JAVA_OPTS% %CATALINA_OPTS% %DEBUG_OPTS% -Djava.endorsed.dirs="%JAVA_ENDORSED_DIRS%" -classpath "%CLASSPATH%"  -Dcatalina.base="%CATALINA_BASE%" -Dcatalina.home="%CATALINA_HOME%" -Djava.io.tmpdir="%CATALINA_TMPDIR%" %MAINCLASS%  %CMD_LINE_ARGS% %ACTION%
36 :end