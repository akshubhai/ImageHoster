package ImageHoster.controller;

import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

}
