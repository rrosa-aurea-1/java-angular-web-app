cordova cli 7.0.0

I have run:
- cordova create app com.amanganiello90.angular angularDashFullStack
- cordova platform add android --> 6.3.0
- cordova plugin add nodejs-cordova-plugin
- add GRADLE_HOME system environment variable with final /bin and insert into PATH
- Add in the PATH ANDROID_HOME/tools and ANDROID_HOME/platform-tools
- I copied the server-cordova.js, index.js file and nodejs app (rename folder in nodejs-project) with node_modules and dist under electron-app into www folder
- Added DevDependencies manually in the cordova-app/app/package.json
- Deleted platforms and plugins folders
- cordova prepare and import project into Android studio to install NDK
- export ANDROID_NDK_HOME=/Users/username/Library/Android/sdk/ndk-bundle
- cordova run android on android 6.0.0 device
- remote debugger: https://ionic.zone/debug/remote-debug-your-app#android that is chrome://inspect 
- app is configured on http://localhost:8081

Future Needs:

- use nodejs-project (contains node api and angular dist) under www also for electron-app project 
- rename frontend-app with angular-project.
- update my full-stack-generator with electron app and cordova app

All folders are in the same level... SOME FEATURES ARE BEEN ALREADY DEVELOPED IN WWW/NODEJS-PROJECT FOLDER.
I Have before added a ```www/NODEJS_MOBILE_BUILD_NATIVE_MODULES_VALUE.txt``` with ```0``` value to avoid rebuild native modules. 
Now you can run:


To run cordova project before execute:
- Run ```npm install``` under www/nodejs-project

After one of this according your requirement:
1) Run ```npm start``` app folder to run emulator with apk built
2) Run ```npm run build``` under app folder to build apk

N.B automatize process maybe with a generator. Then the cordova app run after a minute (or more). Maybe a module for jhipster
