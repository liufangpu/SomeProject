package nice.liufangpu.project.service.impl;

import nice.liufangpu.project.dao.CommonMapper;
import nice.liufangpu.project.dao.UserMapper;
import nice.liufangpu.project.entity.DeviceInfo;
import nice.liufangpu.project.entity.User;
import nice.liufangpu.project.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liufangpu on 2017-9-19 16:26.
 */
@Service
public class UserServiceImpl implements UserService{
    private static Logger logger=Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommonMapper commonMapper;
    @Override
    public int saveUser(User user) {

        return userMapper.saveUser(user);
    }

    @Override
    public void updateConfig() {
        String config = commonMapper.getConfig();
        if(StringUtils.isNotBlank(config)){
            if ( "1".equals(config) ){
                userMapper.updateConfig("fuck");
            }else {
                userMapper.updateConfig("1");
            }
        }else {
            int i=userMapper.insertConfig("1");
            logger.info("初始化config，默认开启......"+i);
        }

    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public List<DeviceInfo> getDeviceList() {
        return userMapper.getDeviceList();
    }
}
