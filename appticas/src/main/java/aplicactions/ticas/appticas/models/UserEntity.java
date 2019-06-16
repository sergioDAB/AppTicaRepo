package aplicactions.ticas.appticas.models;

public class UserEntity {
    private Integer id;
    private String user;
    private String password;
    private String userType;

    public UserEntity(Integer id, String user, String password, String userType) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.userType = userType;
    }

    public UserEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


}
