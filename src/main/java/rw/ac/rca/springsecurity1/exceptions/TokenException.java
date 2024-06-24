//package rw.ac.rca.springsecurity1.exceptions;
//
//import ne.oop.bsupermat.dto.response.ErrorResponse;
//import ne.oop.bsupermat.dto.response.Response;
//import ne.oop.bsupermat.enums.ResponseType;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ResponseStatus(HttpStatus.UNAUTHORIZED)
//public class TokenException extends Exception{
//    private final HttpStatus httpStatus=HttpStatus.UNAUTHORIZED;
//    public TokenException(String message){
//        super(message);
//    }
//    public ResponseEntity<Response> getResponseEntity(){
//        List<String> details=new ArrayList<>();
//        details.add(super.getMessage());
//        ErrorResponse errorResponse= new ErrorResponse("No authorization",details);
//        Response<ErrorResponse> response= new Response<>();
//        response.setPayload(errorResponse);
//        response.setResponseType(ResponseType.UNAUTHORIZED);
//        return new ResponseEntity<>(response,httpStatus);
//
//    }
//}
