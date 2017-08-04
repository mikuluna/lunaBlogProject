# lunaBlogProject
## 介绍
这个自己的博客花了1个半月的时间，这一个半月里面每天晚上回家之后花了3个小时左右编程233【当然也包括学习23333  
采用的是Spring+SpringMVC+Hibernate框架。  
前端用的AngularJs开发的单页面，每个页面都是通过异步请求。  
后台采用SpringMVC,包括每个分区的增删查改。  
本人作为一个初学者，写了一个属于自己的博客，获得成就感还是满满的233  
制作过程中，遇到了各种问题：
- 首先是前端页面的AngularJs,一开始完全不会用。刚开始就看关于路由分配的东西，将每个页面通过ui-router的config,分配每个页面的路由。包括它的url,templateUrl还有关于该路由下的controller。
- 然后就是后端的Spring+SpringMVC+Hibernate整合的框架。用Spring4管理Hibernate4，它的配置和管理Hibernate3不太一样，所以配置也查阅了网上的各种资料，然后自己copy了一下又用不了，然后又只有找各种问题。
- 第三个就是我自己写了一个拦截器。把所有带up字段的都拦截，为了不让人直接访问后台的东西。然后问题就出现了，我前面的页面上传了文件可以显示出来，但是退出后台登录之后，图片就不见了。我后来才发现我上传的文件夹的名字叫upload，然后也被拦截了233333。这种问题以后还是可以注意一下。
- 还有就是代码刚开始的时候所有的dao层都是一个个重复的代码，这个在写的过程之中就把一些代码提取出来，利用泛型写成BaseDao,之后需要重构的地方就是service层也可以有一些BaseService的方法。因为大部分的增删改查都是重复的。
- 在之后部署的时候，由于linux服务器，mysql的默认不是utf8，这个问题是每次都比较容易忽略的。每次部署服务器的时候都要注意一下。
## 还待完善功能
- 第一个要完善的功能就是删除条目的时候顺带把图片的文件给删掉。这个只要写一个在公共的util包里面就行了。
- 第二个要完善的功能是搜索模糊查询，然后自动补全结果。
- 第三个要完善的功能就是留言板，可以通过QQ登录然后进行留言。
## 补充
暂时还没有什么要补充的，之后有什么东西就在这里补充。
