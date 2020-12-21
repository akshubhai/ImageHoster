package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;


public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/images/{imageId}/{title}/comments", method = RequestMethod.POST)
    public String addNewComment(@PathVariable(value = "imageId") Integer imageId, @PathVariable(value = "title") String title, @RequestParam(value = "comment") String userCommentInput, HttpSession session, Comment newComment){
        Image image = imageService.getImage(imageId);
        User loggedInUser = (User) session.getAttribute("loggeduser");

        newComment.setCommentImage(image);
        newComment.setCommentuser(loggedInUser);

        newComment.setCreatedDate(LocalDate.now());

        newComment.setText(userCommentInput);

        commentService.addNewComment(newComment);

        return "redirect:/images/" + imageId + "/" + title ;

    }


}
