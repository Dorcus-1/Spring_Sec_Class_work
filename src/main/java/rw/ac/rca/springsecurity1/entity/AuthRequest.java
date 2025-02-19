package rw.ac.rca.springsecurity1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String username;
    private String password;

    public Object getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}