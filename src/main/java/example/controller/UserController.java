package example.controller;

import example.pojo.UserInfo;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/view",method = RequestMethod.GET )
    public String ViewUser(@RequestParam("UserID") int UserID, Model model){

        UserInfo userInfo=userService.getUserById(UserID);
        model.addAttribute(userInfo);
        return "userview";
    }

}
