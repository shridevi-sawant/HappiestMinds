package com.happiestminds.kotlinprogramming.demo;

import static com.happiestminds.kotlinprogramming.demo.JavaInteropKt.multiply;

public class Customer {
    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void is(){
        System.out.println("Name: "+ name);
        System.out.println(multiply(10, 20));
    }
}
