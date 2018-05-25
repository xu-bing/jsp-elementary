任务：
真分页

验证码

输入检验






** 分页展示：

** 分页查询：
直接查询：根据开始、结束记录数查询


间接查询：当前页，每页记录数 转成 起始、结束记录数
关系公式（开始记录数-结束记录数）
begin = (cur - 1) * pagesize + 1;
end = cur * pagesize 

OR

begin = cur*pagesize - (pageSize - 1)


页可以有很多，但当前页只能有1个。

页数计算：
pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;    

分页查询：
前台页面

前台输入条件：
- 直接输入：
- 当前页码
  (每页页数)
- 导航条
fst, pre, next, last
fst: 1
last: 


后台接收参数：


**************
程序流程：
index  ---> servlet ---> service
					|
				emplist
				currentPage
				pages

