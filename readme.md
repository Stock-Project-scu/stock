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