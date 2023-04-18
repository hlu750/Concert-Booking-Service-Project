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

import proj.concert.common.jackson.LocalDateTimeDeserializer;
import proj.concert.common.jackson.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "CONCERT")
public class Concert implements Comparable<Concert> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonProperty("id")
    private Long id;

    @Column(name = "TITLE")
    @JsonProperty("title")
    private String title;

    @Column(name = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PERFORMER_ID")
    @JsonProperty("performer")
    private Performer performer;

    public Concert(Long id, String title, LocalDateTime date, Performer performer) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.performer = performer;
    }

    public Concert(String title, LocalDateTime date, Performer performer) {
        this(null, title, date, performer);
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
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime getDate() {
        return date;
    }

    public Set<LocalDateTime> getDates() {
        return null;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @JsonIgnore
    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    public Performer getPerformer() {
        return performer;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Concert, id: ");
        buffer.append(id);
        buffer.append(", title: ");
        buffer.append(title);
        buffer.append(", date: ");
        buffer.append(date.toString());
        buffer.append(", featuring: ");
        buffer.append(performer.getName());

        return buffer.toString();
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

    @Override
    public int compareTo(Concert concert) {
        return title.compareTo(concert.getTitle());
    }
}