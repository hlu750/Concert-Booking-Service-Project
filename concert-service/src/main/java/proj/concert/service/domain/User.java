package proj.concert.service.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import proj.concert.common.dto.UserDTO;

@Entity
@Table(name = "USER")
public class User {
    
    @Column(name = "USERNAME")
    @JsonProperty("username")
	private String username;

    @Column(name = "PASSWORD")
    @JsonProperty("password")
    private String password; 

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
