package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
        print(solution.getServer());
        print(solution.getSubject());
        print(solution.getSubscription());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }

    public List<User> getUsers()    {
        return new AbstractDbSelectExecutor(){

            @Override
            public String getQuery() {
                return null;
            }
        }.execute();
    }

    public List<Location> getLocations()    {
        return new AbstractDbSelectExecutor(){
            @Override
            public String getQuery() {
                return null;
            }
        }.execute();
    }

    public List<Server> getServer()    {
        return new AbstractDbSelectExecutor(){
            @Override
            public String getQuery() {
                return null;
            }
        };
    }

    public List<Subject> getSubject() {
        return new AbstractDbSelectExecutor() {
            @Override
            public String getQuery() {
                return null;
            }
        };
    }

    public List<Subscription> getSubscription() {
        return new AbstractDbSelectExecutor() {
            @Override
            public String getQuery() {
                return null;
            }
        };
    }
}
