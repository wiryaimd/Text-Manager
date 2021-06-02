package com.wiryaimd.textmanager.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Test;

import java.util.List;
import java.util.Scanner;

/**
 * Dependency Injection contoh...
 */
public class MyDiTest{

    private MyServices services;

    @Test
    public void test(){

        anjeng(services);

    }

    /**
     * dependency injection terletak pada paramater nya
     * berbeda jika kita membuat MyServices di dalam method yang akan berulang kali digunakan
     */
    public void anjeng(MyServices myServices){
        int id = 123;
        String name = "hehe boi";

        myServices.send(id, name);

        // contoh yang bukan dependecny injection
        // membuat new interface didalam method, yang membuat objek berulang kali jika dipanggil
//        services = new MyServices() {
//            @Override
//            public void send(int id, String name) {
//                // code
//            }
//        };
//        services.send(id, name);
    }
}
