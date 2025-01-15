package ruandev.com.systemspringboot.dto.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicoPostRequestBody {
    private String name;
    private String shortDescription;
    private Double valueBasic;
    private String description;
}
