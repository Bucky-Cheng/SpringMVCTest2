package example.service;

import example.pojo.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserInfo getUserById(int UserID);
}
