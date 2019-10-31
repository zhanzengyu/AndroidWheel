# AndroidWheel
Android 组件库，避免重复造轮子。


**[ZLog](https://github.com/nesger/AndroidWheel/blob/master/wheel/src/main/java/com/zengyu/wheel/utils/ZLog.java)**
>功能：日志工具类  
>特点：使用方便；可以快速点击跳转到日志打印处；

最简单用法：
```java
// 1.打开开关。
ZLog.setDebugMode(true);
// 2.直接使用。
ZLog.e("use default tag ZLOG");
```

**API：**  
*setDebugMode(boolean debugMode)：* 设置是否打印日志。  
*setLinkMode(boolean linkMode)：* 设置是否支持日志跳转。  
*setTag(String tag)：* 设置默认 TAG 名称。  


默认不打印，支持日志跳转，TAG 为 **ZLOG**。

**[ZLogHelper](https://github.com/nesger/AndroidWheel/blob/master/wheel/src/main/java/com/zengyu/wheel/utils/ZLogHelper.java)**
>功能：让日志内容支持点击跳转。  
>特点：方便易用。

记住一点，stackIndex 为 1 表示定位到调用 **ZLogHelper** 的地方。    
因此如果做了一层封装，要定位到外部调用处，stackIndex 需要为 2。

**API：**  
*wrapMessage(int stackIndex, String message)：* 包装 message 使其支持点击跳转。

具体说明见博客：

<hr/>

### 版本更新：

**1.0.0：**  
提供日志工具类 **[ZLog](https://github.com/nesger/AndroidWheel/blob/master/wheel/src/main/java/com/zengyu/wheel/utils/ZLog.java)**，方便定位日志位置。提高开发效率。  
提供日志辅助类 **[ZLogHelper](https://github.com/nesger/AndroidWheel/blob/master/wheel/src/main/java/com/zengyu/wheel/utils/ZLogHelper.java)**，方便转换日志内容支持点击跳转。




