package example.controller;

import example.pojo.UserInfo;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    //Function 1
    @RequestMapping(value = "/view",method = RequestMethod.GET )
    public String ViewUser(@RequestParam("UserID") int UserID, Model model){

        UserInfo userInfo=userService.getUserById(UserID);
        model.addAttribute(userInfo);
        return "userview";
    }

    //Function 2
    @RequestMapping(value = "/view2/{UserID}",method = RequestMethod.GET )
    public String ViewUser2(@PathVariable("UserID") int UserID, Map<String,Object> model){
        UserInfo userInfo=userService.getUserById(UserID);
        model.put("userInfo",userInfo);
        return "userview";
    }

    //Function 3
    @RequestMapping("view3")
    public String ViewUser3(HttpServletRequest request){
        int UserID=Integer.parseInt(request.getParameter("UserID"));
        UserInfo userInfo=userService.getUserById(UserID);
        request.setAttribute("userInfo",userInfo);
        return "userview";
    }
}
