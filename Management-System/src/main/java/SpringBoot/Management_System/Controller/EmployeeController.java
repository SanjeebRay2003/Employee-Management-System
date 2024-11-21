package SpringBoot.Management_System.Controller;

import SpringBoot.Management_System.Entities.EmployeeEntity;
import SpringBoot.Management_System.Services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping
    public List<EmployeeEntity> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody @Valid EmployeeEntity employeeEntity){
        return employeeService.createNewEmployee(employeeEntity);
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeEntity> updateEmployeeById(@RequestBody  @Valid Map<String,Object> updates,
                                                                 @PathVariable Long employeeId){
        EmployeeEntity employee= employeeService.updateEmployeeById(employeeId,updates);
        if (employee == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employee); // this is an Else Statement

    }




    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId ){
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }




}
