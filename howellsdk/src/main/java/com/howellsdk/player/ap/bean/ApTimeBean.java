package com.howellsdk.player.ap.bean;

import org.codehaus.jackson.map.util.ISO8601Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2017/1/11.
 */

public class ApTimeBean {
    short year;
    short month;
    short dayOfWeek;
    short day;
    short hour;
    short minute;
    short second;
    short msecond;

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public short getMonth() {
        return month;
    }

    public void setMonth(short month) {
        this.month = month;
    }

    public short getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(short dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public short getDay() {
        return day;
    }

    public void setDay(short day) {
        this.day = day;
    }

    public short getHour() {
        return hour;
    }

    public void setHour(short hour) {
        this.hour = hour;
    }

    public short getMinute() {
        return minute;
    }

    public void setMinute(short minute) {
        this.minute = minute;
    }

    public short getSecond() {
        return second;
    }

    public void setSecond(short second) {
        this.second = second;
    }

    public short getMsecond() {
        return msecond;
    }

    public void setMsecond(short msecond) {
        this.msecond = msecond;
    }

    public ApTimeBean(short year, short month, short dayOfWeek, short day, short hour, short minute, short second, short msecond) {
        this.year = year;
        this.month = month;
        this.dayOfWeek = dayOfWeek;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.msecond = msecond;
    }

    public ApTimeBean(String isoTime){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ISO8601Utils.parse(isoTime));
        year = (short) calendar.get(Calendar.YEAR);
        month = (short) (calendar.get(Calendar.MONTH)+1);
        dayOfWeek = (short) calendar.get(Calendar.DAY_OF_WEEK);
        hour = (short)calendar.get(Calendar.HOUR_OF_DAY);
        day = (short) calendar.get(Calendar.DAY_OF_MONTH);
        minute = (short) calendar.get(Calendar.MINUTE);
        second = (short) calendar.get(Calendar.SECOND);
        msecond = (short) calendar.get(Calendar.MILLISECOND);
    }

    public ApTimeBean(String time,int timeType){
        Calendar calendar = Calendar.getInstance();
        if (timeType==0){
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                calendar.setTime(df.parse(time));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if(timeType==1){
            calendar.setTime(ISO8601Utils.parse(time));
        }
        year = (short) calendar.get(Calendar.YEAR);
        month = (short) (calendar.get(Calendar.MONTH)+1);
        dayOfWeek = (short) calendar.get(Calendar.DAY_OF_WEEK);
        hour = (short)calendar.get(Calendar.HOUR_OF_DAY);
        day = (short) calendar.get(Calendar.DAY_OF_MONTH);
        minute = (short) calendar.get(Calendar.MINUTE);
        second = (short) calendar.get(Calendar.SECOND);
        msecond = (short) calendar.get(Calendar.MILLISECOND);
        toString();
    }


    public ApTimeBean() {
    }

    @Override
    public String toString() {
        return "ApTimeBean{" +
                "year=" + year +
                ", month=" + month +
                ", dayOfWeek=" + dayOfWeek +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                ", msecond=" + msecond +
                '}';
    }
}
