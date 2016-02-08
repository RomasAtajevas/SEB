## Running application

**Requirements:**

- Apache Tomcat 8 (developed and tested on)
- JRE 8 (Java Runtime Environment)

**Steps (auto deploy enabled):**

1. Run Apache Tomcat 8
2. Move generated _SEB-1.0.war_ file into %tomcat%/webapps folder
3. Access application by typing _localhost:8080/SEB-1.0_ into browser's address bar (change _localhost_ to appropiate host if needed)

**Steps (auto deploy disabled):**

1. Stop Apache Tomcat 8 if it is running
2. Delete _temp_ and _work_ folders in %tomcat% directory
3. Move generated _SEB-1.0.war_ file into %tomcat%/webapps folder
4. Start Apache Tomcat 8
5. Access application by typing _localhost:8080/SEB-1.0_ into browser's address bar (change _localhost_ to appropiate host if needed)

**%tomcat% - base directory for Apache Tomcat 8**

## Architecture

As Spring MVC is used, architecture is model-view-controller based.

## Used tools, libraries, etc

- **Maven** – for project’s build and dependencies management.
- **Apache FreeMarker** – as a template engine to generate output text based on templates and changing data.
- **Spring** – for dependency injection.
- **Spring MVC** – provides model-view-controller architecture and components used to develop web applications.
- **Jackson** – for JSON data-binding. Ability to convert POJO’s to JSON and back.
- **Chart.js** - for displaying charts
