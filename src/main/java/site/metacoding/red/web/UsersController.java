package site.metacoding.red.web;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.dto.request.users.UpdateDto;
import site.metacoding.red.dto.request.users.joinDto;
import site.metacoding.red.dto.request.users.loginDto;
import site.metacoding.red.service.UsersService;
import site.metacoding.red.util.Script;

@RequiredArgsConstructor
@Controller
public class UsersController {

	private final UsersService usersService;
	private final HttpSession session;

	@GetMapping("/joinForm")
	public String joinForm() {
		return "users/joinForm";
	}

	@GetMapping("/loginForm")
	public String loginForm() { // 쿠키 배워보기
		return "users/loginForm";
	}

	@PostMapping("/join")
	public String join(joinDto joinDto) {
		usersService.회원가입(joinDto);
		return "redirect:/loginForm";
	}

	@PostMapping("/login")
	public @ResponseBody String join(loginDto loginDto) {
		Users principal = usersService.로그인(loginDto);
		
		if (principal != null) { // if-else문 사용할 때는 잘 안 된 걸 if-else 문 안에 넣고, 잘 된 건 밖으로 빼야 좋은 코드다.
			return Script.back("아이디 혹은 비밀번호가 틀렸습니다");
		}else { // login이 안 되면 "lgoin을 다시 
		}
		session.setAttribute("principal", principal);
		return Script.href("/"); //msg를 주면 또 한 번 더 클릭을 해야 하니까 귀찮다! 그냥 주소만 주자!
	}
	
	@GetMapping("/users/{id}")
	public String updateForm(@PathVariable Integer id, Model model) {
		Users usersPs = usersService.회원정보보기(id);
		model.addAttribute("users", usersPs);
		return "users/updateForm";
	}
	
	@PutMapping("/users/{id}")
	public String update(@PathVariable Integer id, UpdateDto updateDto) {
		usersService.회원수정(id, updateDto);
		return "redirect:/users/" +id;
	}
	
	@DeleteMapping("/users/{id}")
	public @ResponseBody String delete(@PathVariable Integer id) {
		usersService.회원탈퇴(id);
		return Script.href("/loginForm", "회원탈퇴가 완료되었습니다");
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/loginForm";
	}

}
