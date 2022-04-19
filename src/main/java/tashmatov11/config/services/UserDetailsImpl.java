package tashmatov11.config.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tashmatov11.db.models.userClasses.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.List;

@Getter @Setter
public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String email;

  @JsonIgnore
  private String password;


  private String firstName;


  private List<? extends GrantedAuthority> authorities;

  private boolean isAccountNonExpired = true;
  private boolean isAccountNonLocked = true;
  private boolean isCredentialsNonExpired = true;
  private boolean isEnabled = true;

  public UserDetailsImpl(Long id, String email, String password,
                         List<? extends GrantedAuthority> authorities,
                         String firstName) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
    this.firstName = firstName;
  }

  public static UserDetailsImpl build(User user) {
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName().name());

    return new UserDetailsImpl(
        user.getId(), 
        user.getEmail(),
        user.getPassword(),
            Collections.singletonList(authority),
            user.getFirstName()
            );
  }


  @Override
  public String getUsername() {
    return email;
  }
}
