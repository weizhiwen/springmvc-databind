package com.wenshixin.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: wzw
 * Date: 2018/9/19
 * Time: 19:51
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UserSet {
    private Set<User> users = new HashSet<>();

    public UserSet() {
        // 固定set集合的大小为3
        users.add(new User());
        users.add(new User());
        users.add(new User());
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserSet{" +
                "users=" + users +
                '}';
    }
}
