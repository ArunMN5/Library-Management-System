package Library_Management_System.service;

import Library_Management_System.dto.Request.MemberRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.entity.Member;

public interface MemberService {

    Response AddMember(MemberRequest memberRequest);

    Response UpdateMember(Long memberId,MemberRequest memberRequest);

    Response DeleteMember(Long memberId);

    Response GetMember(Long memberId);


}
