package com.syntaxerror.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.crud.entity.Users;
import com.syntaxerror.crud.repository.UserRepository;
import com.syntaxerror.crud.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Users> getAllUsers() {
		return (List<Users>) userRepository.findAll();
	}

	@Override
	public Users getUserById(int userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public Users addOrUpdateUser(Users user) {
		return userRepository.save(user);
	}

	@Override
	public Users deleteUser(int userId) throws Exception {
		Users deletedUsers = null;
		try {

			deletedUsers = userRepository.findById(userId).orElse(null);
			if (deletedUsers == null) {
				throw new Exception("user not available");
			} else {
				userRepository.deleteById(userId);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return deletedUsers;
	}

}
