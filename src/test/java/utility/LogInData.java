package utility;

public class LogInData
{
    private final String email;
    private final String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LogInData(LogInDataBuilder builder)   {
        email = builder.getEmail();
        password = builder.getPassword();
    }
}

