package nice.liufangpu.project.dao;

import nice.liufangpu.project.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by liufangpu on 2017-9-19 16:26.
 */
@Repository
public interface UserMapper {


    int saveUser(User user);
}
