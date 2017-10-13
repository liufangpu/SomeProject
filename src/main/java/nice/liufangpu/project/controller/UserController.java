package nice.liufangpu.project.controller;

import nice.liufangpu.project.entity.DeviceInfo;
import nice.liufangpu.project.entity.User;
import nice.liufangpu.project.service.CommonService;
import nice.liufangpu.project.service.UserService;
import nice.liufangpu.project.util.IPUtil;
import nice.liufangpu.project.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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
    public void doswitch(String type,String username,String password,HttpServletRequest request,HttpServletResponse response){

        String result="切换失败！";

        try {
            userService.updateConfig();
            result="切换成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
      ResponseUtil.doResponse(response,result);
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
    @RequestMapping("/login")
    public String login(String username, String password, Map map,HttpServletRequest request){
        String userIpAddr = IPUtil.getUserIpAddr(request);
        logger.info("登录参数：,username="+username+",password="+password+",ip="+userIpAddr);
        if ( "xtlfp".equals(username) &&"1234".equals(password)){
            List<User> userList=userService.getUserList();
            List<DeviceInfo> deviceInfoList=userService.getDeviceList();
            map.put("userinfo",userList);
            map.put("deviceinfo",deviceInfoList);
            return "userinfo";
        }
        return "/error/500";

    }
}
