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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONCERT_ID", unique = true)
    @JsonProperty("id")
    private Long id;

    @Column(name = "TITLE")
    @JsonProperty("title")
    private String title;
    
    @Column(name = "IMAGENAME")
    @JsonProperty("imageName")
    private String imageName;

    @Column(name = "BLURB")
    @JsonProperty("blurb")
    private String blrb;

	// @ElementCollection
	// @CollectionTable(name = "CONCERT_DATE", joinColumns = @JoinColumn(name = "RID"))\

	// @Column(name = "DATE")
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // private Set<LocalDateTime> dates;

    @ElementCollection
    @CollectionTable(name = "CONCERT_DATE", joinColumns =@JoinColumn(name = "CONCERT_ID"))
	@Column(name = "date")
    // @JsonProperty("date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Set<LocalDateTime> dates;
    
    // @ManyToMany
	// @JoinTable(name = "CONCERT_PERFORMER",
	// 		joinColumns = @JoinColumn(name = "CID"),
	// 		inverseJoinColumns = @JoinColumn(name = "PID"))
    // @Column(name = "PERFORMER_ID")
    // @JsonProperty("performer")
    // private Set<Performer> performers;

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

    @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name="PERFORMER_ID")
    @JoinTable(name = "CONCERT_PERFORMER",
            joinColumns = @JoinColumn(name = "CONCERT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERFORMER_ID"))
    @JsonProperty("performer")
    private List<Performer> performers;

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

    public List<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    public ConcertDTO convertToDTO() {
		return new ConcertDTO(id, title, imageName, blrb);
	}

    // @Override
    // public String toString() {
    //     StringBuffer buffer = new StringBuffer();
    //     buffer.append("Concert, id: ");
    //     buffer.append(id);
    //     buffer.append(", title: ");
    //     buffer.append(title);
    //     buffer.append(", imageName: ");
    //     buffer.append(imageName);
    //     buffer.append(", blurb: ");
    //     buffer.append(blrb);
    //     buffer.append(", date: ");
    //     buffer.append(dates.toString());
    //     buffer.append(", featuring: ");
    //     buffer.append(performers);

    //     return buffer.toString();
    // }

    // @Override
    // public boolean equals(Object obj) {
    //     if (!(obj instanceof Concert))
    //         return false;
    //     if (obj == this)
    //         return true;

    //     Concert rhs = (Concert) obj;
    //     return new EqualsBuilder().
    //             append(title, rhs.title).
    //             isEquals();
    // }

    // @Override
    // public int hashCode() {
    //     return new HashCodeBuilder(17, 31).
    //             append(title).hashCode();
    // }

    // @Override
    // public int compareTo(Concert concert) {
    //     return title.compareTo(concert.getTitle());
    // }
}