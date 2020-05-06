var exec = require("cordova/exec");

var PLUGIN_NAME = "Bluetoothadapters";

var Bluetoothadapters = {
  saludo: function (name, successCallback, errorCallback) {
    exec(successCallback, errorCallback, PLUGIN_NAME, "saludar", [name]);
  },
};

module.exports = Bluetoothadapters;
