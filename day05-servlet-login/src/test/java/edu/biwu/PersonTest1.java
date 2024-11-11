package edu.biwu;

import org.junit.Test;

public class PersonTest1 {
    @Test
    public void test01(){
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        System.out.println(person.getName() + "  " + person.getAge());
    }

}