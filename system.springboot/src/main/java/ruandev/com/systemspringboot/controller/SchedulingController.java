package ruandev.com.systemspringboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruandev.com.systemspringboot.domain.Scheduling;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPostRequestBody;
import ruandev.com.systemspringboot.request.scheduling.SchedulingPutRequestBody;
import ruandev.com.systemspringboot.request.scheduling.SchedulingUpdateStatusDTO;
import ruandev.com.systemspringboot.service.SchedulingService;
import ruandev.com.systemspringboot.util.StatusType;

@RestController
@RequestMapping(value = "/scheduling")
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

    @GetMapping(value = "/{status}")
    public ResponseEntity<Page<Scheduling>> findByStatus(@PathVariable StatusType status
            , @RequestParam Pageable pageable){
        return ResponseEntity.ok(schedulingService.listByStatus(status, pageable));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Scheduling> findById(@PathVariable Long id){
        return ResponseEntity.ok(schedulingService.findByIdOrThrowBadRequestException(id));
    }
    @PostMapping
    public ResponseEntity<Scheduling> save(@Valid @RequestBody SchedulingPostRequestBody schedulingPostRequestBody){
        return new ResponseEntity<>(schedulingService.save(schedulingPostRequestBody)
                , HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@Valid @RequestBody SchedulingPutRequestBody schedulingPutRequestBody) {
        schedulingService.replace(schedulingPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping(value = "update-status")
    public ResponseEntity<Void> updateStatus(@Valid SchedulingUpdateStatusDTO schedulingUpdateStatusDTO){
        schedulingService.updateStatus(schedulingUpdateStatusDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        schedulingService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
