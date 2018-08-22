
var app = {
    // Application Constructor
    initialize: function() {
        document.addEventListener('deviceready', this.onDeviceReady.bind(this), false);
    },

    // deviceready Event Handler
    //
    // Bind any cordova events here. Common events are:
    // 'pause', 'resume', etc.
    onDeviceReady: function() {
            startNodeProject('server.js');

    }
};

function visualizeButton(){
    document.getElementById('ready').setAttribute('style','display:block;');
    document.getElementById('loading').setAttribute('style','display:none;');
}

function clickButton(){
     var ref = window.open('http://localhost:8081', '_self');
}

function startNodeProject(startFile) {
    nodejs.start(startFile, function (err)  {
        if(err) {
                console.log('The nodejs-mobile engine not started for error: '+err);
        } else {
            console.log('The nodejs-mobile engine started successfully.')
            setTimeout(visualizeButton(), 2000);

        }
    });
};


app.initialize();