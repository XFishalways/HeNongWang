# HeNongWang

## SCU网安大一实训项目  
@BUG生产车间
  
## 农村电商平台  
基于 SpringMVC 框架 前端设计采用 layui  
共4个客户端: 农户端 卖家端 买家端(用户端) 管理员端  
  
## 工作流程:   
- 农户注册登录 => 修改完善个人信息 修改所属卖家 => 注册商品 & 向卖家提交审核  
- 卖家注册登录 => 修改完善个人信息 => 注册新地址 & 查看地址 => 查询农户 & 审核农户商品 => 活动查询(暂未实现) => 展示商品 & 展示订单  
- 买家注册登录 => 修改完善个人信息 => 注册新地址 & 查看地址 => 查看当前购物车 & 查看当前订单 => 活动查询(暂未实现) => 返回首页购买商品 => 点击查看商品详情 => 输入购买数量 => 选择加入购物车或加入订单立即购买 => 回个人中心查看购物车 & 订单  
- 管理员无法注册 直接访问 /admin 登录 => 活动审核 & 活动修改 => 商品审核 & 商品修改

## Web 安全  
使用 interceptor 在进入 controller 接口前拦截危险操作  
- SqlInjectInterceptor 拦截 and or select order delete drop 等 sql 注入的关键词 & 拦截 eval < > script 等 xss 关键词
- LoginInterceptor 通过每次提交表单传入隐藏的随机值并存入session 每次登录进行比对 拦截表单的重复提交 阻止CSRF
- UserInterceptor 通过判断 seesion 内的值 阻止访客直接访问 /farmer /business /buyer 等各端后台 若有非法访问自动重定向到 login.html
