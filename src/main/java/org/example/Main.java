package org.example;

import com.google.gson.Gson;

import java.util.Scanner;

import static java.awt.AWTEventMulticaster.add;

public class Main {
    public static Gson gson;
    public static String city;
    public static void main(String[] args) {
        gson = new Gson();
        insertCity();
//uzd1 istraukti miesta is API, sukonstruoti jo java objektą ir atspausdinti consolėje su .toString();

    }

    public static void insertCity() {
        System.out.println("Parašykite miestą: ");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();

    }
    public static void showCityWeather(){
        if (city == null){
            System.out.println("Please insert city first!");
        }
        String url = "https://api.meteo.lt/v1/places/" + city + "/forcasts/long-term";

    }
    public static void updateCityList(){

    }
}