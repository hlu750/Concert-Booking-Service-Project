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
    @Column(name = "RID")
    @JsonProperty("id")
    private long id;

    @Column(name = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    // @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JoinColumn(name = "SEAT_ID")

    // @Column(name = "SEAT")
    // @JsonProperty("seat")
    // private List<Seat> seats;

    @ElementCollection
    @CollectionTable(name = "RESERVATION_SEATS", joinColumns =@JoinColumn(name = "RID"))
	@Column(name = "seat")
    @JsonProperty("seat")
	private List<Seat> seats;

    public Reservation() {
    }

    public Reservation(long id, LocalDateTime date, List<Seat> seats) {
        this.id = id;
        this.date = date;
        this.seats = seats;
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
		return new BookingDTO(id, date, seatDTOs);
	}
}
