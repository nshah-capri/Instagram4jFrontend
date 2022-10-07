package com.instagram4jautomation.dao;

import com.capri.Operations.InstagramEncapsulation;
import com.capri.nshah.Instagram;
import com.capri.nshah.exceptions.IGLoginException;
import com.instagram4jautomation.bean.UserBean;
import com.xcoder.tasks.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
@RestController
public class UserDao {
    @Autowired
    UserBean userBean;

    public boolean validateUser(UserBean user) throws IGLoginException {
        File dir = new File(System.getProperty("user.dir") + "//Cache" + File.separator + user.getUsername());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Instagram instagram = Instagram.loginOrCache(dir, user.getUsername(), user.getPassword());
        user.setClient(instagram.getClient());
        user.setInstagram(instagram);
        System.out.println("Logged in as " + instagram.username);
        return instagram.getClient().isLoggedIn();
    }

    public int getFollowersCount(UserBean user) throws Exception {
        AsyncTask<Integer> followers = userBean.getInstagram().profile().getFollowersCount(user.getUsername());
        return followers.getResult(60);
    }
}
