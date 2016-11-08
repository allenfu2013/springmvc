package org.allen.springmvc.dao;

import org.allen.springmvc.SpringBaseTest;
import org.allen.springmvc.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserDaoTest extends SpringBaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("test");
        user.setSex("Male");
        long id = userDao.insert(user);
        assertTrue(id > 0);
    }

    @Test
    public void testGetById() {

    }
}
