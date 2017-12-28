# 1. Disable database initialize process, and insert a new User
$ java -Dspring.datasource.initialize=false -jar target/SpringBootSpringSecurityMybatisThymeleafCRUD-0.0.1-SNAPSHOT.jar

#The MBG Maven plugin includes one goal:

mybatis-generator:generate
#The goal is not automatically executed by Maven. It can be executed in two ways.

#The goal can be executed from the command line with the command:

mvn mybatis-generator:generate
#You can pass parameters to the goal with standard Maven command line properties. For example:

mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
#This will run MBG and instruct it to overwrite any existing Java files it may find.


mvn useful command
-clean
-compile
-install
-test-compile
-compile

In-memory database test
http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-test-autoconfigure/
@RunWith(SpringRunner.class)
@MybatisTest
@Import(AdministratorUpdateConfirmDaoImpl.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)


URL Rewriting
@GetMapping(value = "/administrator/update{adminId}{adminName}")
<a
th:href="@{/admin/administrator/update/{adminId}{adminName}(adminId=${admin.adminId}, adminName=${admin.adminName})}">

<a th:href="@{/{createdDate}/{postTitleEng}(createdDate=${article.createdDate}, postTitleEng=${article.postTitleEng})}">
@GetMapping(value = { "/{createdDate}/{postTitleEng}" })
http://www.thymeleaf.org/doc/articles/standardurlsyntax.html


web: java $JAVA_OPTS -Dserver.port=$PORT -jar target/*.jar