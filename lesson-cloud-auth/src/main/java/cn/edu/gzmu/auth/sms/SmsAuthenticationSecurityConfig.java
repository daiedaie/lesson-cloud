package cn.edu.gzmu.auth.sms;

import cn.edu.gzmu.auth.user.SmsUserDetailsService;
import cn.edu.gzmu.auth.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * sms 授权配置
 *
 * @author echo
 * @version 1.0
 * @date 19-4-14 16:02
 */
@Component
public class SmsAuthenticationSecurityConfig
        extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final AuthenticationSuccessHandler smsSuccessHandler;
    private final AuthenticationFailureHandler authFailureHandle;
    private final UserDetailsServiceImpl userDetailsService;

    public SmsAuthenticationSecurityConfig(AuthenticationSuccessHandler smsSuccessHandler, AuthenticationFailureHandler authFailureHandle, UserDetailsServiceImpl userDetailsService) {
        this.smsSuccessHandler = smsSuccessHandler;
        this.authFailureHandle = authFailureHandle;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void configure(HttpSecurity http)  {
        // 过滤器链
        SmsAuthenticationFilter smsAuthenticationFilter = new SmsAuthenticationFilter();
        smsAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        smsAuthenticationFilter.setAuthenticationSuccessHandler(smsSuccessHandler);
        smsAuthenticationFilter.setAuthenticationFailureHandler(authFailureHandle);

        // 授权提供者
        SmsAuthenticationProvider smsAuthenticationProvider = new SmsAuthenticationProvider();
        smsAuthenticationProvider.setUserDetailsService(userDetailsService);

        http.authenticationProvider(smsAuthenticationProvider)
                .addFilterAfter(smsAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
