package ruandev.com.systemspringboot.request.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServicePostRequestBody {
    private String nome;
    private String desc;
    private double precoBase;
}