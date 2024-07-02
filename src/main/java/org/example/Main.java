package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static Gson gson;
    public static String city;

    public static void main(String[] args) {
        gson = new Gson();

        try {
            insertCity();
            showCityWeather();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void insertCity() {
        System.out.println("Parašykite miestą: ");
        Scanner scanner = new Scanner(System.in);
        city = scanner.nextLine();
    }

    public static void showCityWeather() throws IOException, InterruptedException {
        String url = "https://api.meteo.lt/v1/places/" + city + "/forecasts/long-term/";
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
        HttpRequest request = HttpRequest.newBuilder()

                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject json = gson.fromJson(response.body(), JsonObject.class);
        System.out.println(json.toString());
    }


}