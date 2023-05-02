package proj.concert.service.domain;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.*;

import proj.concert.common.dto.BookingDTO;
import proj.concert.common.dto.SeatDTO;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime date;
    private long concertId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Seat> seats;

    public Booking() {
    }

    // public Booking(User user,long concertId,LocalDateTime date){
    //     this.user = user;
    //     this.concertId = concertId;
    //     this.date=date;
    // }
    
    public Booking(long concertId, LocalDateTime date, List<Seat> seats, User user) {
        this.concertId = concertId;
        this.date = date;
        this.seats = seats;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getConcertId() {
        return concertId;
    }

    public void setConcertId(long concertId) {
        this.concertId = concertId;
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
