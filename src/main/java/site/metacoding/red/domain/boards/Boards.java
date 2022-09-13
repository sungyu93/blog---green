package site.metacoding.red.domain.boards;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.dto.request.boards.UpdateDto;

@Setter
@Getter
public class Boards {
	private Integer id;
	private String title;
	private String content;
	private Integer usersId;
	private Timestamp createdDt; // At 시분초 다 표현할 때, Dt는 년월일만 표현할 때
	
	public Boards(String title, String content, Integer usersId) {
		this.title = title;
		this.content = content;
		this.usersId = usersId;
	}
	
	public void update(UpdateDto updateDto) {
		this.title = updateDto.getTitle();
		this.content = updateDto.getContent();
	}
	
	
	

}
