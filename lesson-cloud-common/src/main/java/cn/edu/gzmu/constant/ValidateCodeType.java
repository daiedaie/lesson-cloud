package cn.edu.gzmu.constant;

/**
 * @author echo
 * @version 1.0
 * @date 19-4-14 16:23
 */
public enum  ValidateCodeType {
    /**
     * 短信验证码
     */
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.PARAMETER_SMS;
        }
    },
    EMAIL {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.PARAMETER_EMAIL;
        }
    };
    public abstract String getParamNameOnValidate();
}
