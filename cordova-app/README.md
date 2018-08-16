cordova cli 7.0.0

I have run:
- cordova create app com.amanganiello90.angular angularDashFullStack
- cordova platform add android --> 6.3.0
- cordova plugin add https://github.com/janeasystems/nodejs-mobile-cordova#staging-babel-UI-runtime
- add GRADLE_HOME system environment variable with final /bin and insert into PATH
- Add in the PATH GRADLE_HOME/tools and GRADLE_HOME/platform-tools
- I copied the server-cordova.js, index.js file and nodejs app (rename folder in nodejs-project) with node_modules and dist under electron-app into www folder
- cordova prepare and import project into Android studio to install NDK
- cordova run android on android 5.0.0 device
- remote debugger: https://ionic.zone/debug/remote-debug-your-app#android that is chrome://inspect 
- app is configured on http://localhost:8081

N.B automatize process maybe with a generator. Then the app run after a minute (or more).

