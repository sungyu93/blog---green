package site.metacoding.red.service;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.boards.BoardsDao;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.dto.request.users.UpdateDto;
import site.metacoding.red.dto.request.users.joinDto;
import site.metacoding.red.dto.request.users.loginDto;

@Service
@RequiredArgsConstructor
public class UsersService {
	
	private final UsersDao usersDao;
	private final BoardsDao boardsDao;
	
	public void 회원가입(joinDto joinDto) { // username, password, email 
		// 1. 디티오를 엔티티로 변경하는 코드
		Users users = joinDto.toEntity();
		// 2. 엔티티로 디비 수행
		usersDao.insert(users);
	}
	
	public Users 로그인(loginDto loginDto) { // username, password
		Users usersPs = usersDao.findByUsername(loginDto.getUsername());
		// if로 usersPs의 password와 디티오 password 비교
		if(usersPs.getPassword().equals(loginDto.getPassword())) {
			return usersPs;
		}else {
			return null;
		}
	} 
	
	public void 회원수정(Integer id, UpdateDto updateDto) { // id, 디티오(password, email)
		// 1. 영속화
		Users usersPs = usersDao.findById(id);
		// 2. 영속화된 객체 변경
		usersPs.update(updateDto);
		// 3. 디비 수행
		usersDao.update(usersPs);
	}
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void 회원탈퇴(Integer id) { // usersId 
		usersDao.deleteById(id);
		boardsDao.updateByUsersId(id);
		
	} // users-delete, boards-update
	
	public boolean 유저네임중복확인(String username) {
		Users usersPs = usersDao.findByUsername(username);
		if(usersPs == null) { // 있으면 true, 없으면  false
			return false;
		}else {
			return true;
		}
	} 
	
	public Users 회원정보보기(Integer id) {
		Users usersPs = usersDao.findById(id);
		return usersPs;
	}

}
