package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class ModelData {
    private List<User> users;
    private UserService userService = new UserServiceImpl();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
    }
}
