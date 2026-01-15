	package com.example.Travelweb.controller;
	
	import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Travelweb.entity.TravelEntity;
import com.example.Travelweb.repository.TravelRepository;


	@Controller
	public class TravelController{

		    private final TravelRepository travelRepository;
		    private final PasswordEncoder passwordEncoder;

		    public TravelController(TravelRepository travelRepository,
		                            PasswordEncoder passwordEncoder){
		        this.travelRepository = travelRepository;
		        this.passwordEncoder = passwordEncoder;
		    }
		    
	    @GetMapping("/signup")
	    public String signupPage(){
	        return "signup";
	    }
	    
	    @GetMapping("/signin")
	    public String signinPage() {
	        return "signin";
	    }
	    
	    @PostMapping("/signup")
	    public String signup(@ModelAttribute TravelEntity user,@RequestParam("confirmpass")String confirmPass){
	    	
	    	if(!user.getPassword().equals(confirmPass)){
	    		return "redirect:/signup?error=password";
	    	}
	    	
	    	user.setPassword(passwordEncoder.encode(user.getPassword()));
	        travelRepository.save(user);
	        return "redirect:/signin?signupSuccess=true";
	    }
	    
	    @GetMapping("/success")
	    public String successPage(){
	        return "index";
	    }
	}


		
	
