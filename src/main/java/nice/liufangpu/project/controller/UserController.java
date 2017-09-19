package nice.liufangpu.project.controller;

import nice.liufangpu.project.entity.User;
import nice.liufangpu.project.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liufangpu on 2017-9-19 16:25.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger=Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/saveInfo")

    public String saveInfo(HttpServletRequest request, User user){
       int i= userService.saveUser(user);
       logger.info("保存结果"+i);
        return "success";
    }
}
