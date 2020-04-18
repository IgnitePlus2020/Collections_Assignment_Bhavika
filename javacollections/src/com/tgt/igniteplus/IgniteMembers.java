package com.tgt.igniteplus;
import java.util.*;
public class IgniteMembers {
    private String name;
    private int age;
    private String college;
    private Set<String> skillSet;

    public IgniteMembers(String name, int age, String college, Set<String> skillSet) {
        this.name = name;
        this.age = age;
        this.college = college;
        this.skillSet = skillSet;
    }
    public IgniteMembers(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Set<String> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<String> skillSet) {
        this.skillSet = skillSet;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", college='" + college + '\'' +
                ", skillSet=" + skillSet ;
    }
}

