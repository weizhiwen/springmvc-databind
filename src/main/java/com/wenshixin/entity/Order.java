package com.wenshixin.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzw
 * Date: 2018/9/19
 * Time: 17:43
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Order {
    private String id;
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", user=" + user +
                '}';
    }
}
