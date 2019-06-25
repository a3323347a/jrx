

#week-2 microservice
	week2-microservice-center:   微服务中心
	week2-microservice-consumer-80：    微服务消费者，使用Ribbon负载均衡
	week2-microservice-consumer-feign：  微服务消费者，使用feign负载均衡
	week2-microservice-eureka-7001：    eureka注册中心，端口：7001
	week2-microservice-provider-8001：  微服务提供者，8001端口
	week2-microservice-provider-8002：  微服务提供者，8002端口
	
	
#week2-springbatch-demo
	batch_DTD.xml：读取数据库一张表的数据并做处理存到另外一张表
	batch_DTF.xml：读取数据库数据并处理后存放到文件中
	batch_FTD.xml：读取文件数据并处理后存放到数据库
	batch_public.xml： 公共配置文件
	sql文件：week2-springbatch-demo\src\main\resources\sql
	
#week3  数据库SQL文件在rescources里面
    #springboot-jpa
    关系:   一个customer对应多个linkman,一个linkman对应一个customer
            一个role对应多个user，一个user对应多个role
    springboot集合了jpa，测试了常见的CRUD操作，还配置一对一，一对多，多对多关系
    并在test包写了5个测试类，测试了级联添加、级联删除、分页查询、模糊查询等等
    并在级联删除、级联添加等操作配置了事务，删除一个对象就删除他所关联的所有对象
    
    #springboot-mybatis
    springboot集合了mybatis，功能同样和上面相似CRUD，配置一对一，一对多，多对多，并测试
    级联删除、级联添加等
#week4  数据库SQL文件在rescources里面    springbatch和mybatisdemo用的SQL文件是一样的
    #springbatch        传入job参数,按照日期每天汇总一次
    batch-dbtodb.xml    读取数据库交易明细表和客户表并汇总到汇总表
    batch-filetodb.xml  读取2个数据文件并写到数据库
    public-batch.xml    公共的batch配置信息
    
    #mybatisdemo
    1. 配置了log日志分类,按照错误类型,每天自动分类
    2. 配置swagger接口测试文档
    3. 配置了统一json返回数据,并统一返回异常信息,接口测试时友好提示错误代码和错误信息
    4. 集合了mybatis的分页插件、对表进行增删查改、由于功能类似,所以在CustomerController比较齐全,
       但是其他汇总表、交易明细表的mapper接口都有实现对数据操作的许多方法
