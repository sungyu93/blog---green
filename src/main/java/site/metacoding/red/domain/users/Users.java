package site.metacoding.red.domain.users;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.red.dto.request.users.UpdateDto;

@Getter
@NoArgsConstructor
public class Users {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Timestamp createdAt;
	
	public Users(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public void update(UpdateDto updateDto) {
		this.password = password;
		this.email = email;
	}
	
	
	
}
