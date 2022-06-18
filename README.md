# 一、JVM基础1

## java从编码到执行

![image-20220531180617682](C:\Users\杨翔压民\AppData\Roaming\Typora\typora-user-images\image-20220531180617682.png)



## jvm与class关系

![image-20220531181741439](C:\Users\杨翔压民\AppData\Roaming\Typora\typora-user-images\image-20220531181741439.png)



## JVM

java虚拟机： 由classloader（类加载器），包含字节码解析器+即时编译器，然后扔到执行引擎内，再后扔到OS硬件内

虚构出来的一台计算机

– 字节码指令集（汇编语言）

– 内存管理：栈 堆 方法区等



## JDK JRE JVM

![image-20220531183047489](C:\Users\杨翔压民\AppData\Roaming\Typora\typora-user-images\image-20220531183047489.png)



# 二、Class文件格式

![image-20220531203551278](C:\Users\杨翔压民\AppData\Roaming\Typora\typora-user-images\image-20220531203551278.png)



# 三、类加载器

## 1.类加载-初始化

![image-20220601155809059](C:\Users\杨翔压民\AppData\Roaming\Typora\typora-user-images\image-20220601155809059.png)

- loading 将class类加载到内存空间

- linking

- ```
  1.verification 校验class文件是否规范
  2.preparation 静态变量赋默认值
  3.resolution 常量池中的符号引用转成直接引用
  ```



## 2.双亲委派

父加载器

**– 父加载器不是“类加载器的加载器”！！！！！也不是“类加载器的父类加载器”**

▪ 双亲委派是一个孩子向父亲方向，然后父亲向孩子方向的双亲委派过程

▪ 思考：为什么要搞双亲委派– java.lang.String类由自定义类加载器加载行不行？



## 3.类加载器范围

![image-20220601161025659](C:\Users\杨翔压民\AppData\Roaming\Typora\typora-user-images\image-20220601161025659.png)





![image-20220601210107142](C:\Users\杨翔压民\AppData\Roaming\Typora\typora-user-images\image-20220601210107142.png)



1. LazyLoading 五种情况

   1. –new getstatic putstatic invokestatic指令，访问final变量除外

      –java.lang.reflect对类进行反射调用时

      –初始化子类的时候，父类首先初始化

      –虚拟机启动时，被执行的主类必须初始化

      –动态语言支持java.lang.invoke.MethodHandle解析的结果为REF_getstatic REF_putstatic REF_invokestatic的方法句柄时，该类必须初始化

2. ClassLoader的源码

   1. findInCache -> parent.loadClass -> findClass()

3. 自定义类加载器

   1. extends ClassLoader
   2. overwrite findClass() -> defineClass(byte[] -> Class clazz)
   3. 加密
   4. <font color=red>第一节课遗留问题：parent是如何指定的，打破双亲委派，学生问题桌面图片</font>
      1. 用super(parent)指定
      2. 双亲委派的打破
         1. 如何打破：重写loadClass（）
         2. 何时打破过？
            1. JDK1.2之前，自定义ClassLoader都必须重写loadClass()
            2. ThreadContextClassLoader可以实现基础类调用实现类代码，通过thread.setContextClassLoader指定
            3. 热启动，热部署
               1. osgi tomcat 都有自己的模块指定classloader（可以加载同一类库的不同版本）

4. 混合执行 编译执行 解释执行

   1. 检测热点代码：-XX:CompileThreshold = 10000

5. Linking 

   1. Verification
      1. 验证文件是否符合JVM规定
   2. Preparation
      1. 静态成员变量赋默认值
   3. Resolution
      1. 将类、方法、属性等符号引用解析为直接引用
         常量池中的各种符号引用解析为指针、偏移量等内存地址的直接引用

6. Initializing

   1. 调用类初始化代码 <clinit>，给静态成员变量赋初始值

7. 小总结：

   1. load - 默认值 - 初始值
   2. new - 申请内存 - 默认值 - 初始值
