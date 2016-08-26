package cmz.alvin.core;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by e诺
 * on 16/8/4
 * Time 下午4:34
 */
public abstract class BaseController {
    private static final Logger log = Logger.getLogger(BaseController.class);

    /**
     * 业务性异常处理
     *
     * @param ex       异常
     * @param request  请求
     * @param response 返回
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handlBusinessException(BusinessException ex, HttpServletRequest request, HttpServletResponse response) {
        log.error(ex.getCode() + ":" + ex.getMessage());
        TotalResult totalResult = new TotalResult();
        totalResult.setMessage(ex.getMessage());
        totalResult.setCode(ex.getCode());
        totalResult.setData(ex.getData());

        return totalResult;
    }
}
