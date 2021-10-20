package com.example.Spring_Security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
@RequiredArgsConstructor
public class FriendlyFilter extends OncePerRequestFilter {

    final AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //hasAuthenicated 是額外寫的方法
        if(hasAuthenicated()){
            filterChain.doFilter(request, response);
            return;
        }

        // 查看 HTTP REQUEST 中有沒有可以用來認證的資料
        Authentication requestToken = asAuthentication(request);
        // 沒有可以用的認證資料，那就是別人家的事了
        if(requestToken == null){
            filterChain.doFilter(request, response);
            return;
        }

        // 交給 Plugin 大總管，詢問各別 plugin 有沒有辦法做
        Authentication authenticate = authenticationManager.authenticate(requestToken);
        // 沒有人通過認證
        if(authenticate == null || !authenticate.isAuthenticated()){
            filterChain.doFilter(request, response);
            return;
        }

        // 成功通過認證
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        filterChain.doFilter(request, response);

    }

    private Authentication asAuthentication(HttpServletRequest request) {
        String token = request.getHeader("x-twjug-authorization");
        if (token == null){
            return null;
        }
        return new ApiToken(token);
    }

    private boolean hasAuthenicated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication !=null && authentication.isAuthenticated();
    }
}
