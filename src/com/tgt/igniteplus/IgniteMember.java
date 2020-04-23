package com.tgt.igniteplus;
import java.util.List;
import java.util.Set;
public class IgniteMember {
    private String Name;
    private String College;
    private String Department;
    private Set<String> SkillSet;
    private int Age;

    public IgniteMember(String name, String college, String department, Set<String> skillSet, int age) {
        Name = name;
        College = college;
        Department = department;
        SkillSet = skillSet;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public String getCollege() {
        return College;
    }

    public String getDepartment() {
        return Department;
    }

    public Set<String> getSkillSet() {
        return SkillSet;
    }

    public int getAge() {
        return Age;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCollege(String college) {
        College = college;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public void setSkillSet(Set<String> skillSet) {
        SkillSet = skillSet;
    }

    public void setAge(int age) {
        Age = age;
    }
    public IgniteMember() {
    }
    @Override
    public String toString() {
        return "Ignite Members:\n" +
                "Name: '" + Name + '\'' +
                "\tCollege: '" + College + '\'' +
                "\tDepartment: '" + Department + '\'' +
                "\tSkillSet: " + SkillSet +
                "\tAge: " + Age;
    }
}

