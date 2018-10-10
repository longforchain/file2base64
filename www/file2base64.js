var exec = require('cordova/exec');

exports.encode = function (location, success, error) {
    var args = {};
    args.location = location;
    exec(success, error, 'file2base64', 'encode', [args]);
};
