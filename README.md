# Spring_Security

## 介紹
Spring Security 是一個安全框架，它的函式庫提供了
- 驗證（authentication） : 系統認為用戶是否可以登入
- 授權（authorization） : 系統判斷用戶是否有權限執行某些事情
- spring security 在web應用中是基於filter的，可以擁有身份驗證與訪問控制的實作，有安全管理的機制與預設GUI驗證畫面與機制
  
等有關安全管理的功能

- [影音介紹影片](https://www.youtube.com/watch?v=_-vl4n-CBdI&t=548s)
- [投影片介紹](https://github.com/Frank0321/Spring_Security/blob/master/src/main/resources/static/Spring%20security%20%E7%B0%A1%E5%A0%B1.pdf)

## CSRF (跨站請求偽造)

- [讓我們來談談 CSRF](https://blog.techbridge.cc/2017/02/25/csrf-introduction/)

## 登入與登出
### 預設的情況下
- /login
> - 會出現一個地方，讓你輸入帳密
> - ![](https://github.com/Frank0321/Spring_Security/blob/master/src/main/resources/static/security_login.png)
- /logout
> - 登出後，會讓你再次登入
> - ![](https://github.com/Frank0321/Spring_Security/blob/master/src/main/resources/static/security_logout.png)
> - 或是再次輸入 /login
## 範例程式
- 以不同的 branch 做區分，並分別寫 README.md 做介紹


### 參考
- [Spring Security - 結合 RestfulApi 的設計](https://blog.kennycoder.io/2019/09/04/Spring-Security-%E7%B5%90%E5%90%88RestfulApi%E7%9A%84%E8%A8%AD%E8%A8%88/)

#### 使用 postman 登入
- POST method
- Body
- from-data
- [](https://i.stack.imgur.com/UXQd9.png)