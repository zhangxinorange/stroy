#author zx
在线小说演示系统
mybaits+tkmybaits+spring+springmvc


说明：
	项目编码:utf-8
	1.sql文件为resources下的stroy1.sql,因为数据中含有blob二进制数据，所以不建议复制粘贴导入，直接用sqlyoug等ide工具导入即可
	
	2.后台地址：访问路径后+/admin/login，
		用户名:super
		密码:1
	模块：小说管理、小说类别管理、在线注册用户管理、小说下载查看、小说阅读查看、新闻通知管理、文章评论管理
	
	3.前端功能包括：
		3.1通知轮播展示
		3.2小说下载量排行(更多为根据更新时间、下载量、阅读量等进行排序，分页)
		3.3搜索，点击搜索按钮，可根据小说名称、小说作者。小说类别、是否免费等进行排序、分页
		3.4小说查看，点击某小说，可进入查看小说页面，包括小说评论、小说下载、小说阅读等。(对于收费小说，比如登录后才可下载)
		3.5用户登录、注册 用户登录后，可查看自己阅读过的小说。下载过的小说等信息
系统环境：
	JDK：1.8
	maven：3.3
	tomcat:8
	mysql:5.1级以上
	mysqlIDE工具：sqlyog（小海豚）
开发环境
	eclipse:mars 以上	
	以上环境需要在部署机器上安装完毕。
部署方法：
	
	1.eclipse选择maven project导入项目
	2.eclipse需要提前配置好maven，具体配置方法请见：https://blog.csdn.net/izuiaicy/article/details/70311968
	3.项目导入完毕，按快捷键alt+F5,从maven官网进行jar包的下载，直到项目不报错为止
	4.修改项目下config.properties中的数据库链接，修改ip以及mysql的用户名密码等信息
	5.完毕后导入tomcat中，运行即可。