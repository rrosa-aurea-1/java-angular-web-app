cordova cli 7.0.0

I have run:
- cordova create app com.amanganiello90.angular angularDashFullStack
- cordova platform add android --> 6.3.0
- cordova plugin add https://github.com/janeasystems/nodejs-mobile-cordova#staging-babel-UI-runtime
- add GRADLE_HOME system environment variable with final /bin and insert into PATH
- Add in the PATH ANDROID_HOME/tools and ANDROID_HOME/platform-tools
- I copied the server-cordova.js, index.js file and nodejs app (rename folder in nodejs-project) with node_modules and dist under electron-app into www folder
- cordova prepare and import project into Android studio to install NDK
- cordova run android on android 6.0.0 device
- remote debugger: https://ionic.zone/debug/remote-debug-your-app#android that is chrome://inspect 
- app is configured on http://localhost:8081


Future Needs:


- rename electron.app.config with config.json
- delete api, config.json, package.json (saving that is needed) from electron-app and insert all in a new node-app folder (full nodejs app with angular dist)
- electron-app will copy node-app under it that has its package.json, index.js, server.js and .env
- cordova-app with www (has the cordova-server.js and its index.js and package.json) and copies all node-app with dist renamed nodejs-project
- rename frontend-app with client.
- update my generator with electron app and cordova app

All folders are in the same level... 

N.B automatize process maybe with a generator. Then the cordova app run after a minute (or more). Maybe a module for jhipster