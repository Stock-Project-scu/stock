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

##### 新浪获取实时数据

0：”大秦铁路”，股票名字；
1：”27.55″，今日开盘价；
2：”27.25″，昨日收盘价；
3：”26.91″，当前价格；
4：”27.55″，今日最高价；
5：”26.20″，今日最低价；
6：”26.91″，竞买价，即“买一”报价；
7：”26.92″，竞卖价，即“卖一”报价；
8：”22114263″，成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百；
9：”589824680″，成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万；
10：”4695″，“买一”申请4695股，即47手；
11：”26.91″，“买一”报价；
12：”57590″，“买二”
13：”26.90″，“买二”
14：”14700″，“买三”
15：”26.89″，“买三”
16：”14300″，“买四”
17：”26.88″，“买四”
18：”15100″，“买五”
19：”26.87″，“买五”
20：”3100″，“卖一”申报3100股，即31手；
21：”26.92″，“卖一”报价
(22, 23), (24, 25), (26,27), (28, 29)分别为“卖二”至“卖四的情况”
30：”2008-01-11″，日期；
31：”15:05:32″，时间；