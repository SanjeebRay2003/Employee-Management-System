package SpringBoot.Management_System.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Department")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Fill the tittle field")
    @Size(min = 2,max = 15,message = "Type tittle in valid range ")
    @Column(unique = true)
    private String tittle;

    @OneToOne
    @JoinColumn(name = "department_manager")
    private EmployeeEntity manager;

    @OneToMany(mappedBy = "workerDepartment",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<EmployeeEntity> workers;

    @ManyToMany(mappedBy = "freelanceDepartments",cascade = CascadeType.ALL)
    private Set<EmployeeEntity> freelancers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(tittle, that.tittle);
    }


}
