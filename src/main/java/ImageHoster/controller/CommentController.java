package ImageHoster.controller;

import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/images/{id}/{title}/comments", method = RequestMethod.POST)
    public String commentCreate(@PathVariable("title") String title, @PathVariable("id") Integer id, Model model, HttpSession session, RedirectAttributes redirect) {
        Image image = imageService.getImageByTitle(title, id);
        User user = (User) session.getAttribute("loggeduser");



        model.addAttribute("image", image);
        model.addAttribute("tags", image.getTags());
        model.addAttribute("tags", image.getComments());
        return "images/image";
    }

}
