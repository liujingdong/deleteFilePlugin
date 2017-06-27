---
title: deleting file 
description: 删除文件夹以及文件夹里面的文件.
Installation: ionic plugin add https://github.com/liujingdong/deleteFilePlugin.git
Supported Platforms: android
deleting:
DeleteFilePlugin.delete("/OAdemo",success,error);
/OAdemo:文件名字
success:成功回调方法,返回"删除成功"
error:失败回调方法,返回"删除失败"
---

