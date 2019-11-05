# AndroidWheel

[![](https://jitpack.io/v/nesger/AndroidWheel.svg)](https://jitpack.io/#nesger/AndroidWheel)

Android 组件库，避免重复造轮子。

### 添加到项目

**Step 1. Add the JitPack repository to your build file**  
Add it in your root build.gradle at the end of repositories:
```java
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
**Step 2. Add the dependency**
```java
dependencies {
  implementation 'com.github.nesger:AndroidWheel:1.0.1'
}
```

### Releases
[Releases](https://github.com/nesger/AndroidWheel/releases)

### 版本更新：

**1.0.1：**  
增加[防抖动 EditText](https://github.com/nesger/AndroidWheel/blob/master/wheel/src/main/java/com/zengyu/wheel/widgets/DebounceEditText.java)

**1.0.0：**  
提供日志工具类 **[ZLog](https://github.com/nesger/AndroidWheel/blob/master/wheel/src/main/java/com/zengyu/wheel/utils/ZLog.java)**，方便定位日志位置。提高开发效率。  
提供日志辅助类 **[ZLogHelper](https://github.com/nesger/AndroidWheel/blob/master/wheel/src/main/java/com/zengyu/wheel/utils/ZLogHelper.java)**，方便转换日志内容支持点击跳转。

<hr/>

### 文档

**[DebounceEditText](https://github.com/nesger/AndroidWheel/blob/master/wheel/src/main/java/com/zengyu/wheel/widgets/DebounceEditText.java)**
>功能：防抖动  
>特点：支持代码配置和 xml 配置

xml 配置：
```java
<com.zengyu.wheel.widgets.DebounceEditText
    android:id="@+id/edt_xml"
    android:layout_width="match_parent"
    android:layout_height="30dp"
    app:debounce_time="1000"
    />
```


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


