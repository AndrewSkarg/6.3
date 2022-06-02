package com.exam;

import java.time.Duration;
import java.time.LocalTime;

public class Event {
    private LocalTime start;
    private LocalTime finish;
    private String title;
    private double price;

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    public double getPrice() {
        return price;
    }




    public Duration getDuration(){
        return  Duration.between(start,finish);
    }

    public Event of(LocalTime start,LocalTime finish,String title,double price){
        this.start=start;
        this.finish=finish;
        this.title=title;
        this.price=price;
        return this;
    }

    @Override
    public String toString() {
       return String.format("Event -- band <** %-14s **> price %.2f , start - %2d : %2d , finish - %2d : %2d ,duration: %2d min ***",
                title,price,start.getHour(),start.getMinute(),finish.getHour(),finish.getMinute(),getDuration().toMinutesPart());
    }
}
