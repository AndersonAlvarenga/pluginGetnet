var exec = require('cordova/exec');

exports.checarImpressora = function (success, error) {
    exec(success, error, 'MainActivity', 'checarImpressora');
};
exports.print = function (success, error) {
    exec(success, error, 'MainActivity', 'imprimir');
};

