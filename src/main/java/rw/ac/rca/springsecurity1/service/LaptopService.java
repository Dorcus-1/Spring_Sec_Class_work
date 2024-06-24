package rw.ac.rca.springsecurity1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.ac.rca.springsecurity1.dto.LaptopDto;
import rw.ac.rca.springsecurity1.entity.Laptop;
import rw.ac.rca.springsecurity1.entity.Student;
import rw.ac.rca.springsecurity1.exceptions.NotFoundException;
import rw.ac.rca.springsecurity1.repository.LaptopRepository;
import rw.ac.rca.springsecurity1.repository.StudentRepository;
import rw.ac.rca.springsecurity1.utils.ExceptionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopService {

    private final StudentRepository studentRepository;
    private final LaptopRepository laptopRepository;


    public Laptop createLaptop(LaptopDto laptopDto){
        try{
            Student student= studentRepository.findById(laptopDto.getStudent()).orElseThrow(()-> new NotFoundException("student not found"));
            Laptop laptop= new Laptop();
            laptop.setBrand(laptopDto.getBrand());
            laptop.setSn(laptopDto.getSn());
            laptop.setStudent(student);
            return laptopRepository.save(laptop);
        }catch (Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }
    public List<Laptop> getAllLaptops(){
        try {
            return laptopRepository.findAll();

        }catch(Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }

}

