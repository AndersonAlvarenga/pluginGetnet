var exec = require('cordova/exec');

exports.checarImpressora = function (success, error) {
    exec(success, error, 'MainActivity', 'checarImpressora');
};
exports.beep = function (success, error) {
    exec(success, error, 'MainActivity', 'beep');
};

exports.imprimir = function (params, success, error) {
    exec(success, error, 'MainActivity', 'imprimir', [params]);
};

exports.impressoraOutput = function (params, success, error) {
    exec(success, error, 'MainActivity', 'impressoraOutput', [params]);
};

exports.leitorCodigo1 = function (tipoCode, success, error) {
    exec(success, error, 'MainActivity', 'leitorCodigo1', [tipoCode]);
};

exports.leitorCodigoV2 = function (success, error) {
    exec(success, error, 'MainActivity', 'leitorCodigoV2');
};

exports.leitorNfcGedi = function (success, error) {
    exec(success, error, 'MainActivity', 'leitorNfcGedi');
};

exports.leitorNfcId = function (success, error) {
    exec(success, error, 'MainActivity', 'leitorNfcId');
};
exports.led = function (success, error) {
    exec(success, error, 'MainActivity', 'led');
};
exports.setSmartCardPowerOff = function (success, error) {
    exec(success, error, 'MainActivity', 'setSmartCardPowerOff');
};
exports.checkISmart = function (success, error) {
    exec(success, error, 'MainActivity', 'checkISmart');
};

