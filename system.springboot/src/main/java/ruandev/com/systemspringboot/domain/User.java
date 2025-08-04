package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "name is empty")
    private String name;
    @Column(unique = true)
    @NotEmpty(message = "phone is empty")
    private String phone;
    @Column(unique = true)
    private String email;
    @NotEmpty(message = "password is empty")
    private String password;
    @NotEmpty(message = "roles is empty")
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private List<Role> roles;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Scheduling> schedulingList;
}
