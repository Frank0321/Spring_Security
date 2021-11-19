# Spring Security with JPA

## 介紹
讀取資料庫的資料，來盼定使用者可以存取的權限
1. SecurityConfiguration (extends WebSecurityConfigurerAdapter):
- override configure
> - 設定各網頁的存取權限
> - 開啟 h2-console，使 h2 db 不會受到 security 而打不開
- PasswordEncoder ??

2. MyUserDetailsService (implements UserDetailsService)
- 實作 loadUserByUsername
> - 登入者為 Entity(User) 抓出來的資料

3. User (implements UserDetails)
- 實作 UserDetails，並回傳登入的權限、帳密等資訊

## 參考資料
- [Spring Boot + Spring Security with JPA authentication](https://www.youtube.com/watch?v=TNt3GHuayXs&t=1784s)

## 使用 JPA @CreatedBy、@LastModifiedBy 為 security 登入的名稱
- 因為使用到 @CreateBy、@LastModifiedBy 所以 Entity 需要使用到 @EntityListeners
> @EntityListeners(AuditingEntityListener.class)

- 需要一個 class 實作 AuditorAware，並設置回傳型別為 String
```java
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .filter(UserDetails.class::isInstance)
                .map(UserDetails.class::cast)
                .map(UserDetails::getUsername);
    }
}
```
- 在 xxxApplication 新增一個 annotation，確保啟動時 AuditorAware 會被掃到
```java
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
/*
...........        
 */
@Bean
public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
        }
```
### 參考資料
- [@CreatedBy and @LastModifiedBy set actual entity instead of id](https://stackoverflow.com/questions/53658463/createdby-and-lastmodifiedby-set-actual-entity-instead-of-id)
- 再保 V3
> - AbstractEntity.java
> - AuditorAwareImpl.java
> - PersistenceConfig.java