## Spring boot app with Angular 5 client embedded [![Build Status](https://travis-ci.org/amanganiello90/java-angular-web-app.svg)](https://travis-ci.org/amanganiello90/java-angular-web-app)

![Technology-Stack](https://github.com/amanganiello90/java-angular-web-app/raw/branch-screen/stack.png)

<img src="https://img.shields.io/github/forks/amanganiello90/java-angular-web-app.svg">&nbsp;
<img src="https://img.shields.io/github/stars/amanganiello90/java-angular-web-app.svg">&nbsp;<a href="https://github.com/amanganiello90/java-angular-web-app/issues"><img src="https://img.shields.io/github/issues/amanganiello90/java-angular-web-app.svg">
</a>&nbsp;<img src="https://img.shields.io/github/license/amanganiello90/java-angular-web-app.svg">&nbsp;<img src="https://img.shields.io/github/downloads/amanganiello90/java-angular-web-app/total.svg">&nbsp; [![Join the chat at https://gitter.im/amanganiello90-java-angular-web-app/Lobby](https://badges.gitter.im/amanganiello90-java-angular-web-app/Lobby.svg)](https://gitter.im/amanganiello90-java-angular-web-app/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

|Please donate whether you wish support us to give more time to app's growth | [![](https://www.paypal.com/en_US/IT/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=XTC895QYD28TC)  |
|:------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------|

The frontend-app is extended from the initial seed : https://github.com/creativetimofficial/material-dashboard-angular .

> The extension is related to create a user-profile from the UI to the integrated backend on a mongo/h2 embedded db, and a component error page ui for routing : [frontend-app changelog](https://github.com/amanganiello90/java-angular-web-app/blob/master/frontend-app/CHANGELOG.md).
The project produces **an only jar** using maven spring-boot, that is you can implement java backend services, together the angular client developed in typescript (angular-cli). 

> This is a showcase project to integrate many features listed below, but you can use this as a seed to develop your app. 
So download the zip of this branch or clone the git repo and replace **src** folder with your spring boot java code and **frontend-app** your angular 5 code.
Moreover, to use the automatic Travis deploy integration, you have only to replace the app name with your and define the HEROKU_API_KEY variable as explained in the related paragraph.



## NEWS

* 13/06/2018 Created mongodb webservice node express server app using my fork [generator-full-stack-api](https://github.com/fullStackApp/generator-full-stack-api/releases/tag/v2.0.0) in **electron-app** project.

* First Release 1.0

May 30,2018  | **Release 1.0** | available from [GitHub](https://github.com/amanganiello90/java-angular-web-app/archive/1.0.zip)  |
---- | ---- | ---- |

* 30/05/2018 Added description for the first release on the features listed in [CHANGELOG](https://github.com/amanganiello90/java-angular-web-app/blob/master/CHANGELOG.md)

* 28/09/2017 initial project with spring boot and [material angular 4 dashboard](https://github.com/creativetimofficial/material-dashboard-angular) 


## NEXT DEVELOPMENTS (checked in progress)

- [ ] Update README with api doc in node server app and modify user table list with only necessary fields
- [ ] Create h2 webservice node express server app to choose in electron-app
- [ ] Update api tests with [java cucumber](https://examples.javacodegeeks.com/core-java/junit/junit-cucumber-example/)
- [ ] Create api/ui tests in node app with [typescript cucumber](https://github.com/igniteram/protractor-cucumber-typescript)

## Table of contents

   * [Description](#description)
      * [Functional informations](#functional-informations)
      * [Prerequisites](#prerequisites)
      * [Live](#live)
      * [Build and run](#build-and-run)
      * [Rest Api integration with h2 and mongo db](#rest-api-integration-with-h2-and-mongo-db)
		* [Rest Api JSON request exposed](#rest-api-json-request-exposed)
		* [UI api call](#ui-api-call)
      	* [Using Dev Mode](#using-dev-mode)
		* [Write automatic integration api tests with rest assured](#write-automatic-integration-api-tests-with-rest-assured)
      * [Electron](#electron) 
		* [Electron live mode for frontend](#electron-live-mode-for-frontend)
		* [Electron package mode for frontend](#electron-package-mode-for-frontend)
		* [Electron with express server live mode](#electron-with-express-server-live-mode)
		* [Electron with express server package mode](#electron-with-express-server-package-mode)
		* [Spring boot jar electron live mode](#spring-boot-jar-electron-live-mode)
		* [Spring boot jar electron package mode](#spring-boot-jar-electron-package-mode)
   * [Deploy jar on heroku from your machine](#deploy-jar-on-heroku-from-your-machine)
   * [Automatic build and deploy with travis](#automatic-build-and-deploy-with-travis)
   * [Live demo heroku deployed jar](#live-demo-heroku-deployed-jar)
   
   
## Description

The project is used to develop the client in the **frontend-app** folder with the __angular-cli__, and the **java backend** with the __maven spring boot project configured__.
For this, import your client (frontend-app) in the angular/typescript IDE (i.e. __visual studio code__) and your maven java backend in __Eclipse__.
There are also many integration features that you can read in every related paragraph (electron, automatic travis deploy, single full stack jar spring boot support, etc.)


### Functional informations

The steps to build the jar are defined in the pom.xml file. The project builds the frontend with the output folder **frontend-app/dist** and copies it in the __target/classes/static__ folder in order to load the client in the spring boot home page together the java services.
The port information is stored in **src/main/resources/application.properties** file in the __server.port__ property.

### Prerequisites

* Install the angular-cli with command :

```
npm install -g @angular/cli@1.7.4
```

And generate an angular project with :

```
ng new <frontend-folder-name>
```


* Add npm build.prod script in your **<frontend-folder-name> package.json project** with @angular/cli devDependency as:

```
{
  "name": "angular-dashboard-full-stack",
  "version": "1.1.0",
  "license": "MIT",
  "author": "amanganiello90",
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
  "devDependencies"{
    "@angular/cli": "1.7.4"
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

![Live-App](https://github.com/amanganiello90/java-angular-web-app/raw/branch-screen/live-app.jpg)

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


### Rest Api integration with h2 and mongo db

You can use, according various spring profiles, an h2 embedded db, an mongodb embedded or for production.
The application exposes some rest api (**UserControllor and TimeController**) that connects to db (default application properties, h2 and mongop).

Run your application with:
* _-Dspring.profiles.active=mongo_ to use embedded mongo db (it is activated for default).
* _-Dspring.profiles.active=mongop_ to use mongo db for prod.
* _-Dspring.profiles.active=h2_ to use h2 embedded. The console is enabled with _/h2_ endpoint.


#### Rest Api JSON request exposed

There are some REST services exposed for two entities: **Time and User** that use a different db according your spring runtime profile (h2, mongo and mongop).

Every entity is a interface that maps a specific typology db table.

The fields of these entities are:

```
Time = {
String id,
String value
};

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
> If you create a time with an already existing id, it will be executed an update because the id is the mandatory primary key.

For example if you want to create a time entity with _id equal to 1_, on browser:

![Create-Time](https://github.com/amanganiello90/java-angular-web-app/raw/branch-screen/create-time.jpg)

And after to view all times created:

![List-Times](https://github.com/amanganiello90/java-angular-web-app/raw/branch-screen/list-times.jpg)

Instead, for the _user entity_ you can call using these endpoints:

* _api/users_ : **Get Request** that returns all users entities created (empty object if nothing exists)
* _api/users_ : **Post Request** that creates a user with a request mapping its fields. On success it returns the id.
* _api/users/{id}_ : **Get Request** that returns an user entity with the specified id (empty if not exists)
* _api/users/{id}_ : **Delete Request** that deletes an user entity with the specified id. On success it returns the id .
* _api/users/{id}_ : **Put Request** that updates the user with a specified id according your request fields. On success it returns the user object updated.

**:warning:**
> If you create an user with an already existing id, it will be executed an update because the id is the mandatory primary key.

#### UI api call 

You can create and update an user on the _user profile dashboard_. After successfull creation or update, you are redirected to the _user list dashboard_ where are listed all users. On this you can delete and view a user.

So **all user entity api** are called by the UI .

So as example.

Insert all data for required fields (email not mandatory) to enable **CREATE USER** button and click on:

![List-Times](https://github.com/amanganiello90/java-angular-web-app/raw/branch-screen/create-ui.jpg)

After creation you will be redirect on the page where are **listed all created users**:

![List-User-Ui](https://github.com/amanganiello90/java-angular-web-app/raw/branch-screen/list-user-ui.jpg)

You can delete or update an user. If you click on edit button (pencil icon), you will be send on the **User Profile page to update**:

![Update-User-Ui](https://github.com/amanganiello90/java-angular-web-app/raw/branch-screen/update-user-ui.jpg)

Now the id is blocked, and you can modify all fields. After click on the **UPDATE USER** button in order to perform action, and you will review the changing on the **User List page**.


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

You can use your frontend app, full app with express server, spring boot jar app in an electron live process or in a standalone distribution package.
In the only frontend app, you can use shortcuts to inspect or reload the frontend application, due to integration with [electron-debug](https://github.com/sindresorhus/electron-debug).
Find all explanations on its README.md file.

> In all three typologies there is the _npm run package_ command that use **electron-builder**. It generates a package for the your current running platform.
In the distribution folder there is also the unpacked app (as electron-packager does).


#### Electron live mode for frontend 

After built your front-end app with the **-Pbuild-ui** profile (or with *npm run build.prod* command under frontend-app folder), run in the **electron-client** folder these commands:


* npm install
* npm start

App in electron:

![Electron-App](https://github.com/amanganiello90/java-angular-web-app/raw/branch-screen/electron-app.jpg)

In this way **only your frontend**,  is running in the electron container and you can use the **electron-debug utility**.


#### Electron package mode for frontend 

After built your front-end app with the **-Pbuild-ui** profile (or with *npm run build.prod* command under frontend-app folder), run in the **electron-client** folder these commands:


* npm install
* npm run package


After this, you will have a single **electron-app-client 1.0.0** (for windows will be an .exe) to run with a click under **electron-client\distribution** folder.
**The file created is a standalone distributable desktop app that not require Node or JRE on your machine to be executed.**
In this way, **only your frontend**, is run in the electron container as a package and you can use the **electron-debug utility**.


#### Electron with express server live mode

After built your front-end app with the **-Pbuild-ui** profile (or with *npm run build.prod* command under frontend-app folder), run in the **electron-app** folder these commands:


* npm install
* npm start


In this way **your frontend app with the express server side**,  is running in the electron container. You can read log in its window with **F1 keyword**.

> The express server is a child spawn localhost process that is in listening in the port declared in the _process.env.PORT_ variable, else it uses the port declared in the **electron-app/electron.app.config.json** file.
So you can also open the browser on _localhost:8081_ (default port) to inspect page. 


Express log in electron:

![Electron-Log](https://github.com/amanganiello90/java-angular-web-app/raw/branch-screen/electron-log.jpg)


#### Electron with express server package mode

After built your front-end app with the **-Pbuild-ui** profile (or with *npm run build.prod* command under frontend-app folder), run in the **electron-app** folder these commands:


* npm install
* npm run package


After this, you will have a single **electron-app 1.0.0** (for windows will be an .exe) to run with a click under **electron-app\distribution** folder.
**The file created is a standalone distributable desktop app that not require Node or JRE on your machine to be executed.**
In this way **your frontend app with the express server side**,  is running in the electron container. You can read log in its window with **F1 keyword**.

> The express server is a child spawn localhost process that is in listening in the port declared in the _process.env.PORT_ variable, else it uses the port declared in the **electron-app/electron.app.config.json** file.
So you can also open the browser on _localhost:8081_ (default port) to inspect page. 


#### Spring boot jar electron live mode 

After generated your spring boot jar with **mvn clean package**, run in the **electron-jar** folder these steps:


* npm install
* npm start

In this way the spring boot jar start as child process in the electron container. You can read log in its window with **F1 keyword**.

> The jar is a child spawn localhost process that is in listening in the port declared in the _process.env.PORT_ variable, else it uses the port declared in the **electron-app/electron.app.config.json** file.
So you can also open the browser on _localhost:8081_ (default port) to inspect page. 

Spring Boot log in electron:

![Electron-Spring](https://github.com/amanganiello90/java-angular-web-app/raw/branch-screen/electron-spring.jpg)

#### Spring boot jar electron package mode

After generated your spring boot jar with **mvn clean package**, run in the **electron-jar** folder these steps:


* npm install
* npm run package

After this, you will have a single **electron-jar 1.0.0** (for windows will be an .exe) to run with a click under **electron-jar\distribution** folder.
**The file created is a standalone distributable desktop app that not require Node but the JRE is mandatory on your machine to be executed.**
In this way the spring boot jar is packaged and it run in the electron container as a child process. You can read log in its window with **F1 keyword**.

![Electron-Dist](https://github.com/amanganiello90/java-angular-web-app/raw/branch-screen/electron-dist.jpg)


> The jar is a child spawn localhost process that is in listening in the port declared in the _process.env.PORT_ variable, else it uses the port declared in the **electron-app/electron.app.config.json** file.
So you can also open the browser on _localhost:8081_ (default port) to inspect page. 


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

