import java.util.InputMismatchException;
import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== WELCOME TO THE CINEMA BOOKING SYSTEM ===");

        Movie movie = new Movie("Inception 2", 18);
        CinemaHall hall = new CinemaHall(movie, 10);

        boolean keepGoing = true;

        while (keepGoing) {
            try {
                System.out.println("\n-----------------------------------");
                System.out.print("Please enter your age: ");
                int userAge = scanner.nextInt();

                System.out.print("Enter the seat number you want to book (1-10): ");
                int seatNumber = scanner.nextInt();

                hall.bookSeat(seatNumber, userAge);

            } catch (InvalidSeatNumberException e) {
                System.out.println("SEAT ERROR: " + e.getMessage());
            } catch (AgeLimitException e) {
                System.out.println("AGE ERROR: " + e.getMessage());
            } catch (SeatAlreadyBookedException e) {
                System.out.println("BOOKING ERROR: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("INPUT ERROR: Please enter numeric values only!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(" UNEXPECTED ERROR: " + e.getMessage());
            } finally {
                System.out.println("Operation step completed.");
            }

            // Ask the user if they want to continue
            System.out.print("\nWould you like to book another ticket? (Y/N): ");
            String response = scanner.next();

            if (response.equalsIgnoreCase("N")) {
                keepGoing = false;
            }
        }

        System.out.println("\n=== System session ended. Enjoy the movie! ===");
        scanner.close();
    }
}