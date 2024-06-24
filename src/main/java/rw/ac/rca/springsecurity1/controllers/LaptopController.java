package rw.ac.rca.springsecurity1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import rw.ac.rca.springsecurity1.dto.LaptopDto;
import rw.ac.rca.springsecurity1.payload.ApiResponse;
import rw.ac.rca.springsecurity1.service.LaptopService;
import rw.ac.rca.springsecurity1.utils.ExceptionUtils;

@Controller
@RequestMapping("/laptop")
@AllArgsConstructor
public class LaptopController {
    private final LaptopService laptopService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllLaptop(){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Laptop retrieved successfully",laptopService.getAllLaptops()));
        }catch (Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }

    @PostMapping("create_laptop")
    public ResponseEntity<ApiResponse> createLaptop(@RequestBody  LaptopDto laptopDto){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"laptop created successfully",laptopService.createLaptop(laptopDto)));
        }catch(Exception e){
            e.printStackTrace();
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
}
