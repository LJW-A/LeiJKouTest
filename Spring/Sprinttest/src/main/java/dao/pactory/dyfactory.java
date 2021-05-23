package dao.pactory;

import dao.UserDao;
import dao.dome.Userdaotyest;

import java.util.List;
import java.util.Map;

public class dyfactory {

    private List<String> list;
    private Map<Object,Object> map;


    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  UserDao getuserdao(){
        return new Userdaotyest();
    }

    public void setUserSaverr(String s) {

    }

    public Object save1(){
        return name+"======"+age;
        //System.out.println();


    }

}
