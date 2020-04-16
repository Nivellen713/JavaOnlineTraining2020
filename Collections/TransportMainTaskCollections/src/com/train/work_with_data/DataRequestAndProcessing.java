package com.train.work_with_data;
import com.train.railway_train_create.CreateRailwayTrain;

import java.util.List;
import java.util.Scanner;

/*
Данный класс заниматеся приёмом всех данных от пользователя. Задаёт пользователю вопросы
и выводит необходимую и по запросу информацию
 */

public class DataRequestAndProcessing {
    private static String tripDistance = "Please select letter";
    private static int tripDataNumber = 0;
    private static int tripDataMonth = 0;
    private static String answerForQuestion = "no";
    private static String usersSelect = "Please select letter";
    private static Scanner scanner = new Scanner(System.in);

    public static String getTripDistance() {
        return tripDistance;
    }

    public static int getTripDataNumber() {
        return tripDataNumber;
    }

    public static int getTripDataMonth() {
        return tripDataMonth;
    }

    private static String processingAnswersToQuestionsWithChoiceOfAnswer(String answerForQuestion) {
        answerForQuestion = answerForQuestion.toLowerCase().trim();
        switch (answerForQuestion) {
            case "a":
                return "a";
            case "b":
                return "b";
            case "c":
                return "c";
            default:
                return "Please select letter";
        }
    }

    // узнаём дату поездки чтобы определить количество вагонов и примерный процент их занятости
    // по критериям: каникулы, праздники, отпуск и т.д.
    private static int processingAnswersToQuestionsWithDataMonth(String answerForQuestion) {
        answerForQuestion = answerForQuestion.toLowerCase().trim();
        switch (answerForQuestion.trim().toLowerCase()) {
            case "january":
                return 1;
            case "february":
                return 2;
            case "mart":
                return 3;
            case "april":
                return 4;
            case "may":
                return 5;
            case "june":
                return 6;
            case "july":
                return 7;
            case "august":
                return 8;
            case "september":
                return 9;
            case "october":
                return 10;
            case "november":
                return 11;
            case "december":
                return 12;
            default:
                return 0;
        }
    }

    private static String selectCarOfUserParameters(){
        String carSelectionParameter = "Please select letter";
        System.out.print("Please select the parameters that will be used to find a car that is comfortable for you:\n");
        do{
            System.out.print(carSelectionParameter + '\n');
            System.out.println("a) High comfortable level and close to middle of train\n" +
                    "b) Close to middle of train and low price\n" +
                    "c) High comfortable level and low price");
            System.out.print("Your select: ");
            carSelectionParameter = processingAnswersToQuestionsWithChoiceOfAnswer(scanner.next());
        } while(carSelectionParameter.equals("Please select letter"));
        return carSelectionParameter;
    }

    public static void additionalQuestionsAboutSortedByComfortableLevel(){
        answerForQuestion = "no";
        System.out.println("\nDo you want look at train sorted by comfortable level?");
        answerForQuestion = scanner.next();
        answerForQuestion = answerForQuestion.toLowerCase().trim();
        if (answerForQuestion.equals("yes") || answerForQuestion.equals("y") || answerForQuestion.equals("yeah")){
            WaysToSortData.railwayTrainGenerationOfComfortableLevel(CreateRailwayTrain.amountOfSleepingCar,
                    CreateRailwayTrain.amountOfCompartmentCar,
                    CreateRailwayTrain.amountOfSecondClassCarriage,
                    CreateRailwayTrain.amountOfDayCoachCar);
            System.out.println(CreateRailwayTrain.railwayTrainSortedByComfort);
        }
    }

    public static void additionalQuestionsAboutSelectCarOfOptimalParameter(){
        answerForQuestion = "no";
        System.out.println("\nDo you want select car of optimal parameter?");
        answerForQuestion = scanner.next();
        answerForQuestion = answerForQuestion.toLowerCase().trim();
        if (answerForQuestion.equals("yes") || answerForQuestion.equals("y") || answerForQuestion.equals("yeah")){
            usersSelect = selectCarOfUserParameters();
            WaysToSortData.selectCarsOfEnteredUserParameter(usersSelect);
        }
    }

    public static void main() {

        System.out.println("Determination of the distance of travel: ");
        do {
            System.out.print(tripDistance + '\n');
            System.out.println("a) Further than 700 kilometers;\n" +
                    "b) From 200 to 700 kilometers;\n" +
                    "c) Closer than 200 kilometers.\n");
            System.out.print("Your select: ");
            tripDistance = processingAnswersToQuestionsWithChoiceOfAnswer(scanner.next());
        } while (tripDistance.equals("Please select letter"));


        do {
            System.out.print("Print data trip month: ");
            tripDataMonth = processingAnswersToQuestionsWithDataMonth(scanner.next());
            System.out.print("and number of month: ");
            tripDataNumber = scanner.nextInt();
            if (tripDataNumber < 1 || tripDataNumber > 31){
                tripDataNumber = 0;
                tripDataMonth = 0;
            }
        } while (tripDataNumber == 0 || tripDataMonth == 0);
    }
}
