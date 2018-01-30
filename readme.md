## Develop

- 目前开发通信部分，直接运行serverStart.java 

### Netty

#### 缺省定义

- 版本 0x01
- 序列号域 0xFF
- 预留 每一字节都为0x00

自拟充电桩编码

```
31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32
```

> 目前校验和未实现，随便补充一字节


#### 报文


##### 握手

握手 c => s

```
AA F5 54 00 01 FF 6a 00 00 00 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 00 00 00 01 00 00 00 01 04 00 64 04 0f 01 00 00 00 20 18 01 29 11 28 23 ff 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 79
```

握手应答 s => c

```
 aa f5 0d 00 01 ff 69 00 00 00 00 00 69
```

##### 心跳

请求 c => s

```
AA F5 2d 00 01 FF 66 00 00 00 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 01 00 79
```

响应 s => c

```
aa f5 0d 00 01 ff 65 00 00 00 00 01 66
```

## Deploy