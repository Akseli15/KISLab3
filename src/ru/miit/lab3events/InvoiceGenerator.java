package ru.miit.lab3events;

import ru.miit.lab3events.annotation.TrainFound;

import javax.enterprise.event.Observes;

public class InvoiceGenerator {
    public void onTrainFound(@Observes @TrainFound Train train) {
        System.out.println("Создание счёта на оплату для выбранного поезда: " + train);
    }
}
