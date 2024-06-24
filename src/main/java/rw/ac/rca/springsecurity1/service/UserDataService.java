package rw.ac.rca.springsecurity1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rw.ac.rca.springsecurity1.entity.UserData;
import rw.ac.rca.springsecurity1.exceptions.BadRequestException;
import rw.ac.rca.springsecurity1.repository.UserDataRepository;
import rw.ac.rca.springsecurity1.utils.ExceptionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService implements UserDetailsService {

    @Autowired
    private UserDataRepository repository;

    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");
        System.out.println(username);
        Optional<UserData> userData = repository.findByEmail(username);
        System.out.println(userData.isPresent());
        //Convert userData to UserDetails
        return userData.map(UserDataDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }
    public UserData loadCurrentUser(String username) throws UsernameNotFoundException {
        Optional<UserData> userDetail = repository.findByEmail(username);
        return userDetail
                .orElseThrow(() -> new UsernameNotFoundException("User not found " +
                        username));
    }
    public UserData addUser(UserData userData) {
        try{
            Optional<UserData> userData1= repository.findByEmail(userData.getEmail());
            if(userData1.isPresent()){
                throw new BadRequestException("Email already exists");
            }
            userData.setPassword(encoder.encode(userData.getPassword()));
            return repository.save(userData);
        }catch(Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }

    }
    public List<UserData> listAll() {
        return repository.findAll();
    }


}



