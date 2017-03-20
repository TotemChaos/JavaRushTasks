package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.LinkedList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = new LinkedList<User>();
        users.add(new User("name1", 01, 1));
        users.add(new User("name2", 02, 1));
        modelData.setUsers(users);
    }

    @Override
    public void onShowAllDeletedUsers(){
        modelData.loadDeletedUsers();
    }
}
