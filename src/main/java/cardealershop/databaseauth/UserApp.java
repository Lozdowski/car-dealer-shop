package cardealershop.databaseauth;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserApp {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;
  private String login;
  private String password;
  private String name;
  private String lastName;
  private int active;

  @ManyToMany(
  fetch = FetchType.EAGER)
  @JoinTable(name = "user_role",
      joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public UserApp(UserApp userApp) {
    this.email = userApp.getEmail();
    this.login = userApp.getLogin();
    this.password = userApp.getPassword();
    this.name = userApp.getName();
    this.lastName = userApp.getLastName();
    this.active = userApp.getActive();
    this.roles = userApp.getRoles();
  }

  public UserApp() { }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "UserApp{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", name='" + name + '\'' +
        ", lastName='" + lastName + '\'' +
        ", active=" + active +
     //   ", roles=" + roles +
        '}';
  }
}
