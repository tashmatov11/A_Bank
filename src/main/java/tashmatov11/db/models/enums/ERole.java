package tashmatov11.db.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum ERole implements GrantedAuthority {
    ROLE_CLIENT,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
