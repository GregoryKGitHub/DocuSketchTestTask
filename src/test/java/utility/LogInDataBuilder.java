package utility;

public class LogInDataBuilder {
    private String email;
    private String password;

    public String getEmail()    {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LogInDataBuilder email(String val) {
        email = val;
        return this;
    }

    public LogInDataBuilder password(String val) {
        password = val;
        return this;
    }

    public LogInData build() {
        return new LogInData(this);
    }
}
