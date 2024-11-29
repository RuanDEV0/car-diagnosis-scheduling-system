package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "tb_client")
public class Client {
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
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Scheduling> schedulingList;
}
