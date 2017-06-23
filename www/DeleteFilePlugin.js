/**
 * Created by CrazyDong on 2017/6/20.
 */
var exec = require('cordova/exec');

module.exports = {
    /*调用对比
    * js: cordova.exec(callbackContext.success, callbackContext.error, PluginName, action, args);
    * java: public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
    * */
    delete:function(flagMsg,success,err){
        exec(success,err, "DeleteFilePlugin", "delete", [flagMsg]);
    }
}