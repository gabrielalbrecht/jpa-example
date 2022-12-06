package br.com.example.model.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Getter
@Setter
@Entity
@Table(name = "tb_person")
public class PersonDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id", nullable = false)
    private Long personId;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private Calendar birthDate;

    @Column(name = "document_number", nullable = false, unique = true, length = 15)
    private String documentNumber;

    @Column(name = "phone_number", nullable = false, length = 11)
    private String phoneNumber;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Temporal(TemporalType.DATE)
    @Column(name = "registered_date", nullable = false, updatable = false)
    private Calendar registeredDate = Calendar.getInstance();

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_date")
    private Calendar updatedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "deleted_date")
    private Calendar deletedDate;
}
