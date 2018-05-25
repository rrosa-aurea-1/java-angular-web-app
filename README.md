## Spring boot app with Angular 4 client embedded [![Build Status](https://travis-ci.org/amanganiello90/java-angular-web-app.svg?label=travis)](https://travis-ci.org/amanganiello90/java-angular-web-app)

![Technology-Stack](https://github.com/amanganiello90/java-angular-web-app/blob/branch-screen/stack.png)

<img src="https://img.shields.io/github/forks/amanganiello90/java-angular-web-app.svg">&nbsp;
<img src="https://img.shields.io/github/stars/amanganiello90/java-angular-web-app.svg">&nbsp;<a href="https://github.com/amanganiello90/java-angular-web-app/issues"><img src="https://img.shields.io/github/issues/amanganiello90/java-angular-web-app.svg">
</a>&nbsp;<img src="https://img.shields.io/github/license/amanganiello90/java-angular-web-app.svg">&nbsp;<img src="https://img.shields.io/github/downloads/amanganiello90/java-angular-web-app/total.svg">&nbsp; [![Join the chat at https://gitter.im/amanganiello90-java-angular-web-app/Lobby](https://badges.gitter.im/amanganiello90-java-angular-web-app/Lobby.svg)](https://gitter.im/amanganiello90-java-angular-web-app/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

|Please donate whether you wish support us to give more time to app's growth | [![](https://www.paypal.com/en_US/IT/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=XTC895QYD28TC)  |
|:------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------|

The frontend-app is extended from the initial seed : https://github.com/creativetimofficial/material-dashboard-angular .

> The extension is related to create a user-profile from the UI to the integrated backend on a mongo/h2 embedded db, and a component error page ui for routing.
The project produces **an only jar** using maven spring-boot, that is you can implement java backend services, together the angular client developed in typescript (angular-cli). Download the zip of this branch or clone the git repo.


## NEWS

* 25/05/2018 UI integration for create user and user list table view [Issue 4](https://github.com/amanganiello90/java-angular-web-app/issues/4) 
* 21/05/2018 first integration with embedded h2/mongo db used by rest api and JUnit automatic api test (Product and time examples) [Issue 3](https://github.com/amanganiello90/java-angular-web-app/issues/3) 
* 03/04/2018 added embedded [node](https://nodejs.org/dist/v9.4.0/win-x64/) for express in electron-app-exe folder using electron-packager
* 23/03/2018 refer to resolved [Issue 2](https://github.com/amanganiello90/java-angular-web-app/issues/2) related to add [travis ci](https://travis-ci.org/) and automatic deploy on [keroku](https://www.heroku.com/) with .travis-deploy-heroku.sh file 
* 05/03/2018 added spring boot jar child process mode running in electron app
* 05/03/2018 added express server external process in electron app to live angular app built
* 02/03/2018 refer to resolved [Issue 1](https://github.com/amanganiello90/java-angular-web-app/issues/1) related the routing of single page app in spring boot tomcat server


## NEXT DEVELOPMENTS (checked in progress)

- [x] Implement user list ui delete and update row on click table
- [ ] Integrate mongodb (and h2) and webservice in node express server
- [ ] Use embedded jre for jar in electron


## Table of contents

   * [Description](#description)
      * [Functional informations](#functional-informations)
      * [Prerequisites](#prerequisites)
      * [Live](#live)
      * [Build and run](#build-and-run)
      * [Api integration with h2 and mongo db](#api-integration-with-h2-and-mongo-db)
		* [Api exposed](#api-exposed)
		* [UI api call](#ui-api-call)
      	* [Using Dev Mode](#using-dev-mode)
		* [Write automatic integration api tests with rest assured](#write-automatic-integration-api-tests-with-rest-assured)
      * [Electron](#electron) 
		* [Express server mode](#express-server-mode)
		* [Spring boot jar mode](#spring-boot-jar-mode)
		* [Express server electron packager exe mode](#express-server-electron-packager-exe-mode)
   * [Deploy jar on heroku from your machine](#deploy-jar-on-heroku-from-your-machine)
   * [Automatic build and deploy with travis](#automatic-build-and-deploy-with-travis)
   * [Live demo heroku deployed jar](#live-demo-heroku-deployed-jar)

  
## Description

The project is used to develop the client in the **frontend-app** folder with the __angular-cli__, and the **java backend** with the __maven spring boot project configured__.
For this, import your client (frontend-app) in the angular/typescript IDE (i.e. __visual studio code__) and your maven java backend in __Eclipse__.

### Functional informations

The steps to build the jar are defined in the pom.xml file. The project builds the frontend with the output folder **frontend-app/dist** and copies it in the __target/classes/static__ folder in order to load the client in the spring boot home page together the java services.
The port information is stored in **src/main/resources/application.properties** file in the __server.port__ property.

### Prerequisites


* Add npm build.prod script in your **front-end package.json project** with @angular/cli devDependency as:

```
{
  "name": "md-free-angular-cli",
  "version": "1.4.1",
  "license": "MIT",
  "scripts": {
    "ng": "ng",
    "start": "ng serve",
    "build": "ng build",
    "build.prod": "ng build --prod",
    "test": "ng test",
    "lint": "ng lint",
    "e2e": "ng e2e"
  },
  "private": true,
  "dependencies": {
    ....
  },
  "devDependencies": {
    "@angular/cli": "1.4.2",
	....
  }
}
```

* JDK 8 (set JAVA_HOME environment variable)

* The Node.js version compatible with your angular app

* MAVEN (to use **mvn** command else use in windows ./mvnw.cmd or in linux ./mvnw instead)

* IDE ( i.e. Eclipse for java and visual studio code for typescript/angular projects)

### Live

Execute in the main folder of this repo, if you have already built the frontend and there is the generated code in **frontend-app/dist** :

```
mvn clean spring-boot:run
```
else:

```
mvn clean spring-boot:run -Pbuild-ui
```

Open browser on localhost:8081:

![Live-App](https://github.com/amanganiello90/java-angular-web-app/blob/branch-screen/live-app.jpg)

### Build and run

If you have already built the frontend (i. e. after develop on visual studio code) and you have the generated code of the _ng build_ in **frontend-app/dist**, execute in the main folder of this repo:

```
mvn clean package
```

If you want to build also the frontend, run:

```
mvn clean package -Pbuild-ui
```

After all cases run:

```
java -jar target/*.jar
```

Open browser on localhost:8081


### Api integration with h2 and mongo db

You can use, according various spring profiles, an h2 embedded db, an mongodb embedded or for production.
The application exposes some rest api (**UserControllor and TimeController**) that connects to db (default application properties, h2 and mongop).

Run your application with:
* _-Dspring.profiles.active=mongo_ to use embedded mongo db (it is activated for default).
* _-Dspring.profiles.active=mongop_ to use mongo db for prod.
* _-Dspring.profiles.active=h2_ to use h2 embedded. The console is enabled with _/h2_ endpoint.


#### Api exposed

There are some REST services exposed for two entities: **Time and User** that use a different db according your spring runtime profile (h2, mongo and mongop).

Every entity is a interface that maps a specific typology db table.

The fields of these entities are:

```
Time = {
String id,
String value
}

User= {
String id,
String username,
String email,
String firstname,
String lastname
}

```

For the _time entity_ you can call using these endpoints:

* _api/times_ : **Get Request** that returns all time entities created (empty object if nothing exists)
* _api/times/{id}_ : **Get Request** that creates a time entity with your specified id. The value field is set with the your current time. 
* _api/times/find/{id}_ : **Get Request** that returns a time entity with the specified id (empty object if not exists)

**:warning:**
> If you create a time with an already existing id, it will be executed an update.

Instead, for the _user entity_ you can call using these endpoints:

* _api/users_ : **Get Request** that returns all users entities created (empty object if nothing exists)
* _api/users_ : **Post Request** that creates a user with a request mapping its fields. On success it returns the id.
* _api/users/{id}_ : **Get Request** that returns an user entity with the specified id (empty if not exists)
* _api/users/{id}_ : **Delete Request** that deletes an user entity with the specified id. On success it returns the id .
* _api/users/{id}_ : **Put Request** that updates the user with a specified id according your request fields. On success it returns the user object updated.

**:warning:**
> If you create an user with an already existing id, it will be executed an update.

#### UI api call 

You can create an user on the _user profile dashboard_. After successfull creation, you are redirected to the _user list dashboard_ where are listed all users created.

So the api called from the UI are:

* _api/users_ : **Post Request** that creates a user with a request mapping its fields. On success it returns the id.
* _api/users_ : **Get Request** that returns all users entities created (empty object if nothing exists)


#### Using Dev Mode

You can use the live reload for spring boot when you use the spring-boot-plugin.

Run:

```
mvn clean spring-boot:run -Pdev
```

**:warning:**
> In this mode you can't pass spring profiles and all properties (i.e. server.port). So modify the _application.properties_ in spring.profiles.default property with your profile.



#### Write automatic integration api tests with rest assured

You can write integration api tests with rest assured. In the JUnit test spring-boot is automatically run and performed your @Test.
See the **JavaFullStackTest.java** example in _src/test/java/**_ path.
The test is a normal JUnit test run also by the surefire maven plugin and maven test phase.

### Electron 

#### Express server mode 

After built your front-end app with the **-Pbuild-ui** profile (or with *npm run build.prod* command under frontend-app folder), run in the **electron-app** folder these commands:


* npm install
* npm start

App in electron:

![Electron-App](https://github.com/amanganiello90/java-angular-web-app/blob/branch-screen/electron-app.jpg)

In this way a express server child process is run in the electron container. You can read log in its window with **F1 keyword**.

Express log in electron:

![Electron-Log](https://github.com/amanganiello90/java-angular-web-app/blob/branch-screen/electron-log.jpg)


#### Spring boot jar mode 

After generated your spring boot jar with **mvn clean package**, run in the **electron-jar** folder these steps:


* npm install
* copy the app.jar under target in electron-jar folder
* npm start

In this way spring boot jar start as child process in the electron container. You can read log in its window with **F1 keyword**.

Spring Boot log in electron:

![Electron-Spring](https://github.com/amanganiello90/java-angular-web-app/blob/branch-screen/electron-spring.jpg)

#### Express server electron packager exe mode 

After built your front-end app with the **-Pbuild-ui** profile (or with *npm run build.prod* command under frontend-app folder), run in the **electron-app-exe** folder these commands:


* npm install
* copy the dist folder under frontend-app in electron-app-exe folder
* npm run package


After this, you will have an **electron-app.exe** to run under **electron-app-exe\distribution\electron-app-win32-ia32** folder.
In this way a express server child process is run in the electron container. You can read log in its window with **F1 keyword**.


## Deploy jar on heroku from your machine


Create an account on [keroku](https://www.heroku.com/) .

After install the __heroku-cli__

```
npm install -g heroku-cli
```

Then:

```
heroku plugins:install heroku-cli-deploy

heroku create spring-boot-angular-app2  --no-remote

```

To deploy the jar file, execute in the main folder of this repo:

```
heroku deploy:jar target/app.jar --app spring-boot-angular-app2
```

View [app](https://spring-boot-angular-app2.herokuapp.com/)

## Automatic build and deploy with travis

You can configure your git repo for continuous integration with [travis](https://travis-ci.org/) .

For the configuration travis will use the **.travis.yml** and **.travis-deploy-heroku.sh** files.

Then, for your repo you have to configure only two things:

* Replace your heroku deploy app name in the **.travis-deploy-heroku.sh** (here *spring-boot-angular-app* with *spring-boot-angular-app2*) that before you have created on heroku with the command (or heroku dashboard):

```
heroku create spring-boot-angular-app2  --no-remote

```

* Set the HEROKU_API_KEY environment variable on travis. You can retrieve it after these commands on your machine:

```
heroku login
heroku auth:token

```
The last display the token that you will set in the HEROKU_API_KEY variable. 
It allows travis to have permission to deploy on heroku.

## Live demo heroku deployed jar

A demo with default mongo embedded db [app](https://spring-boot-angular-app.herokuapp.com/)

