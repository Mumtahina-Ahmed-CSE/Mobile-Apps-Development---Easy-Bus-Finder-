package com.example.ahsan.easybusfinder;

import com.google.firebase.database.Exclude;

/**
 * Created by AHSAN on 27-Oct-18.
 */

public class Note2 {


    private String Location01,Location02,Location03,Location04,Location05,Location06,Location07,Location08,Location09,Location10,Location11,
            Location12,Location13,Location14,Location15,Location16,Location17,
            description,decumentId;

    private int priority;
    public Note2(){

    }
    public Note2(String Location01,String Location02,String Location03,String Location04,String Location05,String Location06,
                 String Location07,String Location08,String Location09,String Location10,String Location11,String Location12,String Location13,String Location14,
                 String Location15,String Location16,String Location17){

        this.Location01=Location01;
        this.Location01=Location02;
        this.Location01=Location03;
        this.Location01=Location04;
        this.Location01=Location05;
        this.Location01=Location06;
        this.Location01=Location07;
        this.Location01=Location08;
        this.Location01=Location09;
        this.Location01=Location10;
        this.Location01=Location11;
        this.Location01=Location12;
        this.Location01=Location13;
        this.Location01=Location14;
        this.Location01=Location15;
        this.Location01=Location16;
        this.Location01=Location17;

    }

    @Exclude
    public String getDecumentId() {
        return decumentId;
    }

    public void setDecumentId(String decumentId) {
        this.decumentId = decumentId;
    }


    public String getLocation01()
    {
        return Location01;
    }
    public String getLocation02() {
        return Location02;
    }

    public String getLocation03() {
        return Location03;
    }

    public String getLocation04() {
        return Location04;
    }

    public String getLocation05() {
        return Location05;
    }

    public String getLocation06() {
        return Location06;
    }

    public String getLocation07() {
        return Location07;
    }

    public String getLocation08() {
        return Location08;
    }

    public String getLocation09() {
        return Location09;
    }

    public String getLocation10() {
        return Location10;
    }

    public String getLocation11() {
        return Location11;
    }

    public String getLocation12() {
        return Location12;
    }

    public String getLocation13() {
        return Location13;
    }

    public String getLocation14() {
        return Location14;
    }

    public String getLocation15() {
        return Location15;
    }

    public String getLocation16() {
        return Location16;
    }

    public String getLocation17() {
        return Location17;
    }
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
