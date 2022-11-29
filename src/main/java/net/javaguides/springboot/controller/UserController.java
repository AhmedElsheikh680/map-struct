package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.dto.UserDTO;
import net.javaguides.springboot.error.DuplicateRecordException;
import net.javaguides.springboot.error.RecordNotFoundException;
import net.javaguides.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private UserRepository userRepository;
	private final UserMapper userMapper;

	// get all users
	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers() {

		List<User> users = userRepository.findAll();
		List<UserDTO> userDTOS = userMapper.map(users);
			return ResponseEntity.ok(userDTOS);

	}

	// get user by id
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable (value = "id") long userId) {
		Optional<User> user = this.userRepository.findById(userId);
		if (user.isPresent()){
			user.get();
		}else {
			throw new RecordNotFoundException("This Record With ID: "+ userId + " Not Found!!");
		}
//				.orElseThrow(() -> new EntityNotFoundException("User not found with id :" + userId));
		UserDTO userDTO = userMapper.mapToDTO(user.get());
		return ResponseEntity.ok(userDTO);

	}

	// create user
	@PostMapping("/save")
	public User createUser(@RequestBody @Valid User user) {
		if (!user.getEmail().isEmpty() && user.getEmail() !=null){
			Optional<User> entity = userRepository.findByEmail(user.getEmail());
			if (entity.isPresent()){
				throw new DuplicateRecordException("This Email Already Exist!!");
			} else {
				User userResponse = userRepository.save(user);
			}
		}
		return user;

	}
	
	// update user
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		 User existingUser = this.userRepository.findById(userId).get();
//			.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		 existingUser.setFirstName(user.getFirstName());
		 existingUser.setLastName(user.getLastName());
		 existingUser.setEmail(user.getEmail());
		 return this.userRepository.save(existingUser);
	}
	
	// delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId){
		 User existingUser = this.userRepository.findById(userId).get();
//					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		 this.userRepository.delete(existingUser);
		 return ResponseEntity.ok().build();
	}
}
