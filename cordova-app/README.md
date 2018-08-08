cordova cli 8.0.0

I have run:
- cordova create app com.amanganiello30.angular angularDashFullStack
- cordova platform add android --> 7.0.0
- cordova plugin add https://github.com/fullStackApp/cordova-plugin-local-webserver
- cordova plugin add cordova-sqlite-storage
- add GRADLE_HOME system environment variable with final /bin and insert into PATH
- I copied the server-cordova.js file into www together the dist app builded and inject as javascript script in index.html
- add in head tag of index.html also  <script src="cordova.js" type="text/javascript"></script>
- cordova run android
- remote debugger: https://ionic.zone/debug/remote-debug-your-app#android that is chrome://inspect 
- ip device is 127.0.0.1

