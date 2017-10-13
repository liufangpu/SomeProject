package nice.liufangpu.project.dao;

import nice.liufangpu.project.entity.DeviceInfo;
import nice.liufangpu.project.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liufangpu on 2017-9-19 16:26.
 */
@Repository
public interface UserMapper {


    int saveUser(User user);

    void updateConfig(String value);

    int insertConfig(String name);

    List<User> getUserList();

    List<DeviceInfo> getDeviceList();
}
