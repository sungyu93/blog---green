package site.metacoding.red.dto.request.users;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.domain.users.Users;

@Getter
@Setter
public class joinDto {
	private String username;
	private String password;
	private String email;
	
	public Users toEntity(){
		Users users = new Users(this.username, this.password, this.email);
		return users;
	}
}
