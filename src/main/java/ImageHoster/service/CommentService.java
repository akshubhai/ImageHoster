package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addNewComment(Comment newComment){
        return commentRepository.addNewComment(newComment);
    }

    public List<Comment> getAllCommentsPerImage(Integer imageId) {
        return commentRepository.getAllComments(imageId);
    }

}
