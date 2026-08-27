package Library_Management_System.repository;

import Library_Management_System.dto.Response;
import Library_Management_System.entity.BookManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookManagementRepository extends JpaRepository<BookManagement, Long> {

    List<BookManagement> findAllById(Long id);

    List<BookManagement> findAllByTitle(String title);

    //List<BookManagement> deleteById(Long id);

}
