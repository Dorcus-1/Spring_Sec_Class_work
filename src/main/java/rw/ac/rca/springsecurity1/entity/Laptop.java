package rw.ac.rca.springsecurity1.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Laptop {
    @Id
    @GeneratedValue
    private int lapId;
    @Column(nullable = false, length = 100)
    private String brand;
    @Column(nullable = false, length = 100)
    private String sn;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

}


