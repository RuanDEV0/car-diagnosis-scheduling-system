package ruandev.com.systemspringboot.request.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicoPostRequestBody {
    private String name;
    private String description;
    private Double valueBasic;
}