package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    //Repo func to persist new comments into comments table
    public Comment addNewComment(Comment newComment){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return newComment;
    }

    //Repo func to pull all comments for given imageid
    public List<Comment> getAllComments(Integer imageId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Comment> typedQuery = em.createQuery("SELECT c from Comment c where c.Image =:imageId", Comment.class).setParameter("imageId", imageId);
            return typedQuery.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
