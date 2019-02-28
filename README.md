# DesignPattern
设计模式：
原则：
1：开闭原则：程序对外扩展开放，对修改关闭。新需求通过修改代码实现，不可取；
2：单一职责原则：一个类或者一个接口只负责一项职责，尽量设计出功能单一的接口
3：依赖倒转原则：高层模块不应该依赖低层模块的实现，解耦高层与低层，当实现发生变化，只需要新增实现类，不需要修改高层代码；
#### 1 单例模式
对个模式下的单例模式优缺点，使用效率以及实现原理
#### 2 动态代理模式
###### 静态代理与动态代理的区别主要在：
##### 静态代理在编译时就已经实现，编译完成后代理类是一个实际的class文件
##### 动态代理是在运行时动态生成的，即编译完成后没有实际的class文件，而是在运行时动态生成类字节码，并加载到JVM中