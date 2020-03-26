package example.controller;

import example.pojo.UserInfo;
import example.pojo.UserUP;
import example.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    String filepath="";

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

    //to login page
    @RequestMapping("login")
    public String ToLogIn(){
        return "LogIn";
    }

    //get username and userpassword
    @RequestMapping("logined")
    public String LogIn(@RequestParam("userName") String Name, @RequestParam("userPassword")String Password, Model model, HttpSession httpSession){

        UserUP userUP1 =userService.getUserUP(Name,Password);
        model.addAttribute(userUP1);
        httpSession.setAttribute("currentUser", userUP1);
        return "userUPShow";
    }

    //file upload page
    @RequestMapping("fileupload")
    public String ShowUploadPage(HttpSession httpSession){
        if(httpSession.getAttribute("currentUser")==null){
            return  "LogIn";
        }else {
            return "fileUpload";
        }
    }

    @RequestMapping("startupload")
    public String StartUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        if(file.isEmpty()){
            return "fileUpload";
        }else{

            String path=request.getSession().getServletContext().getRealPath("File/");

            filepath=path+file.getOriginalFilename();
            System.out.println(filepath);
            FileUtils.copyInputStreamToFile(file.getInputStream(),new File(path,file.getOriginalFilename()));
            return "success";
        }
    }

    @RequestMapping("downloadfile")
    public ResponseEntity<byte[]> DownloadFile() throws IOException {
        File file = new File(filepath);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }
}
