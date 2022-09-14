package site.metacoding.red.domain.boards;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import site.metacoding.red.dto.response.MainDto;
import site.metacoding.red.dto.response.PagingDto;


public interface BoardsDao {
	public PagingDto paging(@Param("page")Integer id, @Param("keyword")String keyword);
	public void insert(Boards boards); // save로 대체 가능
	public List<MainDto> findAll(@Param("stratNum")int startNum, @Param("keyword")String keyword); // selectAll로 대체 가능
	public Boards findById(Integer id);
	public void update(Boards boards);
	public void deleteById(Integer id);
	public void updateByUsersId(Integer usersId);
}
