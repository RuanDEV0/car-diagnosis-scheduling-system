package ruandev.com.systemspringboot.request.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicePutRequestBody {
    private Long id;
    private String name;
    private String description;
    private double valueBasic;
}
