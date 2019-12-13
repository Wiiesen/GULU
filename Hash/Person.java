import java.util.ArrayList;

import java.util.HashMap;

import java.util.Objects;



public class Person {

    public static void main(String[] args) {

        Man p1=new Man("zms",'m',2019214118);

        Man p2=new Man("zm",'f',20011005);

        ArrayList list=new ArrayList();

        ArrayList<String> ManList = new ArrayList<String>();

        ManList.add("曾茂森");

        ManList.add("周密");

        list.add(p1);

        list.add(p2);

        System.out.println(list);

        System.out.println(ManList);
    }
}

class Man {

    private static String name;

    private char sex;

    private int id;

    public Man(String name, char sex, int id) {

        this.name = name;

        this.sex = sex;

        this.id = id;

    }

    public void setname_setsex_setid(String name, char sex, int id) {

        this.name = name;

        this.sex = sex;

        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getId() {
        return id;
    }

    public boolean equals(Object obj) {

        if (obj instanceof Person) {

            Person person = (Person) obj;

            return name.equalsIgnoreCase(Man.getName());

        }

        return false;

    }

    public int hashCode() {
        return Objects.hash(getId(), getName(), getSex());
    }
}




