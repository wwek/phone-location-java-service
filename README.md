# phone-location-java-service
phone-location-java-service是一个电话号码归属地微服务应用

HTTP 1.1/API

## 快速使用
phone-location-java-service不直接提供jar包,如需jar请自行编译
只提供Docker容器镜像

运行
```
docker run --rm -p 8080:8080  wwek/phone-location-java-service:latest
```

请求
```
curl "http://127.0.0.1:8080/v1/phone?phoneNumber=13888888888" 
```
返回
```
{
	"code": 0,
	"msg": "ok",
	"data": {
		"phoneNumber": "13888888888",
		"province": "云南",
		"city": "昆明",
		"zipCode": "650000",
		"areaCode": "0871",
		"phoneType": "移动"
	}
}
```


## 感谢
https://github.com/fengjiajie/phone-number-geo