package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    private Integer id;

    @Column(name = "text", length = 256)
    private String text;

    @Column(name = "createdDate")
    private LocalDate createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Image Image;

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public User getCommentuser() {
        return user;
    }

    public Image getCommentImage() {
        return Image;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setCommentuser(User commentuser) {
        this.user = commentuser;
    }

    public void setCommentImage(Image commentImage) {
        this.Image = commentImage;
    }
}
