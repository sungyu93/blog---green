package site.metacoding.red.domain.users;

import java.util.List;

import site.metacoding.red.domain.boards.Boards;
import site.metacoding.red.dto.request.users.loginDto;

public interface UsersDao {
	public void insert(Users users); // save로 대체 가능
	public List<Users> findAll(); // selectAll로 대체 가능
	public Users findById(Integer id);
	public void update(Users users);
	public void deleteById(Integer id);
	public Users findByUsername(String username);
}
