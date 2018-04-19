# 磁力搜搜接口文档

## 用户

- 创建用户 （user/login）
```
    //uid
    request {
        //请求时间
        time:33618736813,
        //设备型号
        dev:xiaomi,
        //app版本 versionCode
        ver:100,
        data{
            uid:"……………………" 
        
        }
          
    
    }
    //userInfo
    response{
          msg    :"",
          status :0 ,
          data{
                uid:""
         
          }        
    
    }


```


## 支付

- 充值接口      (pay/recharge)充值获取积分

- 创建订单      (pay/create_order) 


```
    //uid
    request {
        //请求时间
        "time":33618736813,
        //设备型号
        "dev":xiaomi,
        //app版本 versionCode
        "ver":100,
        "data":{
            "uid":"……………………" 
            "id":".....",
            "type":1
        
        }
          
    
    }
    //userInfo
    response{
          msg    :"",
          status :0 ,
          data{
                uid:""
         
          }        
    
    }



- 支付异步通知   (pay/notify)

## 积分

####  种子币（用于复制链接）

- 种子币扣除 （）
```
    //uid
    request {
        //请求时间
        time:33618736813,
        //设备型号
        dev:xiaomi,
        //app版本 versionCode
        ver:100,
        data{
            id:""
            uid:"……………………" 
            count:""
        
        }
          
    
    }
    //userInfo
    response{
          msg    :"",
          status :0 ,
          data{
                uid:""
         
          }        
    
    }


```

####  积分 （用于兑换话费）

- 积分扣除    ()

## 更新

- 版本更新

- 协议更新

## 电影

- 推荐热门电影


