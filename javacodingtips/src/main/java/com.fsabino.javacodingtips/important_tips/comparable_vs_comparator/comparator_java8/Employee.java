package com.fsabino.javacodingtips.important_tips.comparable_vs_comparator.comparator_java8;

public class Employee implements Comparable<Employee> {

    String name;
    int age;
    double salary;
    long mobile;

    public Employee(String name, int age, double salary, long mobile) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.mobile = mobile;
    }

    public Employee() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public long getMobile() {
        return mobile;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.name.compareTo(employee.getName());
    }
}