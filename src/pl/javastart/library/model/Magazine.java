package pl.javastart.library.model;

import java.util.Objects;

public class Magazine extends Publication{
    private int month;
    private int day;
    private String languange;

    public Magazine(String title, String publisher, String languange,int year, int month, int day) {
        super(title, publisher, year);
        this.languange = languange;
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLanguange() {
        return languange;
    }

    public void setLanguange(String languange) {
        this.languange = languange;
    }

    @Override
    public String toString() {
        return super.toString() + "; " + month + "; " + day + "; " + languange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return month == magazine.month && day == magazine.day && Objects.equals(languange, magazine.languange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), month, day, languange);
    }
}
