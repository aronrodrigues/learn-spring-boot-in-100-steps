package ie.trk.springboot.myfirstapp;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    public boolean authenticate(String name, String password) {
        boolean isValidUsername = "aron".equals(name);
        boolean isValidPassword = "111111".equals(password);

        return isValidUsername && isValidPassword;
    }

}
