package proj.concert.service.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.*;

import proj.concert.common.dto.UserDTO;

@Entity
@Table(name = "USERS")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password; 

    // @Column(name = "VERSION")
    @Version
    private Long version;
    
    @Column(name = "COOKIE")
    private String cookie;

    @OneToMany(cascade ={CascadeType.PERSIST,CascadeType.REMOVE}, mappedBy = "user")
    @Fetch(FetchMode.SUBSELECT)
    private Set<Booking> bookings = new HashSet<>();

    // @Column(name = "COOKIE")
    // private String cookie;

    // public User(String username, String password) {
	// 	this.username = username;
	// 	this.password = password;
	// }

    public User() {
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getUsername() {
		return username;
    }

	public void setUsername(String username) {
		this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    // public UserDTO convertToDTO() {
	// 	return new UserDTO(username, password);
	// }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Performer))
            return false;
        if (obj == this)
            return true;

        User rhs = (User) obj;
        return new EqualsBuilder().
                append(username, rhs.username).append(password,rhs.password).
                isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(username).append(password).hashCode();
    }
}
