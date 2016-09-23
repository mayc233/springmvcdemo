# springmvc的示例：[详细文档](http://note.youdao.com/yws/public/redirect/share?id=32a63464a0a27b2f602aa8415a641529&type=false)
##### 1. 搭建maven webapp工程
##### 2. maven依赖springmvc    
##### 3. web.xml配置
##### 4. applicationContext.xml配置（可省略）
##### 5. springmvc.xml配置
##### 6. 编写控制器
##### 7. 编写页面
##### 8. 发布项目测试

[springmvc原理文档](http://note.youdao.com/share/?id=cab287cd68f317d6add8341e6dbe170a&type=note#)

# com.yinhai.springmvc.web包中类的说明：
##### 1. IndexController.java:演示控制器方法的返回类型
######  1.1 String 逻辑视图的名字     例如 index ---> /WEB-INF/page/index.jsp
######  1.2 ModelAndView 模型视图对象  设置视图的的逻辑名字和模型数据
######  1.3 void 可以作为返回JSON数据的时候使用，但是在springmvc中提供了更好的返回json数据方式	
##### 2. IndexController1.java:演示控制器的跳转方式
######  2.1 内部跳转（推荐）
#####	    2.1.1页面
#####		1.2控制器	
####	2.外部跳转（推荐）
#####		2.1页面
#####		2.2控制器
####	3.javaee的跳转
#####		3.1javaee的外部跳转
######			3.1.1外部跳转页面
######			3.1.2外部跳转控制器
#####		3.2javaee内部跳转
######			3.2.1内部跳转页面
######			3.2.2内部跳转控制器
### （三）ParamController.java:演示控制器参数绑定
####	1 默认参数绑定	
####	2基本数据类型的绑定
####	3包装数据类型的绑定
####	4BigDecimal BigInteger的绑定
####	5字符串的绑定
####	6日期类型绑定
####	7基本数组类型绑定
####	8Java Bean基本对象的绑定（基本数据类型）
####	9对象数组的绑定（不推荐这样，直接使用1.11使用集合对象去绑定，更加nice）
####	10java组合对象的绑定（对象的引用）
####	11java.util.List类型的绑定
####	12java.util.Map类型的绑定
### （四）JSONController.java：演示json数据和java对象相互转换	
### （五）ExceptionController.java:演示异常的处理
### （六）UploadController.java:演示文件上传
####   	1基于commoms-fileupload的文件上传	
### （七）RestController.java：演示restfule风格
### （八）InterceptorController.java:演示拦截器
### （九）DataValidContrller.java:演示数据验证


		