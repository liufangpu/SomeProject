package nice.liufangpu.project.service.impl;

import nice.liufangpu.project.dao.CommonMapper;
import nice.liufangpu.project.dao.UserMapper;
import nice.liufangpu.project.entity.User;
import nice.liufangpu.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liufangpu on 2017-9-19 16:26.
 */
@Service
public class UserServiceImpl implements UserService{
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
        if ( "1".equals(config) ){
            userMapper.updateConfig("fuck");
        }else {
            userMapper.updateConfig("1");
        }

    }
}
