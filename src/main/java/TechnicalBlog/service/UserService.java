package TechnicalBlog.service;

import TechnicalBlog.Model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Boolean login(User user){
        if(user.getUsername().equals("validUser")){
            return true;
        }
        else{
            return false;
        }
    }
}
