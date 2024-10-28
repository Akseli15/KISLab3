package ru.miit.lab3events;

import ru.miit.lab3events.annotation.RequestCreated;
import ru.miit.lab3events.annotation.TrainFound;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class TrainFinder {
    @Inject @TrainFound
    private Event<Train> trainFoundEvent;

    private List<Train> trainSchedule;

    public TrainFinder() {
        trainSchedule = new ArrayList<>();
        trainSchedule.add(new Train("Москва", "12:00", "2024-11-10"));
        trainSchedule.add(new Train("Санкт-Петербург", "15:30", "2024-12-15"));
        trainSchedule.add(new Train("Новосибирск", "18:45", "2024-11-12"));
        trainSchedule.add(new Train("Казань", "09:20", "2024-11-20"));
        trainSchedule.add(new Train("Владивосток", "22:15", "2024-12-05"));
        trainSchedule.add(new Train("Екатеринбург", "14:40", "2024-11-25"));
    }

    public void onRequestCreated(@Observes @RequestCreated PassengerRequest request) {
        System.out.println("Поиск поезда для заявки: " + request);

        for (Train train : trainSchedule) {
            if (train.matches(request)) {
                System.out.println("Поезд найден: " + train);
                trainFoundEvent.fire(train);
                return;
            }
        }
        System.out.println("Поезд не найден для заявки.");
    }
}
