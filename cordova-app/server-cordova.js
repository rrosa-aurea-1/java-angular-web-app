// Wait for device API libraries to load
document.addEventListener("deviceready", onDeviceReady, false);

// device APIs are available
  function onDeviceReady() {
        startServer("");
    }

    function startServer( wwwroot ) {
    	
    	    httpd.getURL(function(url){
    	    	    httpd.startServer({
    	    	    	'www_root' : wwwroot,
    	    	    	'port' : 8080
    	    	    }, function( url ){
        	    		document.getElementById('url').innerHTML = "server is started: <a href='" + url + "' target='_blank'>" + url + "</a>";
    	    	    }, function( error ){
    	    	    	alert('failed to start server');
    	    	    });
    	    	
    	    	
    	    },function(){});
    	
    }