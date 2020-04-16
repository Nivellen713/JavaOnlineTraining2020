package com.train.work_with_data;

   /*
   Данный класс занимается всей сложной обработкой данных
   Здесь описаны все нужные варианты сортировка данных из условий задачи:
    1. Подсчитать общую численность пассажиров и багажа.
    2. Провести сортировку вагонов поезда на основе уровня комфортности.
    3. Найти в поезде вагоны, соответствующие заданному диапазону параметров числа пассажиров.
        Параметры:
        Уровень комфортности и близость к середине состава
        Уровень комфортности и низкая цена
        Близость к середине состава и низкая цена
     */

import com.train.railway_train_create.CreateRailwayTrain;

import java.util.List;

public class WaysToSortData extends DataRequestAndProcessing {

    public static int amountOfPassengersInTrain(int amountOfPassengersOfAllSecondClassCarriage,
                                                int amountOfPassengersOfAllCompartmentCar,
                                                int amountOfPassengersOfAllDayCoachCar,
                                                int amountOfPassengersOfAllSleepingCar) {
        return amountOfPassengersOfAllSecondClassCarriage +
                amountOfPassengersOfAllCompartmentCar +
                amountOfPassengersOfAllDayCoachCar +
                amountOfPassengersOfAllSleepingCar;
    }

    public static int amountOfBaggageInTrain(int amountOfPassengersOfAllSecondClassCarriage,
                                             int amountOfPassengersOfAllCompartmentCar,
                                             int amountOfPassengersOfAllDayCoachCar,
                                             int amountOfPassengersOfAllSleepingCar) {
        return amountOfPassengersOfAllSecondClassCarriage +
                (int) (amountOfPassengersOfAllCompartmentCar * 1.5) +
                amountOfPassengersOfAllDayCoachCar +
                amountOfPassengersOfAllSleepingCar * 2;
    }

    static void railwayTrainGenerationOfComfortableLevel(int amountOfSleepingCar, int amountOfCompartmentCar,
                                                         int amountOfSecondClassCarriage, int amountOfDayCoachCar) {
        for (int i = 0; i < amountOfSleepingCar; i++) {
            CreateRailwayTrain.railwayTrainSortedByComfort.add(PassengerCar.SLEEPING_CAR);
        }
        for (int i = 0; i < amountOfCompartmentCar; i++) {
            CreateRailwayTrain.railwayTrainSortedByComfort.add(PassengerCar.COMPARTMENT_CAR);
        }
        for (int i = 0; i < amountOfSecondClassCarriage; i++) {
            CreateRailwayTrain.railwayTrainSortedByComfort.add(PassengerCar.SECOND_CLASS_CARRIAGE);
        }
        for (int i = 0; i < amountOfDayCoachCar; i++) {
            CreateRailwayTrain.railwayTrainSortedByComfort.add(PassengerCar.DAY_COACH);
        }
        if (DataRequestAndProcessing.getTripDistance() == "a") {
            CreateRailwayTrain.railwayTrainSortedByComfort.add(CreateRailwayTrain.railwayTrainSortedByComfort.size() / 2, FreightCar.DINING_CAR);
            CreateRailwayTrain.railwayTrainSortedByComfort.add(CreateRailwayTrain.railwayTrainSortedByComfort.size(), FreightCar.BAGGAGE_CAR);
            CreateRailwayTrain.railwayTrainSortedByComfort.add(CreateRailwayTrain.railwayTrainSortedByComfort.size(), FreightCar.BAGGAGE_CAR);
            CreateRailwayTrain.railwayTrainSortedByComfort.add(CreateRailwayTrain.railwayTrainSortedByComfort.size(), FreightCar.MAIL_CAR);
        } else if (DataRequestAndProcessing.getTripDistance() == "b") {
            CreateRailwayTrain.railwayTrainSortedByComfort.add(CreateRailwayTrain.railwayTrainSortedByComfort.size() / 2, FreightCar.DINING_CAR);
            CreateRailwayTrain.railwayTrainSortedByComfort.add(CreateRailwayTrain.railwayTrainSortedByComfort.size(), FreightCar.BAGGAGE_CAR);
            CreateRailwayTrain.railwayTrainSortedByComfort.add(CreateRailwayTrain.railwayTrainSortedByComfort.size(), FreightCar.MAIL_CAR);
        }
    }

