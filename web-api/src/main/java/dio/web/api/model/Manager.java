package dio.web.api.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tab_manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manager")
    private Integer idManager;
    @Column(length = 50, nullable = false)
    private String login;
    @Column(length = 100, nullable = false)
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tab_manager_roles", joinColumns = @JoinColumn(name = "manager_id"))
    @Column(name = "role_id")
    private List<String> roles = new ArrayList<>();


    public Manager(String login, String password){
        this.login = login;
        this.password = password;
    }

    public Manager() {

    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + idManager +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getIdManager() {
        return idManager;
    }

    public void setIdManager(Integer id) {
        this.idManager = id;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
