# 12306 验证码自动识别


# 基础环境
- JDK8
- maven
- python3

# python 依赖安装
Mac 或者 Linux 用户使用虚拟环境：
```
cd ticket/python

python3 -m venv venv

source venv/bin/activate

sudo pip install -r requirements.txt

```
Windows 用户使用本地当前环境：
```
cd ticket/python

sudo pip install -r requirements.txt

```
> 如果上面依赖下载太慢，可以使用 `pip install -r requirements.txt -i https://pypi.tuna.tsinghua.edu.cn/simple` 下载。

# 验证码识别测试
Mac 或者 Linux 用户使用虚拟环境：
```
cd ticket/python

source venv/bin/activate

python3 main.py ../temp/index.jpg
```

Windows 用户使用本地当前环境： 

```
cd ticket/python


python main.py ../temp/index.jpg
```

# 在线调用

我自己部署了一套，可以测试一把，不要暴力使用啊。。。

API：http://captcha.qianxunclub.com/api/captcha  
Method：POST  
Content-Type：application/json  
参数：image 入参为 base64图片字符串  
```
curl -H "Content-Type: application/json" -X POST  --data '{"image":"base64图片"}' http://captcha.qianxunclub.com/api/captcha
```

