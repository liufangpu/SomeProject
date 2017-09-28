package nice.liufangpu.project.controller;

import nice.liufangpu.project.entity.DeviceInfo;
import nice.liufangpu.project.entity.User;
import nice.liufangpu.project.service.CommonService;
import nice.liufangpu.project.util.IPUtil;
import nice.liufangpu.project.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liufangpu on 2017-9-28 11:43.
 */
@Controller
@RequestMapping("/appapi")
public class CommonController {
    private static Logger logger=Logger.getLogger(CommonController.class);
    @Autowired
    private  CommonService commonService;
    @RequestMapping("/getcommoninfo.do")
    public void kill(HttpServletResponse response, HttpServletRequest request,String hhid,String  peopleId,String phoneVersion ,String phoneModel){
        StopWatch stopWatch= null;
        String config = null;
        logger.info(String.format("hhid=%s, peopleId=%s, phoneVersion=%s, phoneModel=%s",
                new Object[] { hhid, peopleId, phoneVersion, phoneModel }));
        try {
            stopWatch = new StopWatch();
            stopWatch.start();
            String userIpAddr = IPUtil.getUserIpAddr(request);
            User user=new User();
            user.setIp(userIpAddr);
            user.setHhId(hhid);
            commonService.recordUserInfo(user);
            DeviceInfo deviceInfo=new DeviceInfo();
            deviceInfo.setHhId(hhid);
            deviceInfo.setPeopleId(peopleId);
            deviceInfo.setPhoneModel(phoneModel);
            deviceInfo.setPhoneVersion(phoneVersion);
            int i=commonService.recordDeviceInfo(deviceInfo);
            logger.info("插入成功"+i+"条");
            config = commonService.getConfig();
            stopWatch.stop();
        } catch (Exception e) {
            logger.error("发生错误！！"+e);
            e.printStackTrace();
        }
        logger.info("过程耗时："+stopWatch.getTotalTimeSeconds()+"秒！");
        ResponseUtil.doResponse(response,config);
    }
}
