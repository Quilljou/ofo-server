## 名词定义

- 项目中文名 - 
- 项目英文名 - 

- 管理员 - admin
- 电池 - battery
- 充电站 - station
- 充电柜 - equipment
- 充电模块 - module
- 整流模块 - rectification_module
- 编码 - code （不使用 id 是为了和数据库主键区分）


## 规范
- 数据库表字段名使用下划线格式
- 数量都用 count(比如module_count)

## Develop

- 目前开发通信部分，直接运行serverStart.java 

### Netty

#### 缺省定义

- 版本 0x01
- 序列号域 0xFF
- 预留 每一字节都为0x00

> 目前校验和未实现，随便补充一字节


## Deploy


