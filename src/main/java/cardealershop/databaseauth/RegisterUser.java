package cardealershop.databaseauth;

public class RegisterUser {

  private String email;
  private String login;
  private String password;
  private String name;
  private String lastName;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "RegisterUser{" +
        "email='" + email + '\'' +
        ", login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", name='" + name + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
