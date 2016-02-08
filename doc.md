## Running application

**Requirements:**

- Apache Tomcat 8 (developed and tested on)
- JRE 8 (Java Runtime Environment)

**Steps (auto deploy enabled):**

1. Run Apache Tomcat 8
2. Move generated SEB-1.0.war file into %tomcat%/webapps folder

**Steps (auto deploy disabled):**

1. Stop Apache Tomcat 8 if it is running
2. Delete temp and work folders in %tomcat% directory
3. Move generated SEB-1.0.war file into %tomcat%/webapps folder
4. Start Apache Tomcat 8

**%tomcat% - base directory for Apache Tomcat 8**

## Architecture

As Spring MVC is used, architecture is model-view-controller based.

## Used tools, libraries, etc

- **Maven** – for project’s build and dependencies management
- **Apache FreeMarker** – as a template engine to generate output text based on templates and changing data
- **Spring** – for dependency injection
- **Spring MVC** – provides model-view-controller architecture and components used to develop web applications
- **Jackson** – for JSON data-binding. Ability to convert POJO’s to JSON and back.
