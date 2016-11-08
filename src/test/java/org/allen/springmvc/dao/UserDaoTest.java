package org.allen.springmvc.dao;

import com.github.springtestdbunit.annotation.DatabaseSetup;
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
        long id = userDao.insert(user);
        assertTrue(id > 0);
    }

    @Test
    @DatabaseSetup({"classpath:/dbunit/UserDaoTest.xml"})
    public void testGetById() {
        User user = userDao.getById(100L);
        assertNotNull(user);
        assertEquals(100, user.getId().longValue());
        assertEquals("name_100", user.getName());
    }
}
