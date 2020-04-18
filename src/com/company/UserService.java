package com.company;
import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.util.Scanner;

public class UserService {
    public User getUserDetails() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("==============User Details Input for Registration=================");
        System.out.println("Please enter you name : ");
        String name = scanner.nextLine();
        if (name == null || name.isEmpty()) {
            System.out.println("Please enter a valid name");
        }
        user.setName(name);
        System.out.println("enter email");
        String emailId = scanner.nextLine();
        user.setEmailId(emailId);
        System.out.println("enter your password ");
        String password = scanner.nextLine();
        user.setPassword(password);
        System.out.println("enter your phone number ");
        String phoneNumber = scanner.nextLine();
        user.setPhoneNumber(phoneNumber);
        System.out.println("enter your city ");
        String city = scanner.nextLine();
        user.setCity(city);

        return user;
    }
    public String getEmailId() {
        Driver driver = new Driver();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your email ID");
        String emailId = scanner.nextLine();
        emailId= scanner.nextLine();
        return emailId;
    }
    public String getPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Customer, please enter your phone number to book a cab");
        String phoneNumber = scanner.nextLine();
        return phoneNumber;
    }
    public double getLocationLatitude(){
        User user= new User();
        Scanner scanner= new Scanner(System.in);
        System.out.println("enter your position (latitude)");
        Double latitude= scanner.nextDouble();
        final Double latitude1 = latitude;
        return latitude1;
    }
    public double getLocationLongitude() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your position (longitude)");
        Double longitude = scanner.nextDouble();
        return longitude;
    }


}
