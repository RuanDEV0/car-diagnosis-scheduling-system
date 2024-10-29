package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.domain.Service;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPostRequestBody;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPutRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPostRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPutRequestBody;
import ruandev.com.systemspringboot.request.service.ServicePostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicePutRequestBody;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePostRequestBody;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePutRequestBody;

@Mapper
public abstract class SystemMapper {
    public static final SystemMapper INSTANCE = Mappers.getMapper(SystemMapper.class);

    public abstract Vehicle toVeiculo(VehiclePostRequestBody vehiclePostRequestBody);
    public abstract Vehicle toVeiculo(VehiclePutRequestBody vehiclePutRequestBody);

    public abstract Scheduling toAgendamento(SchedulingPostRequestBody schedulingPostRequestBody);
    public abstract Scheduling toAgendamento(SchedulingPutRequestBody schedulingPutRequestBody);

    public abstract Client toCliente(ClientPostRequestBody clientPostRequestBody);
    public abstract Client toCliente(ClientPutRequestBody clientPutRequestBody);

    public abstract Service toServico(ServicePostRequestBody servicePostRequestBody);
    public abstract Service toServico(ServicePutRequestBody servicePutRequestBody);
}
