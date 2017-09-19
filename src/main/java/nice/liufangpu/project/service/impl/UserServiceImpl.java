package nice.liufangpu.project.service.impl;

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
    @Override
    public int saveUser(User user) {

        return userMapper.saveUser(user);
    }
}
