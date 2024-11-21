package SpringBoot.Management_System.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Fill the name field")
    @Size(min = 3,max = 15,message = "Type name in valid range ")
    private String name;

    @Min(value=18,message = "Age must be above 18")
    @Max(value = 55)
    @Column(nullable = false)
    private Integer age;

    @Email(message = "Enter a valid email")
    @NotBlank(message = "Fill the email field")
    private String email;

    @Column(name = "contact_no", nullable = false, unique = true)
    @Size(min = 10, max = 10, message = "Contact number must be 10 digits")
    @Pattern(regexp = "\\d{10}", message = "Contact number must contain only digits")
    private String contactNo;




    @Column(nullable = false)
    private Boolean isActive;

    @Positive(message = "salary is not negative")
    @NotNull(message = "salary should not be null")
    private Double salary;




    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    private DepartmentEntity managedDepartment;

    @ManyToOne
    @JoinColumn (name = "worker_department_id")
    @JsonIgnore
    private DepartmentEntity workerDepartment;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "freelance_department",
    joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "department_id"))
    @JsonIgnore
    private Set<DepartmentEntity> freelanceDepartments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

}
