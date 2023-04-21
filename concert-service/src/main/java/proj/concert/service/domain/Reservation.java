// package proj.concert.service.domain;

// import org.hibernate.annotations.FetchMode;

// import javax.persistence.*;

// import java.time.LocalDateTime;
// import java.util.List;

// /**
//  * A domain class that represents a completed booking.
//  * concertId   the id of the concert which was booked
//  * date        the date on which that concert was booked
//  * seats       the seats which were booked for that concert on that date
//  * user        the user who made this booking
//  */
// @Entity
// @Table(name = "RESERVATIONS")
// public class Reservation {

//     @Id
//     @GeneratedValue
//     private Long id;

//     private LocalDateTime date;
//     private Long concertId;

//     @ManyToOne
//     private User user;

//     @OneToMany(fetch = FetchType.EAGER)
//     private List<Seat> seats;

//     public Reservation() {

//     }

//     public Reservation(LocalDateTime date, Long concertId, User user, List<Seat> seats) {
//         this.date = date;
//         this.concertId = concertId;
//         this.user = user;
//         this.seats = seats;
//     }

//     public Long getId() { return id; }

//     public void setId(Long id) { this.id = id; }

//     public LocalDateTime getDate() { return date; }

//     public void setDate(LocalDateTime date) { this.date = date; }

//     public Long getConcertId() { return concertId; }

//     public void setConcertId(Long concertId) { this.concertId = concertId; }

//     public User getUser() { return user; }

//     public void setUser(User user) { this.user = user; }

//     public List<Seat> getSeats() { return seats; }

//     public void setSeats(List<Seat> seats) { this.seats = seats; }
// }








package proj.concert.service.domain;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import proj.concert.common.dto.BookingDTO;
import proj.concert.common.dto.SeatDTO;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "RESERVATION_ID", unique = true)
    private long id;

    // @Column(name = "DATE")
    private LocalDateTime date;

    // @Column(name = "CONCERT_ID")
    private long concertId;

    @ManyToOne
    // @Column(name = "USERNAME")
    private User user;

    // @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JoinColumn(name = "SEAT_ID")

    // @Column(name = "SEAT")
    // @JsonProperty("seat")
    // private List<Seat> seats;

    // @ElementCollection
    // @CollectionTable(name = "RESERVATION_SEAT", joinColumns =@JoinColumn(name = "RESERVATION_ID"))
	// @Column(name = "seat")
    // @JsonProperty("seat")
	// private List<Seat> seats;

    @OneToMany(fetch = FetchType.EAGER)
    // @Column(name = "SEAT")
    private List<Seat> seats;

    public Reservation() {
    }

    public Reservation(long concertId, LocalDateTime date, List<Seat> seats) {
        this.concertId = concertId;
        this.date = date;
        this.seats = seats;
    }

    public long getId() {
        return concertId;
    }

    public void setId(long concertId) {
        this.concertId = concertId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public BookingDTO convertToDTO() {
        List<SeatDTO> seatDTOs = new ArrayList<>();
        for (Seat s : seats) {
            seatDTOs.add(s.convertToDTO());
        }
		return new BookingDTO(concertId, date, seatDTOs);
	}
}
