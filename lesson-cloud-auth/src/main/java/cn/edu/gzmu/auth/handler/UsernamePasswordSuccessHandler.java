package cn.edu.gzmu.auth.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理器
 *
 * @author echo
 * @version 1.0
 * @date 19-5-21 10:45
 */
@Slf4j
@Component
public class UsernamePasswordSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // TODO: 刷新令牌操作 —— 待完成
        // 最讨厌的一些东西就是某些时候解决不了，后面却可以轻松解决
        // 永远不知道第一次在写的时候想什么
        log.debug("login ~~~~~~~~~~~~");
    }
}
