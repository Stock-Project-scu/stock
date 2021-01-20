#### Stock股票交易系统



#### 数据库设计数据

###### currentOrder

{field: "id", title: "编号", sort: true, fixed: "left"},

​        {field: "stockId", title: "证券代码"},

​        {field: "stockName", title: "证券名称"},

​        {field: "count", title: "证券数量"},

​        {field: "countCanSell", title: "可卖数量"},

​        {field: "primeCost", title: "成本价"},

​        {field: "currentPrice", title: "当前价"},

​        {field: "todayBuy", title: "今买数量"},

​        {field: "todaySell", title: "今卖数量"},

​        {field: "profitLoss", title: "浮动盈亏"},



###### historyOrder

{field: "id", title: "编号", sort: true, fixed: "left"},

​        {field: "date", title: "成交日期"},

​        {field: "time", title: "成交时间"},

​        {field: "stockId", title: "证券代码"},

​        {field: "stockName", title: "证券名称"},

​        {field: "BSFlag", title: "买卖状态"},

​        {field: "doneCost", title: "成交价格"},

​        {field: "doneCount", title: "成交数量"},

​        {field: "donePrice", title: "成交金额"}

#### 交易系统数据库
##### user-stock表
Id useranme stockId stockName stocknumber 
active1： 如果没有记录，用户购买股票的时候，存入用户名，股票代码，股票名，股票数(**不设置总价，暂时**)
active2： 如果有记录，直接在上面增减，如果超过用户已有数量的卖出，会返回错误。

规约1：getstock信息，发送StockID编号，返回当前最新的价格(休市期另算)，也可以传stockName回来了(很方便)

规约2：buystock，
前端传回
1.(用户名/可以不获取采用session获取)
2.需要购买的stockId
3.最好能有stockname
4.购买数量number
5.currentprice(可选当前价格，这样就不用再次访问价格了)
后端反应计算出总额，从user-property中取出相应额度，user-stock表添加相应的记录，如果余额不足返回2，其他错误返回0

规约3：salestock
前端回传
1.用户名
2.stockId
3.购买数量
4.最好能传stockname
5.售出总价
后端：如果user-stock没有或者是持有数量不够，返回2，其他错误返回0，正常情况，修改user-property数值，

#### 使用股票信息接口

##### 后端获取实时数据

0：”大秦铁路”，股票名字； stockName
1：”27.55″，今日开盘价； openPrice
2：”27.25″，昨日收盘价； closePrice
3：”26.91″，当前价格； currentPrice
4：”27.55″，今日最高价； maxPrice
5：”26.20″，今日最低价； minPrice
6：”26.91″，竞买价，即“买一”报价； buyOnePrice
7：”26.92″，竞卖价，即“卖一”报价； sellOnePrice
8：”22114263″，成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百； dealCount
9：”589824680″，成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万； dealValue
10：”4695″，“买一”申请4695股，即47手； buyOneCount
20：”3100″，“卖一”申报3100股，即31手； sellOneCount

路由

~~~
../get/stockInfo
~~~

##### 创建新订单

路由

~~~
../order/buy
~~~

数据格式

~~~json
{
    "username":"aaa",
    "stockId":"600519",
    "stockName":"贵州茅台",
    "currentPrice":1740.5,
    "buyCount":100,
    "totalPrice":174050
}
~~~

返回值规定

~~~
类型：int
1：创建成功
2：余额不足
0：其他错误
~~~

#### 获取财经资讯接口

路由

~~~
../getdata/news
~~~

数据格式

~~~
{
	page: x
}
~~~

方法：get

一次从新浪财经获取10条新闻资讯

点击刷新之后会带来不同的page信息，获取不同咨询即可

#### 获取大盘信息接口

路由

~~~
../getdata/marketInfo
~~~

数据格式：

~~~json
{
	stockid: xxx
}
~~~

xxx =  [s_sh000001,s_sz399001,s_sh000300,s_sz399415,s_sz399006]

方法：get

服务器从新浪获取五大板块信息然后传回JSON对象

回传数据（只要这几个）：

~~~json
{
    "name": "上证指数",
    "price": 3600.6722,
    "upDown": -7.6667,
    "uoDownPercent": -0.21
}
~~~

下面两个我实在想不出啥名字了...

#### 重置密码

路由

~~~
../change/resetPwd
~~~

数据格式：

~~~json
{
    username: "aaa",
    password: "123456"
}
~~~

方法：post

回传数据：

~~~
1 修改成功
0 修改失败
~~~

#### 公告管理

##### 获取所有公告

路由

~~~
../notice/getall
~~~

数据格式：无

方法：不限

回传数据：包含所有公告的JSON对象

##### 删除公告

路由

~~~
../notice/delete
~~~

数据格式：

~~~json
{
    id: 1
}
~~~

方法：不限

回传数据：

~~~
res=1 删除成功
res=0 删除失败
~~~

##### 发布新公告

路由

~~~
../notice/new
~~~

数据格式：

~~~json
{
    time: "2021-01-20 15:06:50",
    title: "哈哈哈哈哈",
    content: "哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
}
~~~

回传数据：

~~~
res=1 添加成功
res=0 添加失败
~~~

