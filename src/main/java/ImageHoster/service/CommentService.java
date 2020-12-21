package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addNewComment(Comment newComment){
        return commentRepository.addNewComment(newComment);
    }

}
