public class CinemaHall {
    Movie movie;
    boolean[] seats;

    public CinemaHall(Movie movie, int totalSeats) {
        this.movie = movie;
        this.seats = new boolean[totalSeats];
    }

    public void bookSeat(int seatNumber, int userAge)
            throws AgeLimitException, SeatAlreadyBookedException, InvalidSeatNumberException {

        if (seatNumber < 1 || seatNumber > seats.length) {
            throw new InvalidSeatNumberException("Invalid seat number! Total hall capacity: " + seats.length);
        }

        if (userAge < movie.ageLimit) {
            throw new AgeLimitException("You do not meet the age requirement for this movie! Required age: " + movie.ageLimit);
        }

        if (seats[seatNumber - 1]) {
            throw new SeatAlreadyBookedException("Seat number " + seatNumber + " is already booked!");
        }

        seats[seatNumber - 1] = true;
        System.out.println("✅ Seat number " + seatNumber + " has been successfully booked!");
    }
}