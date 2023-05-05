package proj.concert.service.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import proj.concert.common.dto.ConcertDTO;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "CONCERTS")
public class Concert{ 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false , unique = true)
    private Long id;

    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(name = "BLURB", length=1024)
    private String blurb;

    @ElementCollection //(fetch = FetchType.EAGER)
    @CollectionTable(name = "CONCERT_DATES", joinColumns = @JoinColumn(name = "CONCERT_ID"))
	@Column(name = "DATE")
	private Set<LocalDateTime> dates = new HashSet<>();
    
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "CONCERT_PERFORMER",
			joinColumns = @JoinColumn(name = "CONCERT_ID"),
			inverseJoinColumns = @JoinColumn(name = "PERFORMER_ID"))
    @Column(name = "PERFORMER_ID")
    private Set<Performer> performers = new HashSet<>();

    // public Concert(Long id, String title, String imageName, String blurb, List<Performer> performer) {
    //     this.id = id;
    //     this.title = title;
    //     this.imageName = imageName;
    //     this.blurb = blurb;
    //     this.performers = performers;
    // }

    // public Concert(String title, String imageName) {
    //     this.title = title;
    //     this.imageName = imageName;
    // }

    public Concert() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public Set<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(Set<LocalDateTime> dates) {
        this.dates = dates;
    }

    public Set<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(Set<Performer> performers) {
        this.performers = performers;
    }

    public ConcertDTO convertToDTO() {
		return new ConcertDTO(id, title, imageName, blurb);
	}

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Concert))
            return false;
        if (obj == this)
            return true;

        Concert rhs = (Concert) obj;
        return new EqualsBuilder().
                append(title, rhs.title).
                isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(title).hashCode();
    }
}