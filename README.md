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
      
4.1 Spring Boot Actuator: Production-ready features

Definition of Actuator
An actuator is a manufacturing term, referring to a mechanical device for moving or controlling something.
 Actuators can generate a large amount of motion from a small change.

4.1.1 如何引如
The spring-boot-actuator module provides all of Spring Boot’s production-ready features. 
The simplest way to enable the features is to add a dependency to the spring-boot-starter-actuator ‘Starter POM’.
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

4.1.2 Endpoints
Actuator endpoints allow you to monitor and interact with your application. 
Spring Boot includes a number of built-in endpoints and you can also add your own. For example the health endpoint provides basic application health information.

The way that endpoints are exposed will depend on the type of technology that you choose. 
Most applications choose HTTP monitoring, where the ID of the endpoint is mapped to a URL. 
For example, by default, the health endpoint will be mapped to /health.

The following endpoints are available:

ID	Description	Sensitive Default
actuator

Provides a hypermedia-based “discovery page” for the other endpoints. Requires Spring HATEOAS to be on the classpath.

true

autoconfig

Displays an auto-configuration report showing all auto-configuration candidates and the reason why they ‘were’ or ‘were not’ applied.

true

beans

Displays a complete list of all the Spring beans in your application.

true

configprops

Displays a collated list of all @ConfigurationProperties.

true

docs

Displays documentation, including example requests and responses, for the Actuator’s endpoints. Requires spring-boot-actuator-docs to be on the classpath.

false

dump

Performs a thread dump.

true

env

Exposes properties from Spring’s ConfigurableEnvironment.

true

flyway

Shows any Flyway database migrations that have been applied.

true

health

Shows application health information (when the application is secure, a simple ‘status’ when accessed over an unauthenticated connection or full message details when authenticated).

false

info

Displays arbitrary application info.

false

liquibase

Shows any Liquibase database migrations that have been applied.

true

logfile

Returns the contents of the logfile (if logging.file or logging.path properties have been set). Only available via MVC. Supports the use of the HTTP Range header to retrieve part of the log file’s content.

true

metrics

Shows ‘metrics’ information for the current application.

true

mappings

Displays a collated list of all @RequestMapping paths.

true

shutdown

Allows the application to be gracefully shutdown (not enabled by default).

true

trace

Displays trace information (by default the last few HTTP requests).

true

4.1.3 Health information
Health information can be used to check the status of your running application. 
It is often used by monitoring software to alert someone if a production system goes down. 
The default information exposed by the health endpoint depends on how it is accessed. 
For an unauthenticated connection in a secure application a simple ‘status’ message is returned, 
and for an authenticated connection additional details are also displayed (see Section 46.6, “HTTP health endpoint access restrictions” for HTTP details).

Health information is collected from all HealthIndicator beans defined in your ApplicationContext. 
Spring Boot includes a number of auto-configured HealthIndicators and you can also write your own.

4.1.4 Auto-configured HealthIndicators

The following HealthIndicators are auto-configured by Spring Boot when appropriate:

Name	Description
CassandraHealthIndicator

Checks that a Cassandra database is up.

DiskSpaceHealthIndicator

Checks for low disk space.

DataSourceHealthIndicator

Checks that a connection to DataSource can be obtained.

ElasticsearchHealthIndicator

Checks that an ElasticSearch cluster is up.

JmsHealthIndicator

Checks that a JMS broker is up.

MailHealthIndicator

Checks that a mail server is up.

MongoHealthIndicator

Checks that a Mongo database is up.

RabbitHealthIndicator

Checks that a Rabbit server is up.

RedisHealthIndicator

Checks that a Redis server is up.

SolrHealthIndicator

Checks that a Solr server is up.

[Tip]
It is possible to disable them all using the management.health.defaults.enabled property.


      
5.为什么注册服务这么慢？
作为一个实例还涉及到注册表（通过客户端serviceUrl）的定期心跳，默认持续时间为30秒。在实例，服务器和客户端在其本地缓存中都具有相同的元数据之前，
客户端无法发现服务（因此可能需要3次心跳）。您可以使用更改周期 eureka.instance.leaseRenewalIntervalInSeconds，这将加快将客户端连接到其他服务的过程。
在生产中，最好坚持使用默认值，因为服务器内部有一些计算可以假设租约续订期。

