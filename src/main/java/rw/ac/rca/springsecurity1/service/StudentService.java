package rw.ac.rca.springsecurity1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rw.ac.rca.springsecurity1.dto.StudentDto;
import rw.ac.rca.springsecurity1.entity.Student;
import rw.ac.rca.springsecurity1.entity.UserData;
import rw.ac.rca.springsecurity1.exceptions.NotFoundException;
import rw.ac.rca.springsecurity1.repository.StudentRepository;
import rw.ac.rca.springsecurity1.repository.UserDataRepository;
import rw.ac.rca.springsecurity1.utils.ExceptionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserDataRepository userDataRepository;

    public List<Student> getAllStudents(){
        try{
            return studentRepository.findAll();
        }catch (Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return  null;
        }
    }
    
    public Student saveStudent(StudentDto studentDto){
        try{
            UserData userData=userDataRepository.findById(studentDto.getCreated()).orElseThrow(()-> new NotFoundException("user not found"));
            Student student= new Student();
            student.setLastName(studentDto.getLastName());
            student.setFirstName(studentDto.getFirstName());
            student.setEmail(studentDto.getEmail());
            student.setCreated(userData);
            return studentRepository.save(student);

        }catch ( Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }



}
