package nice.liufangpu.project.service;

import nice.liufangpu.project.entity.DeviceInfo;
import nice.liufangpu.project.entity.User; /**
 * Created by liufangpu on 2017-9-28 11:45.
 */
public interface CommonService {
    String getConfig();

    void recordUserInfo(User user);

    int recordDeviceInfo(DeviceInfo deviceInfo);
}
