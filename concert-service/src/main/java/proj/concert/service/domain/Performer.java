// package proj.concert.service.domain;

// import javax.persistence.*;

// import org.apache.commons.lang3.builder.EqualsBuilder;
// import org.apache.commons.lang3.builder.HashCodeBuilder;
// import proj.concert.common.types.Genre;

// /**
//  * Domain class to represent performers.
//  * <p>
//  * A Performer describes a performer in terms of:
//  * id         the unique identifier for a performer.
//  * name       the performer's name.
//  * imageName  the name of an image file for the performer.
//  * genre      the performer's genre.
//  * blurb      the performer's description.
//  */
// @Entity
// @Table(name = "PERFORMERS")
// public class Performer {

//     @Id
//     @GeneratedValue
//     private Long id;

//     private String name;

//     @Column(name = "IMAGE_NAME")
//     private String imageName;

//     @Enumerated(EnumType.STRING)
//     private Genre genre;

//     @Column(length = 1024)
//     private String blurb;

//     public Performer() {

//     }

//     public Performer(long id, String name, String imageName, Genre genre, String blurb) {
//         this.id = id;
//         this.name = name;
//         this.imageName = imageName;
//         this.genre = genre;
//         this.blurb = blurb;
//     }

//     public long getId() { return id; }

//     public void setId(long id) { this.id = id; }

//     public String getName() { return name; }

//     public void setName(String name) { this.name = name; }

//     public String getImageName() { return imageName; }

//     public void setImageName(String imageName) { this.imageName = imageName; }

//     public Genre getGenre() { return genre; }

//     public void setGenre(Genre genre) { this.genre = genre; }

//     public String getBlurb() { return blurb; }

//     public void setBlurb(String blurb) { this.blurb = blurb; }

//     @Override
//     public int hashCode() {
//         return new HashCodeBuilder(17, 37).
//                 append(name).hashCode();
//     }

//     @Override
//     public boolean equals(Object obj) {

//         if (this == obj) return true;
//         if (obj == null) return false;
//         if (!(obj instanceof Performer)) return false;

//         Performer performer = (Performer) obj;

//         return new EqualsBuilder().append(name, performer.name).isEquals();
//     }
// }






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
    @GeneratedValue
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "PERFORMER_ID", unique = true)
    private Long id;

    // @Column(name = "NAME")
    private String name;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Enumerated(EnumType.STRING)
    // @Column(name = "GENRE")
    private Genre genre;

    // @Column(name = "BLURB")
    @Column(length = 1024)
    private String blurb;

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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Performer))
            return false;
        if (obj == this)
            return true;

        Performer rhs = (Performer) obj;
        return new EqualsBuilder().
                append(name, rhs.name).
                isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(name).hashCode();
    }
}