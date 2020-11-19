package TechnicalBlog.Controller;

import TechnicalBlog.Model.Post;
import TechnicalBlog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    public HomeController() {
        System.out.println("***** HomeController *****");
    }

    @Autowired
    private PostService postService;
    @RequestMapping("/")
    public String getAllPosts(Model model){
        List<Post> posts = postService.getAllposts();
        model.addAttribute("posts", posts);
        //model.addAttribute("post", post1);

        return "index";
    }
}
