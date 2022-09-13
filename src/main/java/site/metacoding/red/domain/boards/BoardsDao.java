package site.metacoding.red.domain.boards;

import java.util.List;

public interface BoardsDao {

	public void insert(Boards boards); // save로 대체 가능
	public List<Boards> findAll(); // selectAll로 대체 가능
	public Boards findById(Integer id);
	public void update(Boards boards);
	public void deleteById(Integer id);
	public void updateByUsersId(Integer id);
}
