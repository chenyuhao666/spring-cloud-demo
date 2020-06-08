---
title: API接入文档
renderNumberedHeading: true
---
___

# 配置
API-URL: 
要求：
所有HTTP请求和响应都是application / json内容类型，并且使用成功和失败的典型HTTP响应状态代码。所有成功的请求都将以HTTP 2xx状态代码进行响应，并将包含一个正文。所有其他请求将以HTTP 4xx或5xx状态代码响应。此外，主体将包含一系列错误消息，以帮助您了解故障原因。
# 认证方式
对API端点的所有HTTP请求都需要身份验证和授权。
用户可以通过创建API-KEY流程获得key和sercet，key和sercet用于验证和授权所有请求。
以下标头应添加到所有HTTP请求中：
Key  | Value
------------- | -------------
x-access-key  | <API_KEY>
x-access-sign  |  \<signatureOfRequest>
x-access-timestamp  | \<timeOfRequest> (in milliseconds)

您可以在下方代码块找到有关如何生成签名的示例。引用了以下变量：
Variable  | Description
------------- | -------------
timeOfRequest  | 当前时间格式为当前的时间戳（以毫秒为单位）
signatureOfRequest  |  用Base64解码的SECRET签名的requestText的Base64字符串编码的HMAC-SHA256
requestText  | 由以下内容组成的纯字符串连接：timeOfRequest，payload（GET请求字段连接串例如: xxx=1&xxx=2&xxx=3）若为POST请求，进行签名时也需要转成该连接串

样例：
```java
private static String createSignature(String timeOfRequest,String payload,String secret)
        throws Exception {
        String requestText = timeOfRequest + payload;
        return Base64Utils.encodeToString(hmacSha1(requestText, secret));
}
 
private static byte[] hmacSha1(String plainData, String secret)  throws Exception{
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = 
		     new SecretKeySpec(Base64Utils.decodeFromString(secret),"HmacSHA256");
        mac.init(secretKey);
        return mac.doFinal(plainData.getBytes());
}
 
        String secret = "894f142d667e8cdaca6822ac173937af";
        String timeOfRequest ="1478692862000"; //new Date();
        
        String payload = testString;  //filed1=1&filed2=2&filed3=3
 
        String signatureOfRequest = createSignature(timeOfRequest,payload,secret));
        //XkXoFUTmr8+Yy/lZZ2xalT/zWsRRJ8RaHMbJtisuGfU=
```
⚫从现在开始，所有代码示例都将假定您已经附加身份验证标头
# api说明
## 交易
### 创建订单
Http request:  POST /order/create
请求正文：
参数名  | 类型  | 是否必填   | 注释   | 说明
------------- | -------------  | -------------  | -------------  | -------------
orderId  | String   | true  | 订单号  | 不能重复
instrumentId  | String   | true  | 合约号  | 样例 ETH-BTC
direction  |  String  | true  | 方向 | 0-买 1-卖
orderType  | String  | true  | 订单类型  | 1-限价单、2-市价单 、3-止盈止损 、4-冰山订单 、5-隐藏订单
limtPrice  | String | true  | 价格  | 当订单类型为3 时必填
stopPrice  | String  | true/false  | 触发价  | 当订单类型为4 时必填
displaySize  | String  | true/false  | 展示数量| <API_KEY>
amount  | String | true | 数量  | <API_KEY>
timeCondition  | String  | true  | 有效期类型  | 0-立即完成，否则撤销 、1-本节有效 、2-当日有效 、3-指定日期前有效 、4-撤销前有效 、5-集合竞价有效
gtdDate  | String  | false | 有效期  | 格式：yyyyMMdd

响应正文：
参数名  | 类型 | 注释   | 说明
------------- | ------------  | -------------  | -------------
orderId  | String  | 订单号  | 不能重复
instrumentId  | String  | 合约号  | 样例 ETH-BTC
direction  |  String  | 方向 | 0-买 1-卖
orderType  | String  | 订单类型  | 1-限价单、2-市价单 、3-止盈止损 、4-冰山订单 、5-隐藏订单
limtPrice  | String  | 价格  | 当订单类型为3 时必填
stopPrice  | String  | 触发价  | 当订单类型为4 时必填
displaySize  | String   | 展示数量| <API_KEY>
amount  | String | 数量  | <API_KEY>
timeCondition  | String  | 有效期类型  | 0-立即完成，否则撤销 、1-本节有效 、2-当日有效 、3-指定日期前有效 、4-撤销前有效 、5-集合竞价有效
gtdDate  | String | 有效期  | 格式：yyyyMMdd
timestamp  | String | 操作时间戳  | 13位

响应码：
响应码  | 描述 
------------- | ------------ 
200  | 下单成功、订单已经提交处理
207  | 下单请求包含格式验证错误。查看结果以获取详细信息
400  | 请求格式无效

样例：
```java
请求样例：
响应样例：
```

### 撤销订单
### 查询订单
### 查询成交
## 资产
### 查询资产
