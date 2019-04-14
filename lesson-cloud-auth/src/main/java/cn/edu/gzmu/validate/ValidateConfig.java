package cn.edu.gzmu.validate;

import cn.edu.gzmu.validate.sms.SmsCodeSender;
import cn.edu.gzmu.validate.sms.SmsCodeSenderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author echo
 * @version 1.0
 * @date 19-4-14 14:17
 */
@Configuration
public class ValidateConfig {

    @Bean
    public SmsCodeSender smsCodeSender(){
        return new SmsCodeSenderImpl();
    }
}
