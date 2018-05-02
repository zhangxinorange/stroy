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
	
	
项目难点或者特点：
	1.用户下载等信息，可在后台准确查看，谁看了什么书，谁下载了什么书，什么时候下载的，都可以查询的到，不仅仅是在book表中存了一个计数器，而是可以精确查到。
	2.小说跟小说类比是多对多的关系，也就是说:一本小说可以有多个类别，一个类别可以有多个小说，数据库设计时，采用的是单独一张表进行的维护，前端展示，用的是jquery 的multiSelect技术，美观，实用。
	3.下载排行和阅读排行等，是采用多表联合查询，并且采用根据人员下载统计表中的count信息进行排序。sql较为复杂:
		 SELECT s.c_id,s.c_title,s.c_content,s.c_author,s.c_pic,s.c_create_date,s.c_picStr,s.c_admin,s.c_desc FROM (
SELECT c.*,(SELECT COUNT(*) FROM download d WHERE d.`c_Id`=c.c_id) AS total,
(SELECT COUNT(*) FROM readcontent r WHERE r.c_id=c.c_id) AS total2 FROM content c 
) s ORDER BY ${order} ${desc} 
	4.采用pagehelper，进行mabaits的分页
	5.实用tk.mybatis.mapper技术，实现基础mybaits方法的免写，如赠删改基础查询等方法，都不需要体现在项目中了
	
	
	
说明：
	断点查看小说进度功能，需要点击页面上右侧的目录按钮，才能实现，点击浏览器的返回按钮，不能实现保存进度的功能。