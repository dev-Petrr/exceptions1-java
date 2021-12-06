package com.java.udemy;

import entities.Reservation;
import entities.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner tc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = tc.nextInt();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            Date checkIn = sdf.parse(tc.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            Date checkOut = sdf.parse(tc.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();

            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = sdf.parse(tc.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = sdf.parse(tc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            //tipo de exceção genérica com upcasting pra runtimeExc
            System.out.println("Unexpected error!");
        }


        tc.close();
    }
}
