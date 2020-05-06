var exec = require("cordova/exec");

var PLUGIN_NAME = "Bluetoothadapter";

var Bluetoothadapter = {
  saludo: function (name, successCallback, errorCallback) {
    exec(successCallback, errorCallback, PLUGIN_NAME, "saludar", [name]);
  },
};

module.exports = Bluetoothadapter;
