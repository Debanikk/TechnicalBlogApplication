package TechnicalBlog.Controller;

import TechnicalBlog.Model.Post;
import TechnicalBlog.Model.User;
import TechnicalBlog.Model.UserProfile;
import TechnicalBlog.service.PostService;
import TechnicalBlog.service.UserService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @RequestMapping("users/login")
    public String login(){

        return "users/login";
    }

    @RequestMapping("users/registration")
    public  String registration(Model model){
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);
        model.addAttribute("User", user);
        return "users/registration";
    }

    @RequestMapping(value = "logout", method= RequestMethod.POST)
    public String logout(Model model){
        List<Post> posts = postService.getAllposts();
        model.addAttribute("posts", posts);
        return "index";
    }



    @RequestMapping(value = "users/login", method= RequestMethod.POST)
    public String loginUser(User user){
        User existingUser = userService.login(user);
        if(existingUser != null) {
            return "redirect:/posts";
        }
        else{
            return "users/login";
        }
    }

    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user){
        userService.registerUser(user);
        return "redirect:/users/login";
    }
}
