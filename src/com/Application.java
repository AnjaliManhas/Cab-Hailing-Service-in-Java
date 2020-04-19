package com.company;
import com.MySQLAccess;

import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.util.Scanner;

public class Application {
    private static com.company.DriverService driverService = new com.company.DriverService();
    static Map<String, Driver> driverMap = new HashMap<>();
    static Map<String, User>userMap = new HashMap<>();
    static Map<UUID, com.company.Booking>bookingMap = new HashMap<>();
    static UserService userService = new UserService();
    static com.company.BookingService bookingService = new com.company.BookingService();
    static MySQLAccess mySQLAccess= new MySQLAccess();

    public static void main(String[] args) throws Exception {
        System.out.println("****************Diamond Cab Service***************");
        Driver driver;
        User user = null;
        boolean n = true;
        int choice;
        char a;
        Scanner scan = new Scanner(System.in);
        while (n == true) {
            System.out.println("enter your choice= 1. Register a driver  2. Register a customer  3. Book a cab  4. Update Driver Location");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    driver = driverService.getDriverDetails();
                    driverMap.put(driver.getCarNumber(), driver);
                    mySQLAccess.writeDriverDetailsInDatabase( driver.getDriverId(), driver.getDriverName(), driver.getDriverPhoneNumber(),driver.getCarNumber(), driver.getCarName(), driver.getCarColor(), driver.getLatitude(), driver.getLongitude());
                    break;
                }
                case 2: {
                    UserService userService = new UserService();
                    user = userService.getUserDetails();
                    userMap.put(user.getEmailId(), user);
                    break;
                }
                case 3:{
                    UserService userService = new UserService();
                    String customerPhoneNumber = user.getPhoneNumber();
                    Double latitude = userService.getLocationLatitude();
                    Double longitude = userService.getLocationLongitude();
                    String carNumber = driverService.findCarNumberOfNearestCab(latitude, longitude, driverMap);
                    String driverPhoneNumber= driverMap.get(carNumber).getDriverPhoneNumber();
                    com.company.Booking booking = bookingService.book(customerPhoneNumber, driverPhoneNumber);
                    bookingMap.put(((com.company.Booking) booking).getUuid(), booking);
                    break;
                }

                case 4: {
                    String carNumber = driverService.getDriverCarNumber();
                    Driver driver1 = driverMap.get(carNumber);
                    driverService.setDriverLocation(driver1);
                    driverMap.put(carNumber, driver1);
                    break;
                }
                default: {
                    System.out.println("invalid choice");
                }
            }
            System.out.println("do you want to continue?");
            a = scan.next().charAt(0);
            if (a == 'Y' || a == 'y') {
                continue;
            }
            if (a == 'N' || a == 'n') {
                break;
            }


        }
    }

}



