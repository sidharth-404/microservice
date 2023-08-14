package com.authserver.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class HomeController {
	@GetMapping("/message")
	public String greet()
	{
		return "Hello from us";
	}

	@GetMapping("/user")
    public String greetUser() {
        return "Hello from User";
    }

    @GetMapping("/admin")
    public String greetAdmin() {
        return "Hello from Admin";
    }
}
