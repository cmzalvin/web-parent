package cmz.alvin.core;

import java.io.Serializable;

/**
 * Created by e诺
 * on 16/8/4
 * Time 下午4:23
 */
public class BusinessException extends RuntimeException implements Serializable {
    private int code;
    private String message;
    private Object data;

    public BusinessException(){

    }
    public BusinessException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
    public BusinessException(ErrorCode errorCode,Object object){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.data = object;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
