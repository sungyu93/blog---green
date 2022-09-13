package site.metacoding.red.dto.request.boards;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.domain.boards.Boards;

@Setter
@Getter
public class UpdateDto {
	private String title;
	private String content;
}
