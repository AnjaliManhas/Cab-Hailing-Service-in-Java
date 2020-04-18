package com.company;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.util.Scanner;
import java.util.Date;
import java.util.UUID;

import java.util.Date;
import java.util.UUID;

import static java.lang.System.out;

public class BookingService {
    public com.company.Booking book(String customerPhoneNumber, String driverPhoneNumber) {
        com.company.Booking booking = new com.company.Booking();
        booking.setCustomerPhoneNumber(customerPhoneNumber);
        booking.setDriverPhoneNumber(driverPhoneNumber);
        final String driverPhoneNumber1 = booking.getDriverPhoneNumber();
        System.out.println("**********Diamond Cab Hailing Service**********");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        booking.setStartTime(new Date());
        System.out.println("Your cab has been booked. You may call the driver at"+driverPhoneNumber1);
        booking.setUuid(UUID.randomUUID());
        UUID uuid = booking.getUuid();
        System.out.println("booking Id="+uuid);

        //we will fill end when the trip ends
        booking.setStatus("ACTIVE");
        String status = booking.getStatus();
        System.out.println("the status of your booking is="+ status);
        System.out.println("******thank for using our services******");
        return booking;
    }
}
