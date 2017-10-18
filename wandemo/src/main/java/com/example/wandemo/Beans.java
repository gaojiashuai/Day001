package com.example.wandemo;

/**
 * Created by 你瞅啥 on 2017/9/22.
 */
public class Beans {
    private int bitmap;
    private String name;
    private String sex;
    private int age;

    public Beans(int bitmap, String name, String sex, int age) {
        this.bitmap = bitmap;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public int getBitmap() {
        return bitmap;
    }

    public void setBitmap(int bitmap) {
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
