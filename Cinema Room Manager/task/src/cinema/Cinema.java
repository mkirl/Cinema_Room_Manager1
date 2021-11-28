package cinema;
import java.util.Scanner;

public class Cinema {

    public static void print(String[][] array, int rows, int seatsPerRow) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seatsPerRow; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seatsPerRow; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void statistics(String[][] array, int rows, int seatsPerRow) {
        //var declarations
        int frontTickets = 0;
        int backTickets = 0;
        int rowFront = rows / 2;
        int rowBack = rows - rowFront;
        int totalSeats = rows * seatsPerRow;
        int currentIncome = 0;
        int totalIncome = 0;

        //count all taken seats
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                if (array[i][j] == "B") {
                    if (i < rowFront) {
                        frontTickets++;
                    } else {backTickets++;}
                }
            }
        }

        int purchasedTickets = frontTickets + backTickets;

        if (totalSeats < 60) {
            currentIncome = purchasedTickets * 8;
            totalIncome = totalSeats * 8;
        }
        if (totalSeats > 60) {
            currentIncome = frontTickets * 10 + backTickets * 8;
            totalIncome = (rowBack * 8 * seatsPerRow) + (rowFront * 10 * seatsPerRow);
        }
        float percentage = (float) purchasedTickets / (float) totalSeats * 100;

        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f", percentage);
        System.out.print("%\n");
        System.out.println("Current income $" + currentIncome);
        System.out.println("Total Income: $" + totalIncome);

    }

    public static void checkSeat(String[][] array, int rows, int seatsPerRow) {
        Scanner scan = new Scanner(System.in);
        int totalSeats = rows * seatsPerRow;
        System.out.println("Enter a row number:");
        int selectedRow = scan.nextInt();
        System.out.println("Enter a seat number in that row:");
        int selectedSeatsPerRow = scan.nextInt();
        //Exception handling
        while ((selectedRow < 0 || selectedRow > rows || selectedSeatsPerRow < 0 || selectedSeatsPerRow > seatsPerRow) == true) {
            System.out.println("Wrong input!");
            System.out.println("Enter a row number:");
            selectedRow = scan.nextInt();
            System.out.println("Enter a seat number in that row:");
            selectedSeatsPerRow = scan.nextInt();
            System.out.println();
        }
        if (array[selectedRow - 1][selectedSeatsPerRow - 1] == "B") {
            boolean inputCheck = false;
            while (inputCheck == false) {
                System.out.println("That ticket has already been purchased!");
                System.out.println("Enter a row number:");
                selectedRow = scan.nextInt();
                System.out.println("Enter a seat number in that row:");
                selectedSeatsPerRow = scan.nextInt();
                if (array[selectedRow - 1][selectedSeatsPerRow - 1] == "S") {
                    inputCheck = true;
                }
            }
        }

        array[selectedRow - 1][selectedSeatsPerRow - 1] = "B";

        if (totalSeats < 60) {
            System.out.println("Ticket price: $" + 10);
        }
        if (totalSeats > 60) {
            int ticketsFront = rows / 2;
            int ticketsBack = rows - ticketsFront;
            //int totalCost = (ticketsBack * 8 * seatsPerRow) + (ticketsFront * 10 * seatsPerRow);
            if (selectedRow <= ticketsFront) {
                System.out.println("Ticket price: $" + 10);
            } else { System.out.println("Ticket price: $" + 8);}
            //System.out.println("$" + totalCost);

        }
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner scan = new Scanner(System.in);


        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scan.nextInt();
        //System.out.println("Total income:");
        System.out.println();

        String[][] array = new String[rows][seatsPerRow];

        //Load Array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                array[i][j] = "S";
            }
        }

        //Menu Loop

        int menu = 0;
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            menu = scan.nextInt();
            switch(menu) {
                case 1:
                    print(array, rows, seatsPerRow);
                    break;
                case 2:
                    checkSeat(array, rows, seatsPerRow);
                    break;
                case 3:
                    statistics(array, rows, seatsPerRow);
                    break;
                case 4:
                    System.exit(0);
            }

        } while (menu != 0);

        /*
        print(array, rows, seatsPerRow);
        System.out.println();

        //checkSeat goes here
        checkSeat(array, rows, seatsPerRow);


        print(array, rows, seatsPerRow);
        System.out.println();
        */




    }
}