# Spring_Security + JPA
使用 Spring security 搭配 H2 DB 操作 JPA

## h2 設定
- 需要先指定好開啟 h2 的 url
- 新增 SecurityConfiguration ，並指定說 h2 的 url 可以通過
- 並設置說，網站來自自己的 local ，則可以開啟
- 整體設置如下 :
```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/h2-console/**").permitAll()
            .and().headers().frameOptions().sameOrigin();

}
```

- [Spring Security for h2-console](https://jessitron.com/2020/06/15/spring-security-for-h2-console/)