package com.train.work_with_data;

public enum PassengerCar {
    /*храним типы пассажирских вагонов с указанием числа мест
    Купейный (COMPARTMENT_CAR),
    Сидячий (DAY_COACH),
    Плацкартный (SECOND_CLASS_CARRIAGE),
    Спальный (SLEEPING_CAR)
     */
    SLEEPING_CAR(24, 1),
    COMPARTMENT_CAR(38, 2),
    SECOND_CLASS_CARRIAGE(54, 3),
    DAY_COACH(66, 4);


    public int amountOfPlacesInCar;
    public int comfortableLevel;
    PassengerCar (int amountOfPlacesInCar, int comfortableLevel){
        this.amountOfPlacesInCar = amountOfPlacesInCar;
        this.comfortableLevel = comfortableLevel;
    }
}
