package com.instagram4jautomation.controller;

import com.capri.nshah.exceptions.IGLoginException;
import com.instagram4jautomation.bean.UserBean;
import com.instagram4jautomation.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserDao userDao;
    @Autowired
    private UserBean userBean;
    @GetMapping("/")
    public String index() throws IGLoginException {
//        if(userDao.validateUser(new UserBean())) {
//            return "redirect:/home";
//        }
//        else {
            return "login";
//        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/saveuser")
    public String login(UserBean userBean) throws IGLoginException {
        if (userDao.validateUser(userBean)) {
            return "home";
        } else {
            return "login";
        }
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @PostMapping("/userinfo")
    public String userinfo(Model model) throws Exception {
        System.out.println(userBean.getUsername());
        model.addAttribute("followersCount", userDao.getFollowersCount(userBean));
        model.addAttribute("username", userBean.getUser());
        return "followers";
    }

    /*@GetMapping("/followers")
    public String followers(Model model) {

        model.addAttribute("followers", userDao);
        return "followers";
    }*/

}
