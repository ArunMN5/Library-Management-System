package Library_Management_System.repository;

import Library_Management_System.dto.Request.MemberRequest;
import Library_Management_System.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findById(Long memberId, MemberRequest memberRequest);

//    Member findById(Long memberId);

//    List<Member> findById(Long id);

//    List<Member> Findbyname(String name);


}
