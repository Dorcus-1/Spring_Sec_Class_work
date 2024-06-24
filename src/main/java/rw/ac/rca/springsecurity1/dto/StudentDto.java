package rw.ac.rca.springsecurity1.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private int created;

}
