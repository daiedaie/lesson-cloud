package cn.edu.gzmu.constant;

/**
 * @author echo
 * @version 1.0
 * @date 19-4-14 16:17
 */
public interface SecurityConstants {

    /**
     * 理验证码的 url 前缀
     */
    String VALIDATE_CODE_URL_PREFIX = "/code";
    /**
     * 手机验证码登录请求 url
     */
    String LOGIN_PROCESSING_URL_SMS = "/oauth/sms";
    /**
     * 需要验证短信验证码的注册请求 url
     */
    String REGISTER_PROCESSING_URL_EMAIL = "/auth/register";
    /**
     * 发送短信验证码或验证短信验证码时，手机的参数名称
     */
    String PARAMETER_SMS = "sms";
    /**
     * 发送邮箱验证码或验证短信验证码时，邮箱的参数名称
     */
    String PARAMETER_EMAIL = "email";

    String PUBLIC_KEY = "";
}
