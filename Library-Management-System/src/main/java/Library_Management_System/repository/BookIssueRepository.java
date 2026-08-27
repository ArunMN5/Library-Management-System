package Library_Management_System.repository;

import Library_Management_System.entity.BookIssue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookIssueRepository extends CrudRepository<BookIssue, Long> {

    List<BookIssue> findByMemberId(Long memberId);

    List<BookIssue> findByBookId(Long bookId);

}
