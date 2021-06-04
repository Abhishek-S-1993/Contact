package com.example.saddays;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application
{
    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<Person>();
        people.add(new Person("Sonu","9620845431"));
        people.add(new Person("Bujiima","9035521339"));
        people.add(new Person("chiini","9035521339"));
    }
}
