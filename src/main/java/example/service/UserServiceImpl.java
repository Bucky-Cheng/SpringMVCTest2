package example.service;

import example.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserInfo userInfo;

    @Override
    public UserInfo getUserById(int UserID) {
        userInfo.setUserID(UserID);
        userInfo.setUserName("Bucky");
        userInfo.setAddress("Hong Kong KLN");
        userInfo.setCashDoller("500");
        userInfo.setTel("98372839");
        userInfo.setCreditMax("15000");
        userInfo.setUserType("Platinum");
        return userInfo;
    }
}
