package ruandev.com.systemspringboot.dto.service;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ServicoPutDto {
    private Long id;
    private String name;
    private String shortDescription;
    private Double valueBasic;
    private String description;
}
