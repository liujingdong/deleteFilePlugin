package delete.file;

import android.os.Environment;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;

/**
 * Created by CrazyDong on 2017/6/20.
 */
public class DeleteFilePlugin extends CordovaPlugin {
  private File mFile;

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

    /*action:delete
    * args:args.getString(0)为文件夹名字
    * */
    if(action.equals("delete")){
      //删除sd卡args.getString(0)下的所有文件
      mFile = new File(Environment.getExternalStorageDirectory() + args.getString(0));
      boolean flagDelete = deleteAllFiles(mFile);
      if(flagDelete){
        callbackContext.success("删除成功");
      }else {
        callbackContext.error("删除失败");
      }

      return true;
    }


    return false;
  }

    /*删除文件的方法*/
//    static boolean deleteAllFiles(File root){
//      File files[] = root.listFiles();
//      if (files != null) {
//        for (File f : files) {
//          if(f.isDirectory()){//判断是否为文件夹
//            deleteAllFiles(f);
//            try {
//              f.delete();
//              return true;
//            }catch (Exception e){
//              return false;
//            }
//          }else {
//            if (f.exists()){//判断是否存在
//              deleteAllFiles(f);
//              try {
//                f.delete();
//                return true;
//              }catch (Exception e){
//                return false;
//              }
//            }
//          }
//        }
//      }
//
//      return false;
//
//    }

//  static boolean deleteAllFiles(File file){
//    if(file.exists()){
//      file.delete();
//      return true;
//    }else{
//      return false;
//    }
//
//  }


      static boolean deleteAllFiles(File dir){
        if(dir == null || !dir.exists() || !dir.isDirectory()){
          return false;
        }else{
          for (File file : dir.listFiles()) {
            if(file.isFile()){
              file.delete();
            }else if(file.isDirectory()){
              deleteAllFiles(dir);
            }
          }
          dir.delete();
          return true;
        }

    }

}
