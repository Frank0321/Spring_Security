# Version3
主要參考 [把玩 Spring Security [3] 拼上最後一哩路 AuthenticationProvider](https://qrtt1.medium.com/hands-on-spring-security-3-a57b32d933d1) 
的文章進行撰寫，並補充內容

## 程式流程
- 依序由外而內為 :
- MySecurityConfig (extends WebSecurityConfigurerAdapter)
- FriendlyFilter (extends OncePerRequestFilter)
- ApiToken (implements Authentication )

