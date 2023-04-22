package proj.concert.service.domain;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.*;

import proj.concert.common.dto.SeatDTO;

@Entity
public class Seat{

    // TODO Implement this class.
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "LABEL", unique = true)
    private String label;

    // @Column(name = "ISBOOKED")
    private boolean isBooked;

	// @Column(name = "DATE")
    private LocalDateTime date;

	// @Column(name = "COST")
    private BigDecimal cost;

	// @Version
	// private Long version;

	public Seat(String label, boolean isBooked, LocalDateTime date, BigDecimal cost) {	
		this.label = label;
        this.isBooked = isBooked;
        this.date = date;
        this.cost = cost;
	}	
	
	public Seat() {}	

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
	
    public boolean getIsBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
		isBooked = booked;
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

	// public SeatDTO convertToDTO() {
	// 	return new SeatDTO(label, cost);
	// }
    @Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Seat))
			return false;
		if (obj == this)
			return true;

		Seat rhs = (Seat) obj;
		return new EqualsBuilder().
				append(label, rhs.label).append(date,rhs.date).append(cost,rhs.cost).
				isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).
				append(label).append(date).append(cost).hashCode();
	}

}
