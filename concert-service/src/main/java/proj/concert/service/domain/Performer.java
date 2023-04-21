package proj.concert.service.domain;

import proj.concert.common.dto.PerformerDTO;
import proj.concert.common.types.Genre;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.*;

import java.util.List;
import java.util.Set;

import javax.persistence.*; 

@Entity
@Table(name = "PERFORMER")
public class Performer {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERFORMER_ID", unique = true)
    @JsonProperty("id")
    private Long id;

    @Column(name = "NAME")
    @JsonProperty("name")
    private String name;

    @Column(name = "IMAGENAME")
    @JsonProperty("imageName")
    private String imageName;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE")
    @JsonProperty("genre")
    private Genre genre;

    @Column(name = "BLURB")
    @JsonProperty("blurb")
    private String blurb;

    // @ManyToOne
    // @JoinTable(name = "CONCERT_PERFORMER", 
    //         joinColumns = @JoinColumn(name = "CONCERT_ID"),
    //         inverseJoinColumns = @JoinColumn(name = "PERFORMER_ID"))
    // private Set<Concert> concerts;

    public Performer() { }

    public Performer(Long id, String name, String imageName, Genre genre, String blurb) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
        this.genre = genre;
        this.blurb = blurb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public PerformerDTO convertToDTO() {
		return new PerformerDTO(id, name, imageName, genre, blurb);
	}

    // @Override
    // public String toString() {
    //     StringBuffer buffer = new StringBuffer();
    //     buffer.append("Performer, id: ");
    //     buffer.append(id);
    //     buffer.append(", name: ");
    //     buffer.append(name);
    //     buffer.append(", s3 image: ");
    //     buffer.append(imageName);
    //     buffer.append(", blurb: ");
    //     buffer.append(blurb);
    //     buffer.append(", genre: ");
    //     buffer.append(genre.toString());

    //     return buffer.toString();
    // }

    // @Override
    // public boolean equals(Object obj) {
    //     if (!(obj instanceof Performer))
    //         return false;
    //     if (obj == this)
    //         return true;

    //     Performer rhs = (Performer) obj;
    //     return new EqualsBuilder().
    //             append(name, rhs.name).
    //             isEquals();
    // }

    // @Override
    // public int hashCode() {
    //     return new HashCodeBuilder(17, 31).
    //             append(name).hashCode();
    // }
}