package com.train.railway_train_create;
import com.train.work_with_data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    /*
    Данный класс занимается генерированием состава на основе полученных от пользователя данных,
    происходит сортировка вагонов, вычисляется вся итоговая информация о поезде в целом
    Генерируем состав с учётом пользовательских ответов и железнодорожных правил
    Правила:
    1. Число вагонов не больше 25 (обычно используется 15, но если много людей, то 20)
    2. 1-2 сидячих вагона
    3. Если дальше 700 км, то используем спальные вагоны, не используем сидячие (минимум половина плацкарт)
    4. Если меньше 700 км, но больше 200 км, то используем все кроме спальных (минимум половина плацкарт)
    5. Если меньше 200 км, то используем только сидячие
    */

public class CreateRailwayTrain {

    public static int amountOfSecondClassCarriage;
    public static int amountOfCompartmentCar;
    public static int amountOfDayCoachCar;
    public static int amountOfSleepingCar;

    public static List<Object> railwayTrain = new ArrayList<>();
    public static List<Object> railwayTrainSortedByComfort = new ArrayList<>();

    public static void main() {

        Scanner scanner = new Scanner(System.in);

        DataRequestAndProcessing.main();

        int amountOfPassengersOfAllSecondClassCarriage;
        int amountOfPassengersOfAllCompartmentCar;
        int amountOfPassengersOfAllDayCoachCar;
        int amountOfPassengersOfAllSleepingCar;

        int amountOfBaggageCar;
        int amountOfDinnerCar;
        int amountOfMailCar;

        double tripDateCoefficient = 1;

        boolean startWinterHolidays;
        boolean endWinterHolidays;
        boolean martHolidays;
        boolean mayHolidays;
        boolean summerHolidays;
        boolean startAutumnHolidays;
        boolean endAutumnHolidays;

        //Раздаём коэффициенты в зависимости от даты поездки для определения количества вагонов

        startWinterHolidays = DataRequestAndProcessing.getTripDataMonth() == 12 && DataRequestAndProcessing.getTripDataNumber() >= 25;
        endWinterHolidays = DataRequestAndProcessing.getTripDataMonth() == 1 && DataRequestAndProcessing.getTripDataNumber() <= 15;
        martHolidays = DataRequestAndProcessing.getTripDataMonth() == 3 && DataRequestAndProcessing.getTripDataNumber() >= 20;
        mayHolidays = DataRequestAndProcessing.getTripDataMonth() == 5 &&
                (DataRequestAndProcessing.getTripDataNumber() <= 10 || DataRequestAndProcessing.getTripDataNumber() >= 20);
        summerHolidays = DataRequestAndProcessing.getTripDataMonth() >= 6 && DataRequestAndProcessing.getTripDataMonth() <= 8;
        startAutumnHolidays = DataRequestAndProcessing.getTripDataMonth() == 10 && DataRequestAndProcessing.getTripDataNumber() >= 25;
        endAutumnHolidays = DataRequestAndProcessing.getTripDataMonth() == 11 && DataRequestAndProcessing.getTripDataNumber() <= 10;

        if (startWinterHolidays || endWinterHolidays) tripDateCoefficient = 1.5;
        if (martHolidays) tripDateCoefficient = 1.2;
        if (mayHolidays) tripDateCoefficient = 1.35;
        if (summerHolidays) tripDateCoefficient = (Math.random()*(1.7 - 1.3)) + 1.3;
        if (startAutumnHolidays || endAutumnHolidays) tripDateCoefficient = 1.2;

        //Генерация количества вагонов

        switch (DataRequestAndProcessing.getTripDistance()){
            case "a":
                amountOfSecondClassCarriage = (int) (7 * tripDateCoefficient);
                amountOfCompartmentCar = (int) (4 * tripDateCoefficient);
                amountOfDayCoachCar = 0;
                amountOfSleepingCar = (int) (1 * tripDateCoefficient);

                amountOfBaggageCar = (int) (2 * tripDateCoefficient);
                amountOfMailCar = (int) (1 * tripDateCoefficient);
                amountOfDinnerCar = (int) (1 * tripDateCoefficient);
                break;
            case "b":
                amountOfSecondClassCarriage = (int) (7 * tripDateCoefficient);
                amountOfCompartmentCar = (int) (3 * tripDateCoefficient);
                amountOfDayCoachCar = (int) (2 * tripDateCoefficient);
                amountOfSleepingCar = 0;

                amountOfBaggageCar = (int) (1 * tripDateCoefficient);
                amountOfMailCar = (int) (1 * tripDateCoefficient);
                amountOfDinnerCar = (int) (1 * tripDateCoefficient);
                break;
            case "c":
                amountOfSecondClassCarriage = 0;
                amountOfCompartmentCar = 0;
                amountOfDayCoachCar = (int) (15 * tripDateCoefficient);
                amountOfSleepingCar = 0;

                amountOfBaggageCar = 0;
                amountOfMailCar = 0;
                amountOfDinnerCar = 0;
                break;
            default:
                amountOfSecondClassCarriage = 0;
                amountOfCompartmentCar = 0;
                amountOfDayCoachCar = 0;
                amountOfSleepingCar = 0;

                amountOfBaggageCar = 0;
                amountOfMailCar = 0;
                amountOfDinnerCar = 0;
        }

        //Подсчёт количества пассажиров и багажа

        amountOfPassengersOfAllSecondClassCarriage = PassengerCar.SECOND_CLASS_CARRIAGE.amountOfPlacesInCar * amountOfSecondClassCarriage;
        amountOfPassengersOfAllCompartmentCar = PassengerCar.COMPARTMENT_CAR.amountOfPlacesInCar * amountOfCompartmentCar;
        amountOfPassengersOfAllDayCoachCar = PassengerCar.DAY_COACH.amountOfPlacesInCar * amountOfDayCoachCar;
        amountOfPassengersOfAllSleepingCar = PassengerCar.SLEEPING_CAR.amountOfPlacesInCar * amountOfSleepingCar;

        System.out.print("Passengers in train: ");
        System.out.println(WaysToSortData.amountOfPassengersInTrain(amountOfPassengersOfAllSecondClassCarriage,
                amountOfPassengersOfAllCompartmentCar, amountOfPassengersOfAllDayCoachCar, amountOfPassengersOfAllSleepingCar));

        System.out.print("Baggage: ");
        System.out.println(WaysToSortData.amountOfBaggageInTrain(amountOfPassengersOfAllSecondClassCarriage,
                amountOfPassengersOfAllCompartmentCar, amountOfPassengersOfAllDayCoachCar, amountOfPassengersOfAllSleepingCar));

        WaysToSortData.createTrain(amountOfSleepingCar, amountOfCompartmentCar,
                amountOfSecondClassCarriage, amountOfDayCoachCar);
        System.out.println("Your train: ");
        System.out.println(railwayTrain);
        System.out.println("\nWe have:\n" +
                amountOfSleepingCar + " sleeping cars\n" +
                amountOfCompartmentCar + " compartment cars\n" +
                amountOfSecondClassCarriage + " second class carriages\n" +
                amountOfDayCoachCar + " day coach cars\n" +
                amountOfDinnerCar + " dinner cars\n" +
                amountOfBaggageCar + " baggage car\n" +
                amountOfMailCar + " mail car");
        System.out.println("Total cars: " + (amountOfBaggageCar + amountOfCompartmentCar + amountOfDayCoachCar +
                amountOfDinnerCar + amountOfMailCar + amountOfSleepingCar + amountOfSecondClassCarriage));
        //если getTripDistance().equals("c"), то все вагоны одинаковы и не имеет смысла искать какие-то особенные
        if (!DataRequestAndProcessing.getTripDistance().equals("c")){
            DataRequestAndProcessing.additionalQuestionsAboutSortedByComfortableLevel();
            DataRequestAndProcessing.additionalQuestionsAboutSelectCarOfOptimalParameter();
        }
    }
}
