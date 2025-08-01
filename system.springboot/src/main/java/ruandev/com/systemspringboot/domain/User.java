package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.relation.Role;
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
    private Set<Role> roles;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Scheduling> schedulingList;
}
