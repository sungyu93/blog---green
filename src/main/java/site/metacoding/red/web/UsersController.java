package site.metacoding.red.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.service.UsersService;

@RequiredArgsConstructor
@Controller
public class UsersController {
	
	private final UsersService usersService;
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "users/joinForm";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "users/joinForm";
	}

	
	
}
