package ruandev.com.systemspringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ruandev.com.systemspringboot.domain.Client;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.domain.Service;
import ruandev.com.systemspringboot.domain.Vehicle;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePostRequestBody;
import ruandev.com.systemspringboot.request.Vehicle.VehiclePutRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPostRequestBody;
import ruandev.com.systemspringboot.request.client.ClientPutRequestBody;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPostRequestBody;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPutRequestBody;
import ruandev.com.systemspringboot.request.service.ServicePostRequestBody;
import ruandev.com.systemspringboot.request.service.ServicePutRequestBody;

@Mapper
public abstract class SystemMapper {
    public static final SystemMapper INSTANCE = Mappers.getMapper(SystemMapper.class);

    public abstract Vehicle toVehicle(VehiclePostRequestBody vehiclePostRequestBod);
    public abstract Vehicle toVehicle(VehiclePutRequestBody vehiclePutRequestBody);

    public abstract Scheduling toScheduling(SchedulingPostRequestBody schedulingPostRequestBody);
    public abstract Scheduling toScheduling(SchedulingPutRequestBody schedulingPutRequestBody);

    public abstract Client toClient(ClientPostRequestBody clientPostRequestBody);
    public abstract Client toClient(ClientPutRequestBody clientPutRequestBody);

    public abstract Service toService(ServicePostRequestBody servicePostRequestBody);
    public abstract Service toService(ServicePutRequestBody servicePutRequestBody);
}
