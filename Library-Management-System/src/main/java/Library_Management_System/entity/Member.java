package Library_Management_System.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Data
@Entity
@Table(name = "MembersDB")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String memberName;
    private String memberEmail;
    private Long memberPhone;
    private String memberAddress;
    private Date memberShipDate;

}
