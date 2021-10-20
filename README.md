# Version2
主要參考 [把玩 Spring Security [3] 拼上最後一哩路 AuthenticationProvider](https://qrtt1.medium.com/hands-on-spring-security-3-a57b32d933d1) 
的文章進行撰寫，並補充內容


## 新增限制對應路徑需要的授權

### MySecurityConfig 修改
-  `/users` 指令要有 USER Role 的人才能使用
-  `/admin` 並指定要有 ADMIN Role 的人才能使用
-  `/info` 沒有特定角色的授權，只要登入就行了
- 沒有提到的 / 是由 anyRequest() 開通無限制存取 permitAll()

### Controller
- 新增對應的 Controller

### FriendlyFilter
- SecurityContextHolder.getContext().setAuthentication(new ApiToken()) 中的 ApiToken
  - override getAuthorities 的方法
  - 設置回傳為 `ROLE_ADMIN` 的授權
  - 因此只有 /users 的被阻擋

---
## 新增 info 限制的方法
### Controller
- 在 RequestMapping 前面，再新增一個 @PreAuthorize("hasRole('USER')")
  - 表示需要有 user 的 role 才可以登入

### Application
- 在 @SpringBootApplication 也需要加上 @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
