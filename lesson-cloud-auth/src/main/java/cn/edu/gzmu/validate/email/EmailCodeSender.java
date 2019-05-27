package cn.edu.gzmu.validate.email;

import cn.edu.gzmu.util.EmailUtils;
import cn.edu.gzmu.validate.ValidateCode;
import cn.edu.gzmu.validate.ValidateCodeSender;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.HashMap;

/**
 * @author echo
 * @version 1.0
 * @date 19-5-21 23:52
 */
@Slf4j
@RequiredArgsConstructor
public class EmailCodeSender implements ValidateCodeSender {

    private final @NonNull EmailUtils emailUtils;

    @Override
    public void send(String receive, ValidateCode code) {
        HashMap<String, Object> variables = new HashMap<>(1);
        variables.put("code", code.getCode());
        variables.put("time", Duration.ofSeconds(code.getExpireIn()).toMinutes());
        emailUtils.sendTemplateMail(receive, "注册", "[云课程]欢迎注册", "registerTemplate.html", variables);
    }
}
