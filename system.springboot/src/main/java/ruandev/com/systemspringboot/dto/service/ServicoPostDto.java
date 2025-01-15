package ruandev.com.systemspringboot.dto.service;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ServicoPostDto {
    private String name;
    private String shortDescription;
    private Double valueBasic;
    private String description;
}
