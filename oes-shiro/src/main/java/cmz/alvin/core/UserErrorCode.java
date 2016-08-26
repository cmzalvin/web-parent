package cmz.alvin.core;

/**
 * Created by e诺
 * on 16/8/4
 * Time 下午4:12
 */
public enum UserErrorCode implements ErrorCode {
    USER_UNKNOWN_ERROR(10001, "用户不存在"),
    USER_PASSWORD_ERROR(10002, "用户密码错误"),
    USER_AUTHENTICATION_ERROR(10003, "账户认证失败");


    private int code;
    private String message;

    UserErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
