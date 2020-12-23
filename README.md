# Spring MVC 学习
详细的笔记直接参考楠哥的笔记吧，实在懒得抄了。
####主要几个点
- 数据绑定：以前需要req.getParameter()获得字符串，然后再转型成具体的数据类型  
现在直接就绑定到相应方法的形参上了，而且自动转换类型。但是List和Map是不能  
直接转换的。
- 模型数据解析：以前需要req.setAttribute()或者session.setAttribute()  
现在添加模型数据，再交给ViewResolver来绑定。添加模型数据主要有以下几种方法：
  - Map
  - Model
  - ModelAndView
  - @SessionAttribute
  - @ModelAttribute
  
- 自定义数据转换器：在数据绑定中，很多类型是可以直接转换的，例如  
String转基本数据类型，转集合等，但是很多类型是不可以的，例如String转Date  
，所以需要自定义数据转换器。
- REST：Representational State Transfer，资源表现层状态转换，  
是目前比较主流的一种互联网软件架构，  
它结构清晰、标准规范、易于理解、便于扩展。
- 文件上传下载：差别不是太大，主要就是MVC对其进行了封装。
- 表单标签库：Spring MVC版本的表单，对表单做了简化

