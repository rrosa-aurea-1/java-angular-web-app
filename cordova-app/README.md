cordova cli 7.0.0

I have run:
- cordova create app com.amanganiello90.angular angularDashFullStack
- cordova platform add android --> 6.3.0
- cordova plugin add https://github.com/janeasystems/nodejs-mobile-cordova#staging-babel-UI-runtime
- add GRADLE_HOME system environment variable with final /bin and insert into PATH
- I copied the server-cordova.js, index.js file and nodejs app with node_modules and dist under electron-app into www folder
- cordova prepare and import project into Android studio to install NDK
- cordova run android on android 5.0.0 device
- remote debugger: https://ionic.zone/debug/remote-debug-your-app#android that is chrome://inspect 
- ip device is 127.0.0.1

