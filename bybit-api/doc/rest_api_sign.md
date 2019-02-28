## 机构api签名
### 获取你的 api_key 和 密钥

// 测试网地址

<a href="https://testnet.bybit.com/user/api-management">https://testnet.bybit.com/user/api-management</a>

// 主网地址

<a href="https://www.bybit.com/app/user/api-management">https://www.bybit.com/app/user/api-management</a>

### 频率限制

* 接口访问类限制
  * 对于订单类接口，如创建委托单、查询委托单等，每个账户每分钟可调用800次
  * 对于持仓类接口，如修改杠杆、查询仓位信息等，每个账户每分钟可调用600次

* 业务类限制
  * 未完全成交的活动委托单最多可同时有200个
  * 条件单同一方向最多可同时有5个

### 认证

在调用 API 时，需要提供 API Key 作为每个请求的身份识别，并且通过secret对请求数据加签

#### 公共参数
字段名 | 字段释义 |  字段类型 | 是否必填 | 默认值 | 说明
:- | :- | :- | :- | :- | :-
api_key | 在平台申请的API_KEY |  string | 是 | 无 |用于身份识别
timestamp | 请求发起时的时间戳,单位:毫秒 | int64 | 是 | 无 | UTC时间戳,服务端收到请求时会校验此参数，校验规则: timestamp < server_time + 1000,其中server_time是服务器时间
recv_window| 配置请求的有效时间,单位:毫秒| int | 否 | 5000 | http请求将会在timestamp+recv_window这个时间点后失效，用于防重放攻击
sign | 签名信息 |  string | 是 | 无 | 按照一定规则形成的签名信息


#### 如何进行签名
1. 将对应业务的接口参数和除sign外的公共参数以http GET请求形式拼接，拼接顺序按照参数名升序排列,如调整杠杆接口业务参数有symbol和leverage,则拼接后如下

``` js
var param_str = 'api_key=B2Rou0PLPpGqcU0Vu2&leverage=100&symbol=BTCUSD&timestamp=1542434791000';

```

2. 对拼接后的字符串进行加签
```js
var secret = 't7T0YlFnYXk0Fx3JswQsDrViLg1Gh3DUU5Mr';
var sign = hex(HMAC_SHA256($secret, $param_str));
// sign = 670e3e4aa32b243f2dedf1dafcec2fd17a440e71b05681550416507de591d908
```

3.附加上sign参数，发送http请求,目前支持以下两种形式提交参数

```http
POST /user/leverage/save HTTP/1.1
Host: api-testnet.bybit.com
Content-Type: application/x-www-form-urlencoded
Content-Length: 144

api_key=B2Rou0PLPpGqcU0Vu2&leverage=100&symbol=BTCUSD&timestamp=1542434791000&sign=670e3e4aa32b243f2dedf1dafcec2fd17a440e71b05681550416507de591d908

```

```http
POST /user/leverage/save HTTP/1.1
Host: api-testnet.bybit.com
content-type: application/json
Content-Length: 183

{
    "api_key":"B2Rou0PLPpGqcU0Vu2",
    "leverage":100,
    "symbol":"BTCUSD",
    "timestamp":1542434791000,
    "sign":"670e3e4aa32b243f2dedf1dafcec2fd17a440e71b05681550416507de591d908"
}
```

### 返回结果格式

字段名 | 字段释义 | 示例值 |
:-: | :-: | :-:
ret_code | 返回码(0：成功,其他失败) | 0
ret_msg | 返回消息 | ok
ext_code | 补充错误码 | null
result | 不同业务接口返回与其对应的数据 |
