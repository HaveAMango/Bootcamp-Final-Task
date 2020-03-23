package lv.accenture.bootcamp.rardb.login;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        User user = userService.findUserByUserName(userName);
//        return buildUserForAuthentication(user);
//    }
//
//
//    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//                user.getActive(), true, true, true);
//    }
//}
=======

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	System.out.println("User details service called: " + userName);
        User user = userService.findUserByUserName(userName);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));        
        return buildUserForAuthentication(user, authorities);
    }


    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                true, true, true, true, authorities);
    }
}

>>>>>>> 8600fa8ab9b40f51fd49783ff76d273612e4b686
