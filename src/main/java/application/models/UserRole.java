package application.models;

public enum UserRole {

    USER(UserAuthority.READ, UserAuthority.WRITE),
    ADMIN(UserAuthority.READ, UserAuthority.WRITE, UserAuthority.DELETE, UserAuthority.ADD);

    public final UserAuthority[] AUTHORITIES;

    UserRole(UserAuthority... authorities) {
        AUTHORITIES = authorities;
    }

}
