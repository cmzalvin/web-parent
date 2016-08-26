package cmz.alvin.core;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by 尹前坤 on 2015/6/16.
 */
@Component
public class TotalResult implements Serializable {

    private int code = 20000;  //状态码
    private String message="success";//消息
    private Object data;//服务数据
    public TotalResult(){

    }
    public TotalResult(Object data){
        this.data = data;
    }
    public static TotalResult newIntance(){
        return new TotalResult();
    }
    public static TotalResult newIntance(Object data){
        return new TotalResult(data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}