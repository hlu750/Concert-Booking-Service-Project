package proj.concert.service.domain;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.*;

import proj.concert.common.dto.BookingDTO;
import proj.concert.common.dto.SeatDTO;

@Entity
@Table(name = "BOOKINGS")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "Booking_ID", unique = true)
    private long id;

    // @Column(name = "DATE")
    private LocalDateTime date;

    // @Column(name = "CONCERT_ID")
    private long concertId;

    @ManyToOne(fetch = FetchType.LAZY)
    // @Column(name = "USERNAME")
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Seat> seats;

    public Booking() {
    }

    public Booking(long concertId, LocalDateTime date, List<Seat> seats) {
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

    // add public boolean equals(Object obj) {}
    // add public int hashCode() {}
}
