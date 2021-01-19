# Spring-Boot-Rest

<bold>We are always staring from a application that has been generated by https://start.spring.io/ and assume using lombok</bold>

Notes 

1. SpringApplication -- bootstraps a Spring Application from a Java Main Method

      Does the following:
         creates an AppliatoinContextInstance if important,
         registers a CommandLineProeprty Source to expose command line arguments as Spring Properties
         refereshes the ApplicationConext
         loads all single beans
         triggers any CommandLineRunner Bean
  
2. SpringApplicationBuilder is a builder for the Spring Application and ApplicationContext.  For example 
  .bannerMode(Banner.Model.OFF), logStartupInfo.

## Hosting a Rest Service using Spring Boot with Embedded tomcat

<code>
@SpringBootApplication
@Log
public class DemoApplication {

        @Autowired
        CrudRepository<Team, Long> crud;
        
        public static void main(final String[] args) {
                log.info("Charles Stockman: *** Starting Program ***");
                SpringApplication.run(DemoApplication.class, args);
        }

        /**
         * A routine to be executed after dependency injection is completed to perform any initialization
         * 
         * In this case the data is being saved to the database
         */
        @PostConstruct
        public void init() {
                
                List<Team> teams = DefaultData.getTeams();
                crud.saveAll(teams);
                log.info("Charles Stockman: Saved the following data to the database " + teams.toString());
        }
}
</code>

run mvn spring-boot:run

## Create a separate war file and deploy using the tomcat GUI

### Tomcat
Shoud have an user with roles: manager-gui

### POM File
Add the following <packaging>war</packaging> to tell maven to produce a war file

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-tomcat</artifactId>
</dependency>

### Main File

/**
 * The Start point of the Lab
 */
 
@SpringBootApplication
@Log
public class WarInitializerApplication extends SpringBootServletInitializer {


        @Autowired
        CrudRepository<Team, Long> crud;

        @Override
        // Just registers the our class as Configuration Class
        // The logic here will be executed by the web server.
        protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
                return builder.sources(WarInitializerApplication.class);
        }
        
        public static void main(final String[] args) {
                log.info("Charles Stockman: *** Starting Program ***");
                SpringApplication sa = new SpringApplication(WarInitializerApplication.class);
                sa.run(args);   
        }

        /**
         * A routine to be executed after dependency injection is completed to perform any initialization
         * 
         * In this case the data is being saved to the database
         */
        @PostConstruct
        public void init() {
                
                List<Team> teams = DefaultData.getTeams();
                crud.saveAll(teams);
                log.info("Charles Stockman: Saved the following data to the database " + teams.toString());
        }

}

## Deploy the war file using cargo

### Tomcat 
Should have manager-gui and manager-script

### maven
In server.xml for maven create an unique id and provide the username and password ( that contains the manager-gui and manager-script ) to login into the server

<pre>
  <server>
      &lt;id&gt;TomcatServer&lt;&gt;
      &lt;username>admin&lt;/username&gt;
      &lt;password>password&lt;/password&gt;
  </server>
</pre>

In the pom.xml add the following 
   &lt;artifactId&gt;spring-boot-starter-tomcat&lt;/artifactId>
   
   &lt;plugin&lt;
      &lt;groupId&gt;org.apache.tomcat.maven&lt;/groupId&gt;
      &lt;artifactId&gt;tomcat7-maven-plugin&lt;/artifactId&gt;
      &lt;version&gt;2.2&lt;/version&gt;
      &lt;configuration&gt;
            &lt;url&gt;http://localhost:8080/manager/text&lt;/url&gt;
            &lt;server&gt;TomcatServer&lt;/server&gt;
            &lt;path&gt;/rest-1&lt;/path&gt;
       &lt;/configuration&gt;
  &lt;/plugin&gt;






