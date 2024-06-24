package rw.ac.rca.springsecurity1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca.springsecurity1.dto.StudentDto;
import rw.ac.rca.springsecurity1.payload.ApiResponse;
import rw.ac.rca.springsecurity1.service.StudentService;
import rw.ac.rca.springsecurity1.utils.ExceptionUtils;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllStudents(){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Student retrieved successfully",studentService.getAllStudents()));
        }catch (Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
    @PostMapping("/create_student")
    public ResponseEntity<ApiResponse> createStudent(@RequestBody StudentDto studentDto){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Student created successfully",studentService.saveStudent(studentDto)));
        }catch(Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
}
