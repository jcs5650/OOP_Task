package main.time;

import main.menu.Selling;

import java.time.LocalTime;

public class TimePolicyBasic implements TimePolicy {
    private static TimePolicyBasic timePolicyBasic = new TimePolicyBasic();

    private TimePolicyBasic() {}

    public static TimePolicyBasic getInstance() {
        return timePolicyBasic;
    }

    @Override
    public Selling calculateSellingTime(LocalTime time) {
        int hour = time.getHour();

        if (6 < hour && hour < 11) {
            return Selling.MORNING;
        } else if (11 <= hour && hour < 17) {
            return Selling.LUNCH;
        } else {
            return Selling.DINNER;
        }
    }
}