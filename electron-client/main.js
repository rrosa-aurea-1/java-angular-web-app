const electron = require("electron"),
app = electron.app,
BrowserWindow = electron.BrowserWindow;

require('electron-debug')({
	enabled: true
});
let mainWindow;
const fs = require('fs');
let url = `${__dirname}/dist/index.html`;
const globalShortcut = electron.globalShortcut;

function createWindow() {
	mainWindow = new BrowserWindow({
			autoHideMenuBar: true,
			width: 640,
			height: 480,
			webPreferences: {
				nodeIntegration: false
			}
		});
	mainWindow.loadURL(url);
	//mainWindow.webContents.openDevTools();
	mainWindow.on("closed", function () {
		mainWindow = null;
	});

	globalShortcut.register('f5', function () {
		reloadPage();
	});
	globalShortcut.register('CommandOrControl+R', function () {
		reloadPage();
	});
}

function reloadPage() {
	var currentURL = mainWindow.webContents.getURL();
	let urlWithoutFileProtocol = currentURL.split('file:///');
	currentURL = urlWithoutFileProtocol[1];
	try {
		if (fs.statSync(currentURL).isFile()) {
			mainWindow.reload();
		} else {
			mainWindow.loadURL(url);
		}
	} catch (err) {
		mainWindow.loadURL(url);
	}
}

app.on("ready", createWindow);
app.on("browser-window-created", function (e, window) {
	window.setMenu(null);
});

app.on("window-all-closed", function () {
	if (process.platform !== "darwin") {
		app.quit();
	}
});

app.on("activate", function () {
	if (mainWindow === null) {
		createWindow();
	}
});
