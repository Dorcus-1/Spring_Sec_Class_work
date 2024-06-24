package rw.ac.rca.springsecurity1.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LaptopDto {
    private String brand;
    private String sn;
    private int student;
}
