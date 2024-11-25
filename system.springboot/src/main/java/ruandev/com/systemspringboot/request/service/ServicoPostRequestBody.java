package ruandev.com.systemspringboot.request.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicoPostRequestBody {
    private String name;
    private String shortDescription;
    private Double valueBasic;
}
