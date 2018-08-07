
// Wait for device API libraries to load
document.addEventListener("deviceready", onDeviceReady, false);
// device APIs are available
function onDeviceReady() {
	webserver.onRequest(
		function (request) {
		console.log("This is the request: ", request);

		webserver.sendResponse(
			request.responseId, {
			status: 200,
			body: '<html>Hello World</html>',
			headers: {
				'Content-Type': 'text/html'
			}
		});
	});

	// Starts webserver with default port 8080
	webserver.start();

	//... after a long long time
	// stop the server
	webserver.stop();
}

