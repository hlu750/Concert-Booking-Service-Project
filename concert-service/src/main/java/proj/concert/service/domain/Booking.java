package proj.concert.service.domain;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Domain class for representing a concert booking.
 * It will store the concert id and the seats are booked and the user who book this seat.
 */
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long concertId;
    private LocalDateTime date;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SUBSELECT)
    private List<Seat> seats;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Booking() {}
    
    public Booking(Long concertId, LocalDateTime date, List<Seat> seats, User user) {
        this.date = date;
        this.concertId = concertId;
        this.seats= seats;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getConcertId() {
        return concertId;
    }

    public void setConcertId(long concertId) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
      // public BookingDTO convertToDTO() {
    //     List<SeatDTO> seatDTOs = new ArrayList<>();
    //     for (Seat s : seats) {
    //         seatDTOs.add(s.convertToDTO());
    //     }
	// 	return new BookingDTO(concertId, date, seatDTOs);
	// }

    // add public boolean equals(Object obj) {}
    // add public int hashCode() {}
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Concert))
            return false;
        if (obj == this)
            return true;

        Booking rhs = (Booking) obj;
        return new EqualsBuilder().
                append(concertId, rhs.concertId).append(date,rhs.date).append(user,rhs.user).
                isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(concertId).append(date).append(user).hashCode();
    }
}
