package exam.java.exam6.models;

import exam.java.server.Generator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Month {

    private List<Day> days = new ArrayList<>();

    public Month() {
        fillMonth();
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    private void fillMonth() {

        for (int i = 1; i < 31; i++) {

            LocalDateTime dateTime = LocalDateTime.now();

            int dayOfMonth = dateTime.getDayOfMonth();

            Day day = new Day("September", i, i == dayOfMonth);

            if (day.isToday()) {
                Task task = new Task(Generator.makeName(), Generator.makeDescription(), Generator.makePassword(), UUID.randomUUID().toString());
                day.getTasks().add(task);
            }

            days.add(day);
            
        }
    }

}