    public static void createTrain(int amountOfSleepingCar, int amountOfCompartmentCar,
                                   int amountOfSecondClassCarriage, int amountOfDayCoachCar) {
        //генерируем первую половину состава (от низкого уровня комфортности к высокому)
        for (int i = 0; i < amountOfDayCoachCar / 2; i++) {
            CreateRailwayTrain.railwayTrain.add(PassengerCar.DAY_COACH);
        }
        for (int i = 0; i < amountOfSecondClassCarriage / 2; i++) {
            CreateRailwayTrain.railwayTrain.add(PassengerCar.SECOND_CLASS_CARRIAGE);
        }
        for (int i = 0; i < amountOfCompartmentCar / 2; i++) {
            CreateRailwayTrain.railwayTrain.add(PassengerCar.COMPARTMENT_CAR);
        }
        for (int i = 0; i < amountOfSleepingCar; i++) {
            CreateRailwayTrain.railwayTrain.add(PassengerCar.SLEEPING_CAR);
        }
        //генерируем вторую половину состава (от высокого уровня комфортности к низкому)
        for (int i = 0; i < amountOfCompartmentCar / 2; i++) {
            CreateRailwayTrain.railwayTrain.add(PassengerCar.COMPARTMENT_CAR);
        }
        for (int i = 0; i < amountOfSecondClassCarriage / 2; i++) {
            CreateRailwayTrain.railwayTrain.add(PassengerCar.SECOND_CLASS_CARRIAGE);
        }
        for (int i = 0; i < amountOfDayCoachCar / 2; i++) {
            CreateRailwayTrain.railwayTrain.add(PassengerCar.DAY_COACH);
        }

        if (DataRequestAndProcessing.getTripDistance() == "a") {
            CreateRailwayTrain.railwayTrain.add(CreateRailwayTrain.railwayTrain.size() / 2, FreightCar.DINING_CAR);
            CreateRailwayTrain.railwayTrain.add(CreateRailwayTrain.railwayTrain.size(), FreightCar.BAGGAGE_CAR);
            CreateRailwayTrain.railwayTrain.add(CreateRailwayTrain.railwayTrain.size(), FreightCar.BAGGAGE_CAR);
            CreateRailwayTrain.railwayTrain.add(CreateRailwayTrain.railwayTrain.size(), FreightCar.MAIL_CAR);
        } else if (DataRequestAndProcessing.getTripDistance() == "b") {
            CreateRailwayTrain.railwayTrain.add(CreateRailwayTrain.railwayTrain.size() / 2, FreightCar.DINING_CAR);
            CreateRailwayTrain.railwayTrain.add(CreateRailwayTrain.railwayTrain.size(), FreightCar.BAGGAGE_CAR);
            CreateRailwayTrain.railwayTrain.add(CreateRailwayTrain.railwayTrain.size(), FreightCar.MAIL_CAR);
        }
    }

    static void selectCarsOfEnteredUserParameter(String usersSelect) {
        /*
        a)Уровень комфортности и близость к середине состава
        b)Уровень комфортности и низкая цена
        c)Близость к середине состава и низкая цена
         */
        if (getTripDistance().equals("a")) {
            usersSelect = usersSelect.toLowerCase().trim();
            switch (usersSelect) {
                case "a":
                    System.out.println("Recommended to you select sleeping car\n" +
                            "This car has high comfortable level, but it has a high price");
                    break;
                case "b":
                    System.out.println("Recommended to you select second class carriage\n" +
                            "This car has middle comfortable level and has a relatively low price");
                    break;
                case "c":
                    System.out.println("Recommended to you select compartment car\n" +
                            "It is no low price, but it high comfortable level and close to middle of train");
                    break;
                default:
                    System.out.println("You don't select letter");
            }
        }
        if (getTripDistance().equals("b")) {
            usersSelect = usersSelect.toLowerCase().trim();
            switch (usersSelect) {
                case "a":
                    System.out.println("Recommended to you select compartment car\n" +
                            "This car has high comfortable level, but it has a high price");
                    break;
                case "b":
                    System.out.println("Recommended to you select second class carriage\n" +
                            "This car has middle comfortable level and has a relatively low price");
                    break;
                case "c":
                    System.out.println("Recommended to you select day coach car\n" +
                            "It is not close to middle of train, but is low price");
                    break;
                default:
                    System.out.println("You don't select letter");
            }
        }
    }
}
