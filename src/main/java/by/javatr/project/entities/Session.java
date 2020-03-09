package by.javatr.project.entities;

public final class Session {
    private User user;
    private static Session instance;

    private Session() {
    }

    public static synchronized Session getInstance() {
        if( instance == null ) {
            instance = new Session();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
