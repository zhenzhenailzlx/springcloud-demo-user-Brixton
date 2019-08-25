# springcloud-demo-user-Brixton

1.pom文件引入依赖
要在项目中包含Eureka Client，请使用具有组org.springframework.cloud 和工件ID 的启动器spring-cloud-starter-eureka。

<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>

2.Application加入注解
@EnableEurekaClient使应用程序成为Eureka“实例”（即它注册自己）和“客户端”（即它可以查询注册表以查找其他服务）。
实例行为由eureka.instance.*配置键驱动，但如果您确保应用程序具有spring.application.name（这是Eureka服务ID或VIP 的默认设置），
则默认设置将是正常的 。

有关可配置选项的更多详细信息，请参阅EurekaInstanceConfigBean和EurekaClientConfigBean。

3.application.yml配置
spring:
  application:
    name: user
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
      
4.健康检查
默认情况下，Eureka使用客户端心跳来确定客户端是否已启动。除非另有说明，否则Discovery Client不会根据Spring Boot Actuator传播应用程序的当前运行状况
检查状态。这意味着在成功注册后，Eureka将始终宣布应用程序处于“UP”状态。通过启用Eureka运行状况检查可以更改此行为，从而将应用程序状态传播到Eureka。
因此，每个其他应用程序将不会在“UP”之外的状态下向应用程序发送流量。
eureka：
  client：
    healthcheck：
      enabled：true
      
5.为什么注册服务这么慢？
作为一个实例还涉及到注册表（通过客户端serviceUrl）的定期心跳，默认持续时间为30秒。在实例，服务器和客户端在其本地缓存中都具有相同的元数据之前，
客户端无法发现服务（因此可能需要3次心跳）。您可以使用更改周期 eureka.instance.leaseRenewalIntervalInSeconds，这将加快将客户端连接到其他服务的过程。
在生产中，最好坚持使用默认值，因为服务器内部有一些计算可以假设租约续订期。

