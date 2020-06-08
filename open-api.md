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

# api说明
## 交易
## 资产
