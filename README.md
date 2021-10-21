# J.J.'s Blogs Spring Security 安全機制

## 目錄結構

```xml
├─ src            
│ ├─ main
│ │ ├─ java
│ │ ├─ resources
│ │ │ ├─ static
│ │ │ ├─ templates
│ ├─ test
├─ pom.xml      
```

- static : 靜態資源目錄
  - 用於存放 css, js, images 等，會再細分這些檔案夾出來
- templates : 模板目錄
  - Spring Boot提供了默認配置的模板引擎主要有以下幾種，官方建議使用這些模板引擎，避免使用JSP
      Thymeleaf、FreeMarker、Velocity、Groovy、Mustache
- 但基本上，Spring boot 常作為後端，提供 API 的使用。前端顯示則是交給前端框架進行設計(如 vue、React 等)

## Spring MVC

- @Controller : 標記的類別為 Spring MVC 的 Controller 物件，並檢測有沒有使用到 @RequestMapping
- 有使用到 @RequestMapping，則會回傳該名稱的檔案做成網頁


## 遇到問題

### cannot resolve mvc view

- 新增 thymeleaf 的 dependency 就好了

  ```xml
     <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
  ```

- [Spring - Cannot resolve MVC “view” thymeleaf](https://stackoverflow.com/questions/60002080/spring-cannot-resolve-mvc-view-thymeleaf)
- [SpringBoot - 第三章 | 目錄結構](https://morosedog.gitlab.io/springboot-20190314-springboot3/)
- [Spring Security 安全控制](https://morosedog.gitlab.io/springboot-20190428-springboot39/)
  - 程式碼來源
