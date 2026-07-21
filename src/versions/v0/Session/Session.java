package versions.v0.Session;

import versions.v0.Model.User;

public class Session {
    private User currentUser;

    public void login(User currentUser){
        this.currentUser = currentUser;
    }
    public void logout(){
        currentUser = null;

    }
    public boolean isLoggenIn(){
        return currentUser != null;
    }
    public User getCurrentUser(){
        return currentUser;
    }
}
