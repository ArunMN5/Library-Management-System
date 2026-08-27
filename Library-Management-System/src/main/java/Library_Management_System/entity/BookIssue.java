package Library_Management_System.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class BookIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookManagement book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private Date issueDate;
    private Date dueDate;
    private String status;

    private LocalDate returnDate;



}
