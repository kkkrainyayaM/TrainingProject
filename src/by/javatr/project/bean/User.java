package by.javatr.project.bean;

import by.javatr.project.dao.IDGenerator;

import java.util.Objects;

public class User {
    private int id;
    private User type;
    private String name;
    private String login;
    private String password;

    public User(User type,String name, String login, String password) {
        this.id = IDGenerator.getInstance().getIDUser();
        this.name = name;
        this.type = type;
        this.login = login;
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public User getType() {
        return type;
    }

    public void setType(User type) {
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
        if( (o.getClass()!= User.class) ) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getType().equals( user.getType() ) &&
                getLogin().equals( user.getLogin() ) &&
                getPassword().equals( user.getPassword() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( getId(), getType(), getLogin(), getPassword() );
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", type=" + type +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}

