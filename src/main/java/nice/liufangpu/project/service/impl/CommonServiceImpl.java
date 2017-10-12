package nice.liufangpu.project.service.impl;

import nice.liufangpu.project.dao.CommonMapper;
import nice.liufangpu.project.entity.DeviceInfo;
import nice.liufangpu.project.entity.User;
import nice.liufangpu.project.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void recordUserInfo(User user) {
       User getUser =commonMapper.getUserInfo(user);
       if ( getUser==null){
           commonMapper.recordUserInfo(user);
       }else {
           user.setAccessTimes(getUser.getAccessTimes()+1);
           commonMapper.updateUserInfo(user);
       }

    }

    @Override
    @Transactional
    public int recordDeviceInfo(DeviceInfo deviceInfo) {
        DeviceInfo getDeviceInfo=commonMapper.getDeviceInfo(deviceInfo);
        int i=0;
        if ( getDeviceInfo==null ){
            i=commonMapper.recordDeviceInfo(deviceInfo);
        }
        return i;
    }
}
