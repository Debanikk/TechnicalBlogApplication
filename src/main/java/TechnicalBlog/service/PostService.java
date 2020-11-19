package TechnicalBlog.service;

import TechnicalBlog.Model.Post;
import TechnicalBlog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    private Post currentPost;
    public PostService() {
        System.out.println("***** PostService *****");
    }

    public List<Post> getAllposts() {
        return repository.getAllPosts();

        /*Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog", "postgres","Credit@123");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM posts");
            while(rs.next()){
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }
        }
        catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/

    }

    public Post getOnePost(){
        return repository.getLatestPost();
        /*if(currentPost == null) {
            currentPost = new Post();
            currentPost.setTitle("This is your post");
            currentPost.setBody("This is the main body of your post");
            currentPost.setDate(new Date());
            posts.add(currentPost);
        }
        else{
            posts.add(currentPost);
        }*/
        /*Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres","Credit@123");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM posts where id = 4");
            while(rs.next()){
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }

        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return posts;*/

    }

    public void createPost(Post post){
        post.setDate(new Date());
        repository.CreatePost(post);
        System.out.println("New Post" + post);
    }

    public Post getPost(Integer postId){
        return repository.getPost(postId);
    }
}
