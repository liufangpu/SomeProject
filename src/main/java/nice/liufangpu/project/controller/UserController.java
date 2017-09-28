package nice.liufangpu.project.controller;

import nice.liufangpu.project.entity.User;
import nice.liufangpu.project.service.CommonService;
import nice.liufangpu.project.service.UserService;
import nice.liufangpu.project.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liufangpu on 2017-9-19 16:25.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger=Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private CommonService commonService;
    @RequestMapping("/saveInfo")

    public String saveInfo(HttpServletRequest request, User user){
       int i= userService.saveUser(user);
       logger.info("保存结果"+i);
        return "success";
    }

    @RequestMapping("/doswitch")
    public String doswitch(String type,String username,String password){
        if ( "xtlfp".equals(username) &&"1234".equals(password)){
            if ( "isclick".equals(type) ){
                userService.updateConfig();
                return "success";
            }
        }
       return "/error/500";

    }
    @RequestMapping("/getConfig")
    public void  getConfig(HttpServletResponse response){
        String result;
        String config = commonService.getConfig();
        if ( "1".equals(config) ){
            result="开启";
        }else {
            result="关闭";
        }
        ResponseUtil.doResponse(response,result);
    }
}
