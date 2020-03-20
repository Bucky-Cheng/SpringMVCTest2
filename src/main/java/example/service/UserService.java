package example.service;

import example.pojo.UserInfo;
import example.pojo.UserUP;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserInfo getUserById(int UserID);
    public UserUP getUserUP(String userName, String userPassword);
}
