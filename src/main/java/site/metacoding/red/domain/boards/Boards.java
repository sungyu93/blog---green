package site.metacoding.red.domain.boards;

import java.security.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Boards {
	private Integer id;
	private String title;
	private String content;
	private String usersId;
	private Timestamp createdDt; // At 시분초 다 표현할 때, Dt는 년월일만 표현할 때
}
