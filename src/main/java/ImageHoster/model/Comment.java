package ImageHoster.model;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comments")
public class Comment {

    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    private Integer id;

    @Column(name = "text", length = 256)
    private String text;

    @Column(name = "createdDate")
    private LocalDate createdDate;

    //emphasis on many to one relation with user table
    @ManyToOne(fetch = FetchType.EAGER)
    //Actual column name in sql table
    @JoinColumn(name = "userid")
    private User user;

    //emphasis on many to one relation with image table
    @ManyToOne(fetch = FetchType.EAGER)
    //Actual column name in sql table
    @JoinColumn(name = "Image")
    private Image Image;

    //Define constructor
    public Comment() {
    }

    //Define getter and setter methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ImageHoster.model.Image getImage() {
        return Image;
    }

    public void setImage(ImageHoster.model.Image image) {
        Image = image;
    }
}
