package TechnicalBlog.repository;

import TechnicalBlog.Model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public List<Post> getAllPosts(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
        List<Post> resultList = query.getResultList();
        return resultList;
    }

    public Post getLatestPost(){
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, 3);
    }

    public Post CreatePost(Post newPost){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {

            transaction.begin();
            em.persist(newPost);
            transaction.commit();
        }
        catch(Exception ex){
            transaction.rollback();
        }
        return newPost;
    }

    public Post getPost(Integer postId){
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, postId);
    }
}
