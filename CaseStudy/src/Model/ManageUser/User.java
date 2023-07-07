package Model.ManageUser;

public class User {
    private String accountName;
    private String password;

    public User(String text, String password) {
        this.accountName = text;
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account name : " + this.accountName + " Password : " + this.password + "\n";
    }
}
