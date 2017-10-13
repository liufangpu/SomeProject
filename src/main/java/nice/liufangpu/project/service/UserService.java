package nice.liufangpu.project.service;

import nice.liufangpu.project.entity.DeviceInfo;
import nice.liufangpu.project.entity.User;

import java.util.List;

/**
 * Created by liufangpu on 2017-9-19 16:26.
 */
public interface UserService {
    int saveUser(User user);

    void updateConfig();

    List<User> getUserList();

    List<DeviceInfo> getDeviceList();
}
