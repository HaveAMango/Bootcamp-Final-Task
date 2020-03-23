package lv.accenture.bootcamp.rardb.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
//@Service
//public class UserService {
//
//    private UserRepository userRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository,
//                       BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    public User findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public User findUserByUserName(String userName) {
//        return userRepository.findByUserName(userName);
//    }
//
//    public User saveUser(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setActive(true);
//        return userRepository.save(user);
//    }
//
//}
=======

@Service
public class UserService {

	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
      System.out.println("working");
        return userRepository.save(user);
    }

}

>>>>>>> 8600fa8ab9b40f51fd49783ff76d273612e4b686
