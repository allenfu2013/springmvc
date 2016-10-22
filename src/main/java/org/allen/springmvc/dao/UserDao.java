package org.allen.springmvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.allen.springmvc.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao {

    public Long insert(User user) {
        return (Long) insert("User.insert", user);
    }

    public User getById(Long userId) {
        Map<String, Object> cond = new HashMap<String, Object>();
        cond.put("userId", userId);
        return queryForObject("User.getById", cond);
    }
}
