package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DriverService {
    public Driver getDriverDetails() {
        Driver driver = new Driver();
        Scanner scanner = new Scanner(System.in);
        System.out.println("==============Driver Details Input for Registration=================");
        System.out.println("Please enter you name : ");
        String driverName = scanner.nextLine();
        if (driverName == null || driverName.isEmpty()) {
            System.out.println("Please enter a valid name");
        }
        driver.setDriverName(driverName);
        System.out.println("enter your ID ");
        String driverId = scanner.nextLine();
        driver.setDriverId(driverId);
        System.out.println("enter your number ");
        String driverPhoneNumber = scanner.nextLine();
        driver.setDriverPhoneNumber(driverPhoneNumber);
        System.out.println("enter your car's number");
        String carNumber = scanner.nextLine();
        driver.setCarNumber(carNumber);
        System.out.println("enter the car's name");
        String carName = scanner.nextLine();
        driver.setCarName(carName);
        System.out.println("enter the car's color");
        String carColor = scanner.nextLine();
        driver.setCarColor(carColor);
        setDriverLocation(driver);

        return driver;
    }

    public String getDriverCarNumber() {
        Driver driver = new Driver();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your car's number");
        String carNumber = scanner.nextLine();
        System.out.println("checking the car number "+carNumber+"-");
        return carNumber;
    }



    public void setDriverLocation(Driver driver) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your location (latitude and longtitude)");
        double latitude = scanner.nextInt();
        double longitude = scanner.nextInt();
        driver.setLatitude(latitude);
        driver.setLongitude(longitude);
    }

    public String findCarNumberOfNearestCab(Double latitude, Double longitude, Map<String, Driver> driverMap) {
        TreeMap<Double, String> nearByMap = new TreeMap<>();
        for(Driver driver : driverMap.values()){
            Double distance = Math.pow((driver.getLatitude() - latitude), 2) + Math.pow((driver.getLongitude() - longitude), 2);
            nearByMap.put(distance, driver.getCarNumber());
        }
        Map.Entry<Double, String> firstEntry = nearByMap.pollFirstEntry();
        return firstEntry.getValue();

        }
    }

