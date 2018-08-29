# httpclient3.x工具包概要设计

[TOC]

---

## 修订历史

|文档版本|更新时间|内容|作者|
|---|---|---|---|
|1.0.0|2018-08-09|创建|林东|

## 概述
>http客户端调用工具包，基于httpclient3.1(org.apache.commons.httpclient)开发，针对http请求相关业务需求进行封装。  
包含功能 
* 1、http连接池
* 2、提供form表单和body两种方式请求

## 名称说明
### http连接池
>在七层网络协议中，http协议属于应用层协议，主要聚焦在规范数据层面，定义报文规则，使接收方能正确解析和响应，而在应用层下面的传输层，主要聚焦数据传输层面，包括tcp、ftp协议。http请求（连接）最终必须绑定到一个tcp连接进行上下行传输。传统http请求流程，为收到http请求，封装http报文，建立tcp连接，传输数据，收到响应，断开tcp连接，请求完成，每次请求都要新建一个tcp连接。httpclient建立的连接池是传输层tcp连接。接收到http后，包装http报文，在发送时，从连接池中获取一个tcp连接进行传输，传输完毕后不关闭tcp连接，而是归还给连接池，由连接池维护tcp连接的生命周期，从而实现tcp连接的复用，减少系统和服务端频繁建立tcp连接的消耗，在高并发时这个损耗比较大。另一方面，在高并发时，通过连接池可以有效的减少并发tcp连接数，减少客户端服务监听端口消耗，监听端口数量是有限，从而提高系统吞吐量，用少量tcp连接处理大量http请求，增加处理性能。最后，对于服务端，并发的tcp连接减少了，减少了服务端处理并发峰值压力，增加服务端稳定性。

## 工具类说明
### HttpClientTools(主调工具类)
>工具类中封装了httpClient发送请求的静态方法
### HttpClientConfig(httpClient配置类)
>配置http请求中的字符集、Header等信息的配置
### HttpClientPool(httpClient连接池)
>此类中提供了，设置连接池属性的静态方法，不配置则用默认配置。  采用单例模式，提供了HttpClient的初始化
### HttpClientPoolConfig(httpClient链接池参数配置)
>连接池、httpClient的基础配置，涵盖最大连接数、连接超时配置、响应超时配置等基础配置
### HttpReq(http请求对象)
>http请求的参数对象，涵盖请求地址、请求参数、字符集等属性
### HttpResp(http响应对象)
>http响应的参数对象，涵盖响应状态、标题头、响应内容(byte)等信息

### 配置属性
#### ConnectionTimeout
>建立连接超时时间，创建tcp连接的超时时间。调小这个值，可以有效减少异常请求地址对连接的占用，将连接留给质量好的请求。
#### SocketTimeout
>响应超时时间，两次响应之间间隔时间，对于一般请求只有一次响应，为服务端响应超时时间，对处理时间较长的接口，需要调整此值。调小此连接也可以提高响应速度，增加系统吞吐，会增加异常请求概率，如有需要，需使用重发机制，此时服务端要考虑幂等处理。
#### ConnectionManagerTimeout
>从连接池中获取连接的超时时间，即等待ConnectionManager释放connection的时间。在高并发情况下，连接池会不断创建新的连接，直到达到连接池最大连接数，此时连接池中已无空闲连接情况下，新的获取连接请求会处于等待状态，这个参数就是设置等待超时时间。调小这个时间，可以有效的提高响应速度并降低积压请求量，但是会增加请求失败概率。
#### idleConnTimeout
>空闲连接超时时间。设置了该值，超时的链接将在下一次空闲链接检查时被销毁
#### PoolMaxTotal
>连接池最大总连接数。
#### MaxPerRoute
>连接池最大路由连接数，一个主机和端口组成一个路由，针对此路由设置的最大连接数。主要限制每个路由连接数，不会出现某个路由占用整个连接池连接数，导致其他路由生成不了连接情况。这个可以根据具体情况设置，如果已知同意时刻只有一个路由存在时，可以将路由连接数等于最大连接数。

### 使用方式
#### http工具类使用
```
//http调用.sendPost方式，还有其他方式同理(使用当前系统中设置的配置)
String url = "http://testbs.ggjfw.com/channel-gateway/inner/method/testTimeOut.do";
Map<String, String> map = new HashMap<String, String>();
map.put("timeout", "10000");
System.out.println("准备发请求:"+getNowDateTime());
try {
	HttpResp httpResp = HttpClientTools.sendPost(url, map);
	System.out.println("收到响应:"+getNowDateTime());
	if (httpResp != null && httpResp.isSuccess()){
		System.out.println(getNowDateTime());
		System.out.println("成功了");
	}else{
		System.out.println(getNowDateTime());
		System.out.println("失败了");
	}
} catch (HttpCommonException e) {
	System.out.println(e.getCode()+"-"+e.getMsg());
}

```
#### 初始化连接池方式
```
//连接池配置，项目启动时初始化一次即可。如不设置否则使用默认配置。
HttpClientPoolConfig httpClientPoolConfig = new HttpClientPoolConfig();
httpClientPoolConfig.setConnectionTimeout(20000);//获取连接超时时间（毫秒）
httpClientPoolConfig.setSocketTimeout(5000);//响应超时时间（毫秒）
httpClientPoolConfig.setConnectionManagerTimeout(60000);//等待ConnectionManager释放connection的时间 毫秒
httpClientPoolConfig.setIdleConnTimeout(60000);//闲置连接超时时间 毫秒
httpClientPoolConfig.setPoolMaxTotal(100);//连接池大小
httpClientPoolConfig.setMaxPerRoute(50);//每个路由最大值
HttpClientPool.init(httpClientPoolConfig);

```
#### 重载更新连接池配置
```
//重载连接池配置(改变系统中的配置)
HttpClientPoolConfig httpClientPoolConfig = new HttpClientPoolConfig();
httpClientPoolConfig.setConnectionTimeout(20000);//获取连接超时时间（毫秒）
httpClientPoolConfig.setSocketTimeout(5000);//响应超时时间（毫秒）
httpClientPoolConfig.setConnectionManagerTimeout(60000);//等待ConnectionManager释放connection的时间 毫秒
httpClientPoolConfig.setIdleConnTimeout(60000);//闲置连接超时时间 毫秒
httpClientPoolConfig.setPoolMaxTotal(100);//连接池大小
httpClientPoolConfig.setMaxPerRoute(50);//每个路由最大值
HttpClientPool.reload(httpClientPoolConfig);

```
#### 获取httpClient
```
//工具类默认方法中使用的方式
//获取默认的httpClient(使用当前系统中设置的配置)
HttpClientPool.getHttpClient();

```
#### 获取httpClient并更新连接池配置
```
//默认方法中不使用该方式
//获取新配置的httpClient(改变系统中的配置)
HttpClientPoolConfig httpClientPoolConfig = new HttpClientPoolConfig();
httpClientPoolConfig.setConnectionTimeout(20000);//获取连接超时时间（毫秒）
httpClientPoolConfig.setSocketTimeout(5000);//响应超时时间（毫秒）
httpClientPoolConfig.setConnectionManagerTimeout(60000);//等待ConnectionManager释放connection的时间 毫秒
httpClientPoolConfig.setIdleConnTimeout(60000);//闲置连接超时时间 毫秒
httpClientPoolConfig.setPoolMaxTotal(100);//连接池大小
httpClientPoolConfig.setMaxPerRoute(50);//每个路由最大值
HttpClientPool.getHttpClient(httpClientPoolConfig);

```

### 结论要点
#### 访问重试
>访问域名时，cdn 10秒会掐断一次，导致自动重发请求3次，每一次间隔为10s，当第3次失败时抛Connection reset，若第1、2次失败则抛read time out。所以如果是访问域名时，响应超时时间最好要设置在10秒内。  
访问ip时，则不会掐断重试，失败时抛read time out


