package com.wenshixin.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzw
 * Date: 2018/9/19
 * Time: 17:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class People {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
