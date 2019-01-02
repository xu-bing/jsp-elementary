# CC: concept code
# AC: application code

1. CC: 手写1个servlet
要求：
操作：掌握servlet的操作过程 1定义 2配置 3调用
概念：观察servlet的生命周期方法

AC: 用servlet实现登录的例子，成功返回welcome.jsp, 失败，返回login.jsp
要求：用MyEclipse的模板实现

2. AC: 登录例子
要求：
成功登录，则到welcome.jsp页面，显示当前登录的用户名
失败，则返回到index.jsp页面，在页面上提示：帐号或密码错误


// -------------------------------------------------
总结概括(分门别类)
概念
什么是servlet
servlet的作用角色
servlet的执行流程
servlet的生命周期

servlet中如何获得内置对象

servlet处理请求的方式：单实例多线程
什么是servlet的多线程安全问题（并发问题）
如何开发线程安全的servlet