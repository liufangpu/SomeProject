package nice.liufangpu.project.service.impl;

import nice.liufangpu.project.dao.CommonMapper;
import nice.liufangpu.project.entity.DeviceInfo;
import nice.liufangpu.project.entity.User;
import nice.liufangpu.project.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liufangpu on 2017-9-28 11:46.
 */
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private  CommonMapper commonMapper;
    @Override
    public String getConfig() {
        return commonMapper.getConfig();
    }

    @Override
    public void recordUserInfo(User user) {
        commonMapper.recordUserInfo(user);
    }

    @Override
    public int recordDeviceInfo(DeviceInfo deviceInfo) {
        return commonMapper.recordDeviceInfo(deviceInfo);
    }
}
