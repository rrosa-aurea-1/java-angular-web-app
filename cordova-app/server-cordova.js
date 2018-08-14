var expectToFail=false;

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


function startNodeProject(startFile) {
    nodejs.start(startFile, function (err)  {
        if(err) {
            if (err === 'Engine already started') {
                // Engine already started. Let the user go to the tests.
                alert('The nodejs-mobile engine is already started.<br/>Proceed to the tests.');

            } else {
                var msg = 'Engine start failed with this error:<br/>' + err;
                if (err === 'File not found' && expectToFail) {
                    msg += '<br/>This error was expected. TEST PASS';
                } else {
                    msg += '<br/>This error was not expected. TEST FAIL';
                }
                alert(msg);
            }
        } else {
            var msg = 'The nodejs-mobile engine started successfully.';
            if(expectToFail) {
                msg += '<br/>This was not expected. TEST FAIL';
            } else {
                msg += '<br/>This was expected. TEST PASS<br/>Proceed to the tests.';
            }
            alert(msg);
        }
    });
};


app.initialize();