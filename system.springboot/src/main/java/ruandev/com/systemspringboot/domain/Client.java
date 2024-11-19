package ruandev.com.systemspringboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name is null")
    @NotEmpty(message = "name is empty")
    private String name;
    @Column(unique = true)
    @NotNull(message = "phone is null")
    @NotEmpty(message = "phone is empty")
    private String phone;
    @Column(unique = true)
    private String email;
}
