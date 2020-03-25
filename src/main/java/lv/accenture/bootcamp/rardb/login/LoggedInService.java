package lv.accenture.bootcamp.rardb.login;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoggedInService {

	public boolean loggedIn () {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean loggedIn = hasUserRole(auth.getAuthorities());
		return loggedIn;
	}
	
	private boolean hasUserRole(Collection<? extends GrantedAuthority> authorities) {
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals("USER")) {
				return true;
			}
		}
		
		return false;
	}
}

