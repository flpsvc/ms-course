package com.springms.hruser.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springms.hruser.entity.User;
import com.springms.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
			
		@Autowired
		private UserRepository repository;
		
		
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<User> findById(@PathVariable Long id){		
			
			User UserId = repository.findById(id).get();
			
			return ResponseEntity.ok(UserId);
		}
		
		@GetMapping(value = "/search")
		public ResponseEntity<User> findByEmail(@RequestParam String email){		
			
			User user = repository.findByEmail(email);
			
			if(!(repository.findByEmail(email) == null)) {
				return ResponseEntity.ok(user);
			}
			else {
				return ResponseEntity.status(404).build();
			}
			
			/*else if(repository.findByEmail(email).equals(null)) {
				return ResponseEntity.status(202).build();
			}
			
			else {
				return ResponseEntity.status(500).build();
			}*/
			
			
		}
	
}
