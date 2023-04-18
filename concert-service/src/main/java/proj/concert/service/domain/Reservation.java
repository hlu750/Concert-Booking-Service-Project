package proj.concert.service.domain;


import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Column(name = "ID")
    @JsonProperty("id")
    private long id;

    @Column(name = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @Column(name = "SEAT")
    @JsonProperty("seat")
    private Seat seat;

    public Reservation() {
    }

    public Reservation(long id, LocalDateTime date, Seat seat) {
        this.id = id;
        this.date = date;
        this.seat = seat;
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

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
