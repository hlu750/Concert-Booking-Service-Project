package proj.concert.service.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import proj.concert.common.dto.UserDTO;

@Entity
@Table(name = "USERS")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password; 

    @Column(name = "VERSION")
    @Version
    private Long version;

    @Column(name = "COOKIE")
    private String cookie;

    public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

    public User() {
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

    public UserDTO convertToDTO() {
		return new UserDTO(username, password);
	}
    
}
