package nice.liufangpu.project.dao;

import nice.liufangpu.project.entity.DeviceInfo;
import nice.liufangpu.project.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by liufangpu on 2017-9-28 11:47.
 */
@Repository
public interface CommonMapper {
    String getConfig();

    void recordUserInfo(User user);

    int recordDeviceInfo(DeviceInfo deviceInfo);
}
