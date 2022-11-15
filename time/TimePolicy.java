package main.time;

import main.menu.Selling;

import java.time.LocalTime;

public interface TimePolicy {
    Selling calculateSellingTime(LocalTime time);
}
