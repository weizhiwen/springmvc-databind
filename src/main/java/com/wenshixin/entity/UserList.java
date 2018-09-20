package com.wenshixin.entity;

import com.wenshixin.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzw
 * Date: 2018/9/19
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UserList {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "users=" + users +
                '}';
    }
}
