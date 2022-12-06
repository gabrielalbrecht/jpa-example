package br.com.example.model.dao;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;

@NamedNativeQueries({
        @NamedNativeQuery(name = "getAllEmployees", query = "SELECT * FROM tb_employee WHERE email LIKE :email " +
                "ORDER BY :sort ASC", resultClass = EmployeeDAO.class),
        @NamedNativeQuery(name = "countAllEmployees", query = "SELECT COUNT(*) FROM tb_employee WHERE email LIKE " +
                ":email")
})
@Getter
@Setter
@Entity
@Table(name = "tb_employee")
public class EmployeeDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @NotBlank(message = "{validation.email.notBlank}")
    @Email(message = "{validation.email.invalid}")
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @NotBlank(message = "{validation.password.notBlank}")
    @Length(min = 8, message = "{validation.password.invalidLength}")
    @Column(name = "password", nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "admission_date", nullable = false)
    private Calendar admissionDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dismissal_date")
    private Calendar dismissalDate;
}
