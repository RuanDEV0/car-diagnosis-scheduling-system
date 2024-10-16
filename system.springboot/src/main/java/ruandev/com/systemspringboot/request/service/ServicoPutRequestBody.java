package ruandev.com.systemspringboot.request.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicoPutRequestBody {
    private Long id;
    private String nome;
    private String desc;
    private double precoBase;
}
