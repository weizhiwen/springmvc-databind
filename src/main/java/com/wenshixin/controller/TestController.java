package com.wenshixin.controller;

import com.wenshixin.entity.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: wzw
 * Date: 2018/9/19
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
public class TestController {
    /**
     * 基本数据类型
     */
    // http://localhost:8080/springmvc/basetype1.do?id=1
    // http://localhost:8080/springmvc/basetype1.do?id= 不带参数报错
    @RequestMapping(value = "basetype1.do")
    @ResponseBody
    public String baseType1(int id) {
        return "id=" + id;
    }

    // http://localhost:8080/springmvc/basetype2.do?id=1
    // http://localhost:8080/springmvc/basetype2.do?id= 不带参数不报错，参数默认为null
    @RequestMapping(value = "basetype2.do")
    @ResponseBody
    public String baseType2(Integer id) {
        return "id=" + id;
    }
    // http://localhost:8080/springmvc/basetype3.do?name='汤姆'
    // http://localhost:8080/springmvc/basetype3.do?name='tom'
    // 解决方法返回值中文乱码，方法一，只对单个方法有效
    // @RequestMapping(value = "basetype3.do", produces = "application/json; charset=utf-8")
    @RequestMapping(value = "basetype3.do")
    @ResponseBody
    public String baseType3(String name) {
        System.out.println(name);
        return "name=" + name;
    }

    // http://localhost:8080/springmvc/basetype4.do?xid=1
    @RequestMapping(value = "basetype4.do")
    @ResponseBody
    public String baseType4(@RequestParam(value = "xid") Integer id) {
        return "id=" + id;
    }

    /**
     * 对象数据类型
     */
    // http://localhost:8080/springmvc/objecttype1.do?name='tom'&age=1
    // http://localhost:8080/springmvc/objecttype1.do?name='tom'&age=
    @RequestMapping(value = "objecttype1.do")
    @ResponseBody
    public String objecttype1(User user) {
        return "user=" + user;
    }

    // http://localhost:8080/springmvc/objecttype2.do?id='123'&user.name='tom'&user.age=1
    // http://localhost:8080/springmvc/objecttype2.do?id='123'&user.name='tom'&user.age=
    // http://localhost:8080/springmvc/objecttype2.do?id='123'
    @RequestMapping(value = "objecttype2.do")
    @ResponseBody
    public String objecttype2(Order order) {
        return "order=" + order;
    }

    // http://localhost:8080/springmvc/objecttype3.do?people.name=Tom&user.name=Lucy
    // http://localhost:8080/springmvc/objecttype3.do?people.name=Tom
    // http://localhost:8080/springmvc/objecttype3.do?name=Tom
    @RequestMapping(value = "objecttype3.do")
    @ResponseBody
    public String objecttype3(People people, User user) {
        return "people=" + people + ",user=" + user;
    }

    @InitBinder("people")
    public void initPeople(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("people.");
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    /**
     * 日期格式
     */
    // http://localhost:8080/springmvc/datetype1.do?date=2018-09-19
    @RequestMapping(value = "datetype1.do")
    @ResponseBody
    public String datetype1(Date date1) {
        return date1.toString();
    }
    @InitBinder("date1")
    public void initDate(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    // http://localhost:8080/springmvc/datetype2.do?date2=2018-09-10 22:50:10
    @RequestMapping(value = "datetype2.do")
    @ResponseBody
    public String datetype2(Date date2) {
        return date2.toString();
    }

    /**
     * 复杂类型
     */
    // http://localhost:8080/springmvc/complextype1.do?ids=1&ids=2
    @RequestMapping(value = "complextype1.do")
    @ResponseBody
    public String objecttype1(String[] ids) {
        System.out.println(ids.length);
        StringBuilder stringBuilder = new StringBuilder();
        for(String id : ids) {
            stringBuilder.append(id + " ");
        }
        return stringBuilder.toString();
    }

    // http://localhost:8080/springmvc/complextype2.do?users%5B0%5D.name=Tom&users%5B1%5D.name=Lucy 注意特殊字符[]的转义，不然会报错
    // http://localhost:8080/springmvc/complextype2.do?users%5B0%5D.name=Tom&users%5B1%5D.name=Lucy&users%5B6%5D.name=Mary 注意特殊字符[]的转义，不然会报错
    @RequestMapping(value = "complextype2.do")
    @ResponseBody
    public String objecttype2(UserList userList) {
        return userList.toString();
    }

    // http://localhost:8080/springmvc/complextype2.do?users%5B0%5D.name=Tom&users%5B1%5D.name=Lucy&users%5B2%5D.name=Mary 注意特殊字符[]的转义，不然会报错
    @RequestMapping(value = "complextype3.do")
    @ResponseBody
    public String objecttype3(UserSet userSet) {
        System.out.println(userSet.getUsers().size());
        return userSet.toString();
    }

    // http://localhost:8080/springmvc/complextype4.do?users%5B%270%27%5D.name=Tom&users%5B%271%27%5D.name=Lucy&users%5B%272%27%5D.name=Mary
    @RequestMapping(value = "complextype4.do")
    @ResponseBody
    public String objecttype4(UserMap userMap) {
        System.out.println(userMap.getUsers().size());
        return userMap.toString();
    }

    /**
     * json 数据格式
     */

    /*{
        "name":"Tom",
            "age":1
    }*/
    @RequestMapping(value = "jsontype.do")
    @ResponseBody
    public User jsontype(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    /**
     * xml 数据格式
     */
    /*<?xml version="1.0" encoding="UTF-8" ?>
    <user>
        <name>Jim</name>
        <age>16</age>
    </user>*/
    @RequestMapping(value = "xmltype.do")
    @ResponseBody
    public User xmltype(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    /**
     * restful 风格
     */

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String findUserByGET(@PathVariable("name") String name) {
        return "GET name=" + name;
    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.POST)
    @ResponseBody
    public String findUserByPOST(@PathVariable("name") String name) {
        return "POST name=" + name;
    }
}
