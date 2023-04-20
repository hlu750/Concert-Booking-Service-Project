package proj.concert.service.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.*;

import proj.concert.common.dto.SeatDTO;

@Entity
@Table(name = "SEAT")
public class Seat{

    // TODO Implement this class.
	@Id
    @Column(name = "LABEL")
    @JsonProperty("label")
    private String label;

    @Column(name = "ISBOOKED")
    @JsonProperty("isBooked")
    private boolean isBooked;

	@Column(name = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

	@Column(name = "COST")
    @JsonProperty("cost")
    private BigDecimal cost;

	public Seat(String label, boolean isBooked, LocalDateTime date, BigDecimal cost) {	
		this.label = label;
        this.isBooked = isBooked;
        this.date = date;
        this.cost = cost;
	}	
	
	public Seat() {}	

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
	
    public boolean getIsBooked() {
        return isBooked;
    }

    public void setGenre(boolean isBooked) {
        this.isBooked = isBooked;
    }

	public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

	public SeatDTO convertToDTO() {
		return new SeatDTO(label, cost);
	}

}
