
// package proj.concert.service.domain;

// import java.time.LocalDateTime;
// import java.util.*;

// import javax.persistence.*;

// import org.apache.commons.lang3.builder.EqualsBuilder;
// import org.apache.commons.lang3.builder.HashCodeBuilder;
// import org.hibernate.annotations.Fetch;
// import org.hibernate.annotations.FetchMode;

// /**
//  * Domain class to represent concerts.
//  * <p>
//  * A Concert describes a concert in terms of:
//  * id           the unique identifier for a concert.
//  * title        the concert's title.
//  * dates        the concert's scheduled dates and times (represented as a Set of LocalDateTime instances).
//  * imageName    an image name for the concert.
//  * performers   the performers in the concert
//  * blurb        the concert's description
//  */
// @Entity
// @Table(name = "CONCERTS")
// public class Concert {

//     @Id
//     @GeneratedValue
//     private Long id;

//     private String title;

//     @Column(name = "IMAGE_NAME")
//     private String imageName;

//     @Column(name="BLURB", length=1024)
//     private String blurb;

//     @ElementCollection
//     @CollectionTable(
//             name = "CONCERT_DATES",
//             joinColumns = @JoinColumn(name = "CONCERT_ID")
//     )
//     @Column(name = "DATE")
//     private Set<LocalDateTime> dates;

//     @ManyToMany(cascade = CascadeType.PERSIST)
//     @org.hibernate.annotations.Fetch(
//             FetchMode.SUBSELECT
//     )
//     @JoinTable(
//             name = "CONCERT_PERFORMER",
//             joinColumns = @JoinColumn(name = "CONCERT_ID"),
//             inverseJoinColumns = @JoinColumn(name = "PERFORMER_ID")
//     )
//     @Column(name="PERFORMER")
//     private Set<Performer> performers;

//     public Concert() {

//     }

//     public Concert(Long id, String title, String imageName, String blurb) {
//         this.id = id;
//         this.title = title;
//         this.imageName = imageName;
//         this.blurb = blurb;
//     }

//     public Long getId() { return id; }

//     public void setId(Long id) { this.id = id; }

//     public String getTitle() { return title; }

//     public void setTitle(String title) { this.title = title; }

//     public String getImageName() { return imageName; }

//     public void setImageName(String imageName) { this.imageName = imageName; }

//     public String getBlurb() { return blurb; }

//     public void setBlurb(String blurb) { this.blurb = blurb; }

//     public Set<LocalDateTime> getDates() { return this.dates; }

//     public void setDates(Set<LocalDateTime> dates) { this.dates = dates; }

//     public Set<Performer> getPerformers() { return performers; }

//     public void setPerformers(Set<Performer> performers) { this.performers = performers; }

//     @Override
//     public int hashCode() {
//         return new HashCodeBuilder(17, 37).append(title).hashCode();
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj) return true;
//         if (obj == null) return false;
//         if (!(obj instanceof Concert)) return false;

//         Concert concert = (Concert) obj;

//         return new EqualsBuilder().append(title, concert.title).isEquals();
//     }
// }




// package proj.concert.service.domain;

// import java.time.LocalDateTime;
// import java.util.Collections;
// import java.util.HashSet;
// import java.util.Set;

// import javax.persistence.*;

// import org.apache.commons.lang3.builder.EqualsBuilder;
// import org.apache.commons.lang3.builder.HashCodeBuilder;

// public class Concert{

//     // TODO Implement this class.

//     public Set<LocalDateTime> getDates() {
//         return null;
//     }
// }

package proj.concert.service.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import proj.concert.common.dto.ConcertDTO;
import proj.concert.common.dto.PerformerDTO;
import proj.concert.common.jackson.LocalDateTimeDeserializer;
import proj.concert.common.jackson.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "CONCERT")
public class Concert{

    @Id
    @GeneratedValue
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "CONCERT_ID", unique = true)
    private Long id;

    // @Column(name = "TITLE")
    private String title;
    
    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(name = "BLURB", length=1024)
    private String blrb;

	// @ElementCollection
	// @CollectionTable(name = "CONCERT_DATE", joinColumns = @JoinColumn(name = "RID"))\

	// @Column(name = "DATE")
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // private Set<LocalDateTime> dates;

    @ElementCollection
    @CollectionTable(name = "CONCERT_DATE", joinColumns =@JoinColumn(name = "CONCERT_ID"))
	@Column(name = "DATE")
	private Set<LocalDateTime> dates;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @org.hibernate.annotations.Fetch(
            FetchMode.SUBSELECT
    )
	@JoinTable(name = "CONCERT_PERFORMER",
			joinColumns = @JoinColumn(name = "CONCERT_ID"),
			inverseJoinColumns = @JoinColumn(name = "PERFORMER_ID"))
    @Column(name = "PERFORMER")
    private Set<Performer> performers;

    // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JoinColumn(name = "PERFORMER_ID")

    // @Column(name = "PERFORMER")
    // @JsonProperty("performer")
    // private Set<Performer> performers;

    // @ElementCollection
    // @CollectionTable(name = "CONCERT_PERFORMER", joinColumns =@JoinColumn(name = "CONCERT_ID"))
    // @OneToMany
	// @JoinTable(name = "CONCERT_PERFORMER",
	// 		joinColumns = @JoinColumn(name = "CONCERT_ID"),
	// 		inverseJoinColumns = @JoinColumn(name = "PERFORMER_ID"))
	// @Column(name = "performer")
    // @JsonProperty("performer")
	// private List<Performer> performers;

    // @OneToMany(cascade = CascadeType.ALL)
    // // @JoinColumn(name="PERFORMER_ID")
    // @JoinTable(name = "CONCERT_PERFORMER",
    //         joinColumns = @JoinColumn(name = "CONCERT_ID"),
    //         inverseJoinColumns = @JoinColumn(name = "PERFORMER_ID"))
    // @JsonProperty("performer")
    // private List<Performer> performers;

    public Concert(Long id, String title, String imageName, String blurb) {
        this.id = id;
        this.title = title;
        this.imageName = imageName;
        this.blrb = blurb;
    }

    public Concert(String title, String imageName) {
        this.title = title;
        this.imageName = imageName;
    }

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
        return blrb;
    }

    public void setBlurb(String blrb) {
        this.blrb = blrb;
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
		return new ConcertDTO(id, title, imageName, blrb);
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