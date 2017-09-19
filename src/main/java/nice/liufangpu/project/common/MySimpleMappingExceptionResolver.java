package nice.liufangpu.project.common;

import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MySimpleMappingExceptionResolver extends  SimpleMappingExceptionResolver {
	@SuppressWarnings("unchecked")
	protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object arg2, Exception ex) {
          
        System.out.println("resolver ...");
          
        String viewName = determineViewName(ex, request);
        System.out.println("viewname:"+viewName);
        if (viewName != null) {// JSP格式返回  
        		System.out.println("非异步请求");
            if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request  
                    .getHeader("X-Requested-With") != null && request  
                    .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {  
                // 如果不是异步请求  
                // Apply HTTP status code for error views, if specified.  
                // Only apply it if we're processing a top-level request.  
                Integer statusCode = determineStatusCode(request, viewName);
                System.out.println("statusCode:"+statusCode);
                if (statusCode != null) {  
                    applyStatusCodeIfPossible(request, response, statusCode);  
                }  
                return getModelAndView(viewName, ex, request);  
            } else {// JSON格式返回  
            	System.out.println("异步请求");
                try {  
                    PrintWriter writer = response.getWriter();
                    Map map=new HashMap();
                    map.put("success", false);  
                    map.put("msg", ex.getMessage());  
                    writer.write(JSON.toJSONString(map));
                    writer.flush();  
                } catch (IOException e) {
                    e.printStackTrace();  
                }  
                return null;  
  
            }  
        } else {  
            return null;  
        }  
    }  
  
}
