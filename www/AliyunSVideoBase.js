var exec = require('cordova/exec');

exports.test = function (arg0, success, error) {
    exec(success, error, 'AliyunSVideoBase', 'test', [arg0]);
};

exports.startRecord = function (arg0, success, error) {
    exec(success, error, 'AliyunSVideoBase', 'startRecord', [arg0]);
};

exports.startCrop = function (arg0, success, error) {
    exec(success, error, 'AliyunSVideoBase', 'startCrop', [arg0]);
};