package Library_Management_System.ServiceImpl;

import Library_Management_System.dto.Request.MemberRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.dto.response.MemberResponse;
import Library_Management_System.entity.Member;
import Library_Management_System.repository.MemberRepository;
import Library_Management_System.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Response AddMember(MemberRequest memberRequest) {

        Member member = new Member();

        member.setMemberName(memberRequest.getMemberName());
        member.setMemberEmail(memberRequest.getMemberEmail());
        member.setMemberPhone(memberRequest.getMemberPhone());
        member.setMemberAddress(memberRequest.getMemberAddress());
        member.setMemberShipDate(new Date());

        memberRepository.save(member);

        MemberResponse memberResponse = new MemberResponse();

        memberResponse.setMemberName(member.getMemberName());
        memberResponse.setMemberEmail(member.getMemberEmail());
        memberResponse.setMemberPhone(member.getMemberPhone());
        memberResponse.setMemberAddress(member.getMemberAddress());

        return new Response("member added", true, HttpStatus.CREATED, memberResponse);

    }

    @Override
    public Response UpdateMember(Long memberId, MemberRequest memberRequest) {

       // Member member = memberRepository.findById(memberId, memberRequest);

        Member member = memberRepository.findById(memberId).get();

        member.setMemberName(memberRequest.getMemberName());
        member.setMemberEmail(memberRequest.getMemberEmail());
        member.setMemberPhone(memberRequest.getMemberPhone());
        member.setMemberAddress(memberRequest.getMemberAddress());

        memberRepository.save(member);

        return new Response("member updated", true, HttpStatus.OK, null);
    }

    @Override
    public Response DeleteMember(Long memberId) {

        memberRepository.deleteById(memberId);
        return new Response("member deleted", true, HttpStatus.OK, null);
    }

    @Override
    public Response GetMember(Long memberId) {

        //Optional<Member> response = memberRepository.findById(memberId);

        Member member = memberRepository.findById(memberId).get();

        MemberResponse memberResponse = new MemberResponse();
        memberResponse.setMemberName(member.getMemberName());
        memberResponse.setMemberEmail(member.getMemberEmail());
        memberResponse.setMemberPhone(member.getMemberPhone());
        memberResponse.setMemberAddress(member.getMemberAddress());

        return new Response("member found", true, HttpStatus.OK, memberResponse);

    }
}
