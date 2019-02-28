

### 活动委托单

* [创建活动委托单](#open-apiordercreatepost)

* [查询活动委托](#open-apiorderlistget)

* [撤销活动委托单](#open-apiordercancelpost)

### 条件委托单

* [创建条件委托单](#open-apistop-ordercreatepost)

* [查询条件委托](#open-apistop-orderlistget)

* [撤消条件委托单](#open-apistop-ordercancelpost)

### 持仓

* [用户杠杆](#userleverageget)

* [修改用户杠杆](#userleveragesavepost)

* [我的仓位](#positionlistget)

* [更新保证金](#positionchange-position-marginpost)

### 资金费用

* [查询上个周期的资金费率](#open-apifundingprev-funding-rateget)

* [查询上个周期资金费用结算信息](#open-apifundingprev-fundingget)



-----------
## <span id="open-apiordercreatepost">创建活动委托单 </span>
#### 接口功能

> 所有活动委托都必须填写 &#39;side&#39;, &#39;symbol&#39;, &#39;order_type&#39;, &#39;qty&#39;, &#39;price&#39;, &#39;time_in_force&#39;参数，其它参数除非有特殊说明，否则都是可选的。
市价活动委托: 一个传统的市场价格订单,会以当前的最优价格为您成交订单。当且仅当选择市价单时，&#39;price&#39;, &#39;time_in_force&#39;可为空！

限价活动委托: 您可以为您的订单设置一个执行价格，当市场价格达到您的设置价格时，系统会为您成交订单。

止盈止损: 您仅能在开仓时设置止盈止损条件单，一旦持有仓位后提交活动委托时关联的止盈止损则不再有效。

委托数量: 表示您要购买/卖出的永续合约数，对于委托数量目前Bybit只允许提交正整数。

委托价格: 表示您期望购买/卖出永续合约的价格，对于委托价格目前Bybit只允许提交以0.5为增幅的正数。

自定义条件单ID: 您可以自定义活动委托订单ID，我们会为您关联到系统的订单ID，并把系统的唯一订单ID在活动委托创建成功后一并返回给您，您可以使用该订单ID去取消活动委托，同时要求您传递的自定义订单ID最大长度不超过36个字段且唯一。

请注意: 创建活动委托单上限为200个。

#### URL

```
// 测试网地址
https://api-testnet.bybit.com/open-api/order/create

// 主网地址
https://api.bybit.com/open-api/order/create
```

#### HTTP请求方式

> post

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|side |true |string |方向, 有效选项:Buy, Sell (Buy Sell )    |
|symbol |true |string |产品类型, 有效选项:BTCUSD, ETHUSD (BTCUSD ETHUSD )    |
|order_type |true |string |委托单价格类型, 有效选项:Limit, Market (Limit Market )    |
|qty |true |integer |委托数量, 单比最大1百万 |
|price |true |integer |委托价格, 在没有仓位时，做多的委托价格需高于市价的10%、低于1百万。如有仓位时则需优于强平价。单笔价格增减最小单位为0.5。 |
|time_in_force |true |string |执行策略, 有效选项:GoodTillCancel, ImmediateOrCancel, FillOrKill (GoodTillCancel ImmediateOrCancel FillOrKill )    |
|order_link_id |false |string |机构自定义订单ID, 最大长度36位，且同一机构下自定义ID不可重复 |


#### 返回示例

```js

    {
        'ret_code':0   错误码 - 正确,
        'ret_msg':'ok' 错误消息,
        'ext_code':''  ,
        'result':{
            'order_id': 'string',              UUID类型订单唯一ID
            'user_id': 0,                      用户ID
            'symbol': 'string',                产品类型
            'side': 'string',                  购买方向
            'order_type': 'string',            订单类型
            'price': 0,                        委托价格
            'qty': 0,                          委托数量
            'time_in_force': 'string',         执行策略
            'order_status': 'string',          委托状态: Created:创建订单;Rejected:订单被拒绝;New:订单待成交;PartiallyFilled:订单部分成交;Filled:订单全部成交,Cancelled:订单被取消
            'last_exec_time': 0.000000,        最近一次成交时间
            'last_exec_price': 0,              最近一次成交价格
            'leaves_qty': 0,                   剩余委托数量
            'cum_exec_qty': 0,                 累计成交数量
            'cum_exec_value': 0,               累计成交的名义价值
            'cum_exec_fee': 0,                 累计已成交手续费
            'reject_reason': 'string',         被拒单的原因
            'order_link_id': 'string',         机构自定义订单ID
            'created_at':'2018-10-15T04:12:19.000Z',
            'updated_at':'2018-10-15T04:12:19.000Z',
        },
        'time_now':'1539778407.210858',    UTC时间戳
        'rate_limit_status': 0,            当前时间区间内(1分钟)该类型接口剩余访问次数
    }

```

-----------
## <span id="open-apiorderlistget">查询活动委托 </span>
#### 接口功能

> 获取我的活动委托单列表。

#### URL

```
// 测试网地址
https://api-testnet.bybit.com/open-api/order/list

// 主网地址
https://api.bybit.com/open-api/order/list
```

#### HTTP请求方式

> get

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|order_id |false |string |订单ID |
|order_link_id |false |string |机构自定义订单ID |
|symbol |false |string |产品类型 (BTCUSD ETHUSD )    |
|sort |false |string |排序字段，默认按创建时间排序 (created_at cum_exec_qty qty last_exec_price price cum_exec_value cum_exec_fee )    |
|order |false |string |升序降序， 默认降序 (desc asc )    |
|page |false |integer |页码，默认取第一页数据 |
|limit |false |integer |一页数量，一页默认展示20条数据 |
|order_status |false |string |指定订单状态查询订单列表。不传该参数则默认查询所有状态订单。该参数支持多状态查询，状态之间用英文逗号分割。状态参数：Created,New,PartiallyFilled,Filled,Cancelled,Rejected |


#### 返回示例

```js

    {
        'ret_code':0,
        'ret_msg':'ok',
        'ext_code':'',
        'result':{
            'data':[
                {
                    'order_id': 'string',       UUID类型订单唯一ID
                    'user_id': 0,               用户ID
                    'symbol': 'string',         产品类型
                    'side': 'string',           购买方向
                    'order_type': 'string',     订单类型
                    'price': 0,                 委托价格
                    'qty': 0,                   委托数量
                    'time_in_force': 'string',  执行策略
                    'order_status': 'string',   委托状态: Created:创建订单;Rejected:订单被拒绝;New:订单待成交;PartiallyFilled:订单部分成交;Filled:订单全部成交,Cancelled:订单被取消
                    'last_exec_time': 0.000000 ,最近一次成交时间
                    'last_exec_price': 0,       最近一次成交价格
                    'leaves_qty': 0,            剩余委托数量
                    'cum_exec_qty': 0,          累计成交数量
                    'cum_exec_value': 0,        累计成交的名义价值
                    'cum_exec_fee': 0,          累计已成交手续费
                    'reject_reason': 'string',  被拒单的原因
                    'order_link_id': 'string',  机构自定义订单ID
                    'created_at':'2018-10-15T04:12:19.000Z',
                    'updated_at':'2018-10-15T04:12:19.000Z',
                }
            ],
            'current_page': 1,
            'last_page': 1
        },
        'time_now':'1539781050.462841',    UTC时间戳
        'rate_limit_status': 0,            当前时间区间内(1分钟)该类型接口剩余访问次数
    }

```

-----------
## <span id="open-apiordercancelpost">撤销活动委托单 </span>
#### 接口功能

> 所有撤销活动委托都必须填写 &#39;order_id&#39;，在您创建活动委托成功时会为您返回36位唯一的订单ID。

您可以撤销未成交、部分成交的活动委托单。但全部成交的活动委托不可取消。

#### URL

```
// 测试网地址
https://api-testnet.bybit.com/open-api/order/cancel

// 主网地址
https://api.bybit.com/open-api/order/cancel
```

#### HTTP请求方式

> post

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|order_id |true |string |活动委托单ID, 数据来自创建活动委托单返回的订单唯一ID |


#### 返回示例

```js

    {
        'ret_code':0   错误码 - 正确,
        'ret_msg':'ok' 错误消息,
        'ext_code':''  ,
        'result': {
            'order_id': 'string',        UUID类型订单唯一ID
            'user_id': 0,                用户ID
            'symbol': 'string',          产品类型
            'side': 'string',            购买方向
            'order_type': 'string',      订单类型
            'price': 0,                  委托价格
            'qty': 0,                    委托数量
            'time_in_force': 'string',   执行策略
            'order_status': 'string',    委托状态: Created:创建订单;Rejected:订单被拒绝;New:订单待成交;PartiallyFilled:订单部分成交;Filled:订单全部成交,Cancelled:订单被取消
            'last_exec_time': 0.000000,  最近一次成交时间
            'last_exec_price': 0,        最近一次成交价格
            'leaves_qty': 0,             剩余委托数量
            'cum_exec_qty': 0,           累计成交数量
            'cum_exec_value': 0,         累计成交的名义价值
            'cum_exec_fee': 0,           累计已成交手续费
            'reject_reason': 'string',   被拒单的原因
            'order_link_id': 'string',   机构自定义订单ID
            'created_at':'2018-10-15T04:12:19.000Z',
            'updated_at':'2018-10-15T04:12:19.000Z',
        },
        'time_now':'1539778407.210858',    UTC时间戳
        'rate_limit_status': 0,            当前时间区间内(1分钟)该类型接口剩余访问次数
    }

```

-----------
## <span id="open-apistop-ordercreatepost">创建条件委托单 </span>
#### 接口功能

> 所有条件委托都必须填写 &#39;side&#39;, &#39;symbol&#39;, &#39;order_type&#39;, &#39;qty&#39;, &#39;price&#39;, &#39;base_price&#39;, &#39;stop_px&#39;, &#39;time_in_force&#39;参数，其它参数除非有特殊说明，否则都是可选的。

市价条件委托: 一个传统的市场价格订单,会以当前的最优价格为您成交订单。当且仅当选择市价单时，&#39;price&#39;, &#39;time_in_force&#39;可为空！

限价条件委托: 您可以为您的订单设置一个执行价格，当市场价格达到您的设置价格时，系统会为您成交订单。

委托数量: 表示您要购买/卖出的永续合约数，对于委托数量目前Bybit只允许提交正整数。

委托价格: 表示您期望购买/卖出永续合约的价格，对于委托价格目前Bybit只允许提交以0.5为增幅的正数。

条件委托触发价格: 您可以为您的条件委托单设置一个触发价格，条件委托单不进入委托表（Order Book)，只有触发条件成立如市场价格到达触发价格时，条件委托单才会进入交易系统。当市场价格到达触发价格：1）您的限价条件委托单进入Order Book，等待被执行；2）您的市价条件委托单将按照市场最优价格立即被执行。

自定义条件单ID: 您可以自定义活动委托订单ID，我们会为您关联到系统的订单ID，并把系统的唯一订单ID在活动委托创建成功后一并返回给您，您可以使用该订单ID去取消活动委托，同时要求您传递的自定义订单ID最大长度不超过36个字段且唯一。

请注意: 只允许最多创建10个条件委托单

#### URL

```
// 测试网地址
https://api-testnet.bybit.com/open-api/stop-order/create

// 主网地址
https://api.bybit.com/open-api/stop-order/create
```

#### HTTP请求方式

> post

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|side |true |string |方向, 有效选项:Buy, Sell (Buy Sell )    |
|symbol |true |string |产品类型, 有效选项:BTCUSD, ETHUSD (BTCUSD ETHUSD )    |
|order_type |true |string |委托单价格类型, 有效选项:Limit, Market (Limit Market )    |
|qty |true |integer |委托数量 |
|price |true |integer |条件委托执行价格 |
|base_price |true |integer |当前市价。用于和stop_px值进行比较，确定当前条件委托是看空到stop_px时触发还是看多到stop_px触发。主要是用来标识当前条件单预期的方向 |
|stop_px |true |integer |条件委托下单时市价 |
|time_in_force |true |string |执行策略, 有效选项:GoodTillCancel, ImmediateOrCancel, FillOrKill (GoodTillCancel ImmediateOrCancel FillOrKill )    |
|order_link_id |false |string |机构自定义订单ID, 最大长度36位，且同一机构下自定义ID不可重复 |


#### 返回示例

```js

    {
        'ret_code':0   错误码 - 正确,
        'ret_msg':'ok' 错误消息,
        'ext_code':''  ,
        'result':{
            'stop_order_id': 'string',         UUID类型订单唯一ID
            'user_id': 0,                      用户ID
            'stop_order_status': 'string',     条件单状态: Untriggered: 等待市价触发条件单; Triggered: 市价已触发条件单; Cancelled: 取消; Active: 条件单触发成功且下单成功; Rejected: 条件触发成功但下单失败
            'symbol': 'string',                产品类型
            'side': 'string',                  购买方向
            'order_type': 'string',            价格类型
            'price': 0,                        委托价格
            'qty': 0,                          委托数量
            'time_in_force': 'string',         执行策略
            'stop_order_type': 'string',       订单类型
            'base_price': 0,                   下单时市价
            'stop_px': 0,                      触发价格
            'order_link_id': 'string',         机构自定义订单ID
            'created_at':'2018-10-15T04:12:19.000Z',
            'updated_at':'2018-10-15T04:12:19.000Z',
        }
        'time_now':'1539778407.210858',    UTC时间戳
        'rate_limit_status': 0,            当前时间区间内(1分钟)该类型接口剩余访问次数
    }

```

-----------
## <span id="open-apistop-orderlistget">查询条件委托 </span>
#### 接口功能

> 获取我的条件委托单列表。

#### URL

```
// 测试网地址
https://api-testnet.bybit.com/open-api/stop-order/list

// 主网地址
https://api.bybit.com/open-api/stop-order/list
```

#### HTTP请求方式

> get

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|stop_order_id |false |string |条件委托订单ID |
|order_link_id |false |string |机构自定义订单ID |
|symbol |false |string |产品类型 (BTCUSD ETHUSD )    |
|sort |false |string |排序字段，默认按创建时间排序 (created_at )    |
|order |false |string |升序降序，默认降序 (desc asc )    |
|page |false |integer |页码，默认取第一页数据 |
|limit |false |integer |一页数量，默认一页展示20条数据 |


#### 返回示例

```js

    {
        'ret_code':0,
        'ret_msg':'ok',
        'ext_code':'',
        'result':{
            'data':[
                {
                    'stop_order_id': 'string',      UUID类型订单唯一ID
                    'user_id': 0,                   用户ID
                    'stop_order_status': 'string',  条件单状态: Untriggered: 等待市价触发条件单; Triggered: 市价已触发条件单; Cancelled: 取消; Active: 条件单触发成功且下单成功; Rejected: 条件触发成功但下单失败
                    'symbol': 'string',             产品类型
                    'side': 'string',               购买方向
                    'order_type': 'string',         价格类型
                    'price': 0,                     委托价格
                    'qty': 0,                       委托数量
                    'time_in_force': 'string',      执行策略
                    'stop_order_type': 'string',    订单类型
                    'base_price': 0,                下单时市价
                    'stop_px': 0,                   触发价格
                    'order_link_id': 'string',      机构自定义订单ID
                    'created_at':'2018-10-15T04:12:19.000Z',
                    'updated_at':'2018-10-15T04:12:19.000Z',
                }
            ],
            'current_page':1,
            'last_page':1
        },
        'time_now':'1539781050.462841',    UTC时间戳
        'rate_limit_status': 0,            当前时间区间内(1分钟)该类型接口剩余访问次数
    }

```

-----------
## <span id="open-apistop-ordercancelpost">撤消条件委托单 </span>
#### 接口功能

> 所有撤销条件委托都必须填写 &#39;stop_order_id&#39;，在您创建条件委托成功时会为您返回36位唯一的订单ID。

您可以撤销所有未被激活的条件委托。本质上所有条件委托在被激活后都是属于活动委托，所以条件委托一旦被激活，您需要通过调用取消活动委托接口来取消所有未成交、部分成交的活动委托单。同样全部成交的活动委托不可取消。

#### URL

```
// 测试网地址
https://api-testnet.bybit.com/open-api/stop-order/cancel

// 主网地址
https://api.bybit.com/open-api/stop-order/cancel
```

#### HTTP请求方式

> post

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|order_id |true |string |委托单ID, 数据来自创建活动委托单返回的订单唯一ID |


#### 返回示例

```js

    {
        'ret_code':0   错误码 - 正确,
        'ret_msg':'ok' 错误消息,
        'ext_code':''  ,
        'result':{
            'stop_order_id': 'string',      UUID类型订单唯一ID
            'user_id': 0,                   用户ID
            'stop_order_status': 'string',  条件单状态: Untriggered: 等待市价触发条件单; Triggered: 市价已触发条件单; Cancelled: 取消; Active: 条件单触发成功且下单成功; Rejected: 条件触发成功但下单失败
            'symbol': 'string',             产品类型
            'side': 'string',               购买方向
            'order_type': 'string',         价格类型
            'price': 0,                     委托价格
            'qty': 0,                       委托数量
            'time_in_force': 'string',      执行策略
            'stop_order_type': 'string',    订单类型
            'base_price': 0,                下单时市价
            'stop_px': 0,                   触发价格
            'order_link_id': 'string',      机构自定义订单ID
            'created_at':'2018-10-15T04:12:19.000Z',
            'updated_at':'2018-10-15T04:12:19.000Z',
        }
        'time_now':'1539778407.210858',    UTC时间戳
        'rate_limit_status': 0,            当前时间区间内(1分钟)该类型接口剩余访问次数
    }

```

-----------
## <span id="userleverageget">用户杠杆 </span>
#### 接口功能

> 获取用户杠杆。

#### URL

```
// 测试网地址
https://api-testnet.bybit.com/user/leverage

// 主网地址
https://api.bybit.com/user/leverage
```

#### HTTP请求方式

> get

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |


#### 返回示例

```js

{
    'ret_code':0   返回码(0：成功、-1：失败)
    'ret_msg':'ok' 错误消息,
    'ext_code':''  补充错误码,
    'result': {
        'BTCUSD': {
            'leverage': 100
        },
        'ETHUSD': {
            'leverage': 1
        }
    'time_now':'1539778407.210858',    UTC时间戳
    'rate_limit_status': 0,            当前时间区间内(1分钟)该类型接口剩余访问次数
}

```

-----------
## <span id="userleveragesavepost">修改用户杠杆 </span>
#### 接口功能

> 修改用户杠杆。

#### URL

```
// 测试网地址
https://api-testnet.bybit.com/user/leverage/save

// 主网地址
https://api.bybit.com/user/leverage/save
```

#### HTTP请求方式

> post

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|symbol |true |string |产品类型 (BTCUSD ETHUSD )    |
|leverage |true |string |杠杆 |


#### 返回示例

```js

{
    'ret_code':0   返回码(0：成功、-1：失败)
    'ret_msg':'ok' 错误消息,
    'ext_code':''  补充错误码,
    'result': null,根据 ret_code 判断是否请求成功，result返回恒为null
    'time_now':'1539778407.210858',    UTC时间戳
    'rate_limit_status': 0,            当前时间区间内(1分钟)该类型接口剩余访问次数
}

```

-----------
## <span id="positionlistget">我的仓位 </span>
#### 接口功能

> 获取我的仓位列表。通过该接口可以获取当前用户的持仓信息，如持仓数量、账户余额等信息

#### URL

```
// 测试网地址
https://api-testnet.bybit.com/position/list

// 主网地址
https://api.bybit.com/position/list
```

#### HTTP请求方式

> get

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |


#### 返回示例

```js

{
    'ret_code': 0,    返回码(0：成功、-1：失败)
    'ret_msg': 'ok',  错误消息
    'ext_code': '',   补充错误码
    'result': [
        {
            'id': 1,                仓位id
            'user_id': 1,           用户id
            'risk_id': 1,           风险限额id
            'symbol': 'BTCUSD',     产品类型  BTCUSD,ETHUSD
            'side': 'None',         仓位方向  None,buy,sell
            'size': 0,              仓位数量
            'position_value': 0,    仓位价值
            'entry_price': 0,       仓位开仓价
            'leverage': 1,          用户杠杆
            'auto_add_margin': 0,   自动追加保证金开关
            'position_margin': 0,   仓位保证金
            'liq_price': 999999,    强平价格
            'bust_price': 999999,   破产价格
            'occ_closing_fee': 0,   平仓手续费
            'take_profit': 0,       止盈价格
            'stop_loss': 0,         止损价格
            'trailing_stop': 0,     追踪止损点数
            'position_status': 'Normal',   仓位状态  Normal(正常),Liq(强平中),Adl(减仓中)
            'deleverage_indicator': 1,
            'oc_calc_data': '{\'blq\':\'0\',\'bmp\':\'0\',\'slq\':\'0\',\'smp\':\'0\'}',
            'order_margin': 0,      委托预占用保证金
            'wallet_balance': 0,    账户余额
            'realised_pnl': 0,      今日已结盈亏
            'cum_realised_pnl': 0,  累计已结盈亏
            'cum_commission': 0,    累计佣金
            'cross_seq': 0,         撮合返回版本号
            'position_seq': 2,      仓位版本号
            'created_at': '2018-10-18T07:15:51.000Z',
            'updated_at': '2018-10-20T13:43:21.000Z'
        }
    ],
    'time_now': '1540043097.995523',    UTC时间戳
    'rate_limit_status': 0,            当前时间区间内(1分钟)该类型接口剩余访问次数

}
 *
```

-----------
## <span id="positionchange-position-marginpost">更新保证金 </span>
#### 接口功能

> 更新保证金

#### URL

```
// 测试网地址
https://api-testnet.bybit.com/position/change-position-margin

// 主网地址
https://api.bybit.com/position/change-position-margin
```

#### HTTP请求方式

> post

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|symbol |true |string |产品 (BTCUSD ETHUSD )    |
|margin |true |string |保证金 |


#### 返回示例

```js

{
    'ret_code':0   返回码(0：成功、-1：失败)
    'ret_msg':'ok' 错误消息,
    'ext_code':'', 补充错误码
    'result': null, 根据 ret_code 判断是否请求成功，result返回恒为null
    'time_now':'1539778407.210858',    UTC时间戳
    'rate_limit_status': 0,            当前时间区间内(1分钟)该类型接口剩余访问次数
}

```

-----------
## <span id="open-apifundingprev-funding-rateget">查询上个周期的资金费率 </span>
#### 接口功能

> UTC时间每天0点、8点、16点产生一个资金费率

假设当前时间是12点，则返回的是8点产生的资金费率


#### URL

```
// 测试网地址
https://api-testnet.bybit.com/open-api/funding/prev-funding-rate

// 主网地址
https://api.bybit.com/open-api/funding/prev-funding-rate
```

#### HTTP请求方式

> get

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|symbol |true |string |产品 (BTCUSD ETHUSD )    |


#### 返回示例

```js

{
    'ret_code':0   // 返回码(0：成功、-101：参数校验失败)
    'ret_msg':'ok' // 错误消息,
    'ext_code':'', // 补充错误码
    'result': {
        'symbol':'BTCUSD',
        'funding_rate':'0.00375000', // 资金费率,当资金费率是正数时，多仓向空仓支付资金费用.为负数时，空仓向多仓支付资金费用
        'funding_rate_timestamp':1539950401 //资金费率产生时间,UTC时间戳
    },
    'time_now':'1539778407.210858',    UTC时间戳
}

```

-----------
## <span id="open-apifundingprev-fundingget">查询上个周期资金费用结算信息 </span>
#### 接口功能

> UTC时间每天0点、8点、16点进行资金费用结算

当前周期的资金费用结算是根据上个周期的资金费率来进行结算

比如16点结算时是按照8点产生的资金费率来进行结算

而16点产生的资金费率则会在第二天0点结算时使用


#### URL

```
// 测试网地址
https://api-testnet.bybit.com/open-api/funding/prev-funding

// 主网地址
https://api.bybit.com/open-api/funding/prev-funding
```

#### HTTP请求方式

> get

#### 请求参数

|参数|必选|类型|说明|
|:----- |:-------|:-----|----- |
|symbol |true |string |产品 (BTCUSD ETHUSD )    |


#### 返回示例

```js

{
    'ret_code':0   // 返回码(0：成功、-101：参数校验失败)
    'ret_msg':'ok' // 错误消息,
    'ext_code':'', // 补充错误码
    'result': {
        'symbol': 'BTCUSD',
        'side': 'Buy', // 进行结算时仓位的持仓方向
        'size': 10,   // 进行结算时仓位的数量
        'funding_rate': 0.00375 // 结算时的资金费率
        'exec_fee': 0.00000116, // 结算资金费用, 为正数时,多仓支付费用，空仓收取费用; 为负数时，多仓收取费用，空仓支付费用
        'exec_timestamp': 1539950401, // 结算时间，UTC时间戳
    },
    'time_now':'1539778407.210858',    UTC时间戳
}

```
