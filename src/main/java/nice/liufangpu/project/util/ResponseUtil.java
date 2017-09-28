package nice.liufangpu.project.util;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtil {
    
    private static Logger logger = Logger.getLogger(ResponseUtil.class);
    
    public static void doResponse(HttpServletResponse response, String format, Object o) {
        String result = null;
        if (format != null && format.toLowerCase().equals("json")) {
            response.setContentType("text/json;charset=utf-8");
            result = JSON.toJSONString(o);
        } else {
            response.setContentType("text/plain;charset=utf-8");
            result = (String) o;
        }

        response.setCharacterEncoding("utf-8");

        try {
            PrintWriter out = response.getWriter();
            //logger.info("result msg : " + result);
            out.print(result);
            out.flush();
            out.close();
        } catch (IOException e) {
            logger.error(e);
            e.printStackTrace();
        }
    }
    /**
     * 
    * @Description:给页面传递json字符串 
    * @author liufangpu
     */
    public static void doResponse(HttpServletResponse response, Object o) {
        response.setCharacterEncoding("utf-8");

        try {
            PrintWriter out = response.getWriter();
            logger.info("result msg : " + o);
            out.print(o);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
