package org.allen.springmvc.controller;

import org.allen.springmvc.dao.UserDao;
import org.allen.springmvc.entity.User;
import org.allen.springmvc.utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public User add(@RequestParam("id") Long id, @RequestParam("name") String name) {
        Logger.info(this, String.format("[/user/add] id:%s, name:%s", id, name));
        User user = new User();
        user.setId(id);
        user.setName(name);
        userDao.insert(user);
        return user;
    }

    @RequestMapping(value = "get-by-id", method = RequestMethod.GET)
    @ResponseBody
    public User getById(@RequestParam("userId") Long userId) {
        Logger.info(this, String.format("[/user/get-by-id], userId: %s", userId));
        User user = userDao.getById(userId);
        return user;
    }

}
