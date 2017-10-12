package com.example.pcpv.joupdemo;

/**
 * Created by PCPV on 10/12/2017.
 */

public class MatchTime {
    private String hour;
    private String date;

    public MatchTime(String hour, String date) {
        this.hour = hour;
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public String getDate() {
        return date;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
