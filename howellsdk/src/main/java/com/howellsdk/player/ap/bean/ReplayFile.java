package com.howellsdk.player.ap.bean;

/**
 * Created by Administrator on 2017/1/17.
 */

public class ReplayFile {
    public short begYear;
    public short begMonth;
    public short begDay;
    public short begHour;
    public short begMin;
    public short begSec;
    public short endYear;
    public short endMonth;
    public short endDay;
    public short endHour;
    public short endMin;
    public short endSec;

    public ReplayFile(short begYear, short begMonth, short begDay,
                      short begHour, short begMin, short begSec,
                      short endYear, short endMonth, short endDay,
                      short endHour, short endMin, short endSec) {
        this.begYear = begYear;
        this.begMonth = begMonth;
        this.begDay = begDay;
        this.begHour = begHour;
        this.begMin = begMin;
        this.begSec = begSec;
        this.endYear = endYear;
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.endHour = endHour;
        this.endMin = endMin;
        this.endSec = endSec;
    }

    @Override
    public String toString() {
        return "ReplayFile{" +
                "begYear=" + begYear +
                ", begMonth=" + begMonth +
                ", begDay=" + begDay +
                ", begHour=" + begHour +
                ", begMin=" + begMin +
                ", begSec=" + begSec +
                ", endYear=" + endYear +
                ", endMonth=" + endMonth +
                ", endDay=" + endDay +
                ", endHour=" + endHour +
                ", endMin=" + endMin +
                ", endSec=" + endSec +
                '}';
    }

    public ReplayFile() {
    }

    public short getBegYear() {
        return begYear;
    }

    public void setBegYear(short begYear) {
        this.begYear = begYear;
    }

    public short getBegMonth() {
        return begMonth;
    }

    public void setBegMonth(short begMonth) {
        this.begMonth = begMonth;
    }

    public short getBegDay() {
        return begDay;
    }

    public void setBegDay(short begDay) {
        this.begDay = begDay;
    }

    public short getBegHour() {
        return begHour;
    }

    public void setBegHour(short begHour) {
        this.begHour = begHour;
    }

    public short getBegMin() {
        return begMin;
    }

    public void setBegMin(short begMin) {
        this.begMin = begMin;
    }

    public short getBegSec() {
        return begSec;
    }

    public void setBegSec(short begSec) {
        this.begSec = begSec;
    }

    public short getEndYear() {
        return endYear;
    }

    public void setEndYear(short endYear) {
        this.endYear = endYear;
    }

    public short getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(short endMonth) {
        this.endMonth = endMonth;
    }

    public short getEndDay() {
        return endDay;
    }

    public void setEndDay(short endDay) {
        this.endDay = endDay;
    }

    public short getEndHour() {
        return endHour;
    }

    public void setEndHour(short endHour) {
        this.endHour = endHour;
    }

    public short getEndMin() {
        return endMin;
    }

    public void setEndMin(short endMin) {
        this.endMin = endMin;
    }

    public short getEndSec() {
        return endSec;
    }

    public void setEndSec(short endSec) {
        this.endSec = endSec;
    }
}
