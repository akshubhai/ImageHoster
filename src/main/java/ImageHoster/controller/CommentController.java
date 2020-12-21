package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;


@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/images/{imageId}/{title}/comments")
    public String getnewComment(@PathVariable("title") String title, @PathVariable("id") Integer id, Model model){
        Image image = imageService.getImageByTitle(title, id);
        model.addAttribute("image", image);
        model.addAttribute("tags", image.getTags());

        //Add comments attribute for image
        model.addAttribute("comments", image.getComments());
        return "redirect:/images/image";
    }

    @RequestMapping(value = "/image/{imageId}/{title}/comments", method = RequestMethod.POST)
    public String addNewComment(@PathVariable(value = "imageId") Integer imageId, @PathVariable(value = "title") String title, @RequestParam(value = "comment") String userCommentInput, HttpSession session, Comment newComment){
        Image image = imageService.getImage(imageId);
        User loggedInUser = (User) session.getAttribute("loggeduser");

        newComment.setCommentImage(image);
        newComment.setCommentuser(loggedInUser);

        newComment.setCreatedDate(LocalDate.now());

        newComment.setText(userCommentInput);

        commentService.addNewComment(newComment);

        return "redirect:/images/" + imageId + "/" + title ;

        //return "/image/" + imageId + "/" + title + "/comments" ;


    }


}
