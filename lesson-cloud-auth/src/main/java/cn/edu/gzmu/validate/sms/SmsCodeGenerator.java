package cn.edu.gzmu.validate.sms;

import cn.edu.gzmu.config.SmsProperties;
import cn.edu.gzmu.util.RandomCode;
import cn.edu.gzmu.validate.ValidateCode;
import cn.edu.gzmu.validate.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author echo
 * @version 1.0
 * @date 19-4-14 14:11
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    private final SmsProperties smsProperties;

    public SmsCodeGenerator(SmsProperties smsProperties) {
        this.smsProperties = smsProperties;
    }

    /**
     * 生成验证码
     *
     * @param request 请求
     * @return 生成结果
     */
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        return new SmsCode(
                RandomCode.random(smsProperties.getCodeLength(), true),
                smsProperties.getCodeExpireIn());
    }
}
