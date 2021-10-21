# Version1
主要參考 [把玩 Spring Security [1] 先讓一部分動起來](https://qrtt1.medium.com/hands-on-spring-security-1-77228057a8b9) 
的文章進行撰寫，並補充內容

## 實作情境
- "/users" : 有權限的人才可以使用
- "/" : 大家都可以開啟

## 預設 login
- 使用 spring security dependency 的狀況下，預設會擋住全部的網址，並導到 "/login" 的頁面
  ![](SecurityVersion2/src/main/resources/static/images/please sign in.png)
- 預設登入帳密
    ```
    user : user
    password : (參考 log 訊息)
    
    啟動 spring 時，log 會印出以下 :   
    Using generated security password: 3f15e909-7105-4b11-82e8-9c08b066f0af
    ```
## 設置全部 url 皆可直接通行，不用驗證
- 新增一個 class ，並繼承 WebSecurityConfigurerAdapter
- override configure(HttpSecurity http) 的方法
- 關掉 csrf，但實務上會加開 cors (待補充)
- override 後的方法為 : 
  ```java
  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable()
              .authorizeRequests()
              .anyRequest().permitAll();
  }
  ```
  
## 設置被阻擋的 url
- 新增 antMatchers 去捕捉需要檢核的 url 在 override configure(HttpSecurity http) 的方法上
  ```java
  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable()
              .authorizeRequests()
              //新增 "/users 相關 Pattern"，令它必需要通過身份驗證
              .antMatchers("/users**").authenticated()
              .anyRequest().permitAll();
  }
  ```
- 設置後，會產生 403 錯誤

## 重新設置"全部都可以通過驗證"的方式
- 只要 Security Filter 有設定 Authentication Object，就可以通過
- 實作 Security Filter :
  - extends OncePerRequestFilter，並實作裡面的方法 (doFilterInternal)
  ```java
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      SecurityContextHolder.getContext().setAuthentication(new ApiToken());
      filterChain.doFilter(request, response);
  }
  ```
  - 產生一個 ApiToken 的 class，implements Authentication
    - 實作 Authentication 全部的方法
    - 將 isAuthenticated 回傳改成 true
      ```java 
      public boolean isAuthenticated() {
        return true;
      }
      ```
- 將這個 Filter 加到 Spring Security Filter 鏈之中
  - 在 MySecurityConfig 中，新增 http.addFilterBefore
    ```java
    http.addFilterBefore(new FriendlyFilter(), LogoutFilter.class);
    ```

## 參考資料
- [把玩 Spring Security [1] 先讓一部分動起來](https://qrtt1.medium.com/hands-on-spring-security-1-77228057a8b9)
- [default user password](https://stackoverflow.com/questions/37285016/what-is-username-and-password-when-starting-spring-boot-with-tomcat)