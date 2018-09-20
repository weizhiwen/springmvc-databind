package com.wenshixin.entity;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wzw
 * Date: 2018/9/19
 * Time: 19:58
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UserMap {
    private Map<String, User> users;

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserMap{" +
                "users=" + users +
                '}';
    }
}
