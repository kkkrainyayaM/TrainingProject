package by.javatr.project.entities;


public class User {
    private int id;
    private UserType type;
    private String name;
    private String login;
    private String password;

    public User(UserType type, String login, String password, String name) {
        //this.id = IDGenerator.getInstance().getIDUser();
        this.name = name;
        this.type = type;
        this.login = login;
        this.password = password;
    }

    public User(int id, UserType type, String login, String password, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if( this == o ) return true;
        if( (o.getClass() != User.class) ) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getType().equals( user.getType() ) &&
                getLogin().equals( user.getLogin() ) &&
                getPassword().equals( user.getPassword() );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + login.hashCode();
        result = prime * result + password.hashCode();
        result = prime * result + type.hashCode();
        result = prime * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Пользователь{" +
                "ID=" + id +
                ", логин='" + login + '\'' +
                ", имя='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}

