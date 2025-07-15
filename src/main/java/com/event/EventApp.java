package com.event;

import java.util.Scanner;

public class EventApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventService service = new EventService();

        while (true) {
        	System.out.println("\n==== Event Management System ====");
            System.out.println("1. Create Event\n2. Assign user to event\n3. Register User\n4. View Events\n5. View All participants\n6. Exit");
            System.out.print("\nEnter your choice : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 : {
                    sc.nextLine();
                    System.out.print("Event Name: ");
                    String name = sc.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = sc.next();
                    sc.nextLine();
                    System.out.print("Location: ");
                    String location = sc.nextLine();
                    service.createEvent(name, date, location);
                }
                
                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    System.out.print("Enter Event ID: ");
                    int eventId = sc.nextInt();
                    service.assignUserToEvent(userId, eventId);  // ✅ Call service method
                    break;
                case 3 :{
                    sc.nextLine();
                    System.out.print("User Name: ");
                    String uname = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.next();
                    service.registerUser(uname, email);
                }
                case 4 : service.viewEvents();
                case 5:
                	service.viewAllUsers();
                case 6 : {
                    service.close();
                    return;
                }
                default : System.out.println("Invalid choice.");
            }
        }
    }
}