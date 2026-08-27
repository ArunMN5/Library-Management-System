package Library_Management_System.controller;

import Library_Management_System.dto.Request.MemberRequest;
import Library_Management_System.dto.Response;
import Library_Management_System.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("memberManagemnet")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/addMember")
    public ResponseEntity<Response> AddMember(@Valid @RequestBody MemberRequest memberRequest) {
        Response response = memberService.AddMember(memberRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getMemberById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Response response = memberService.GetMember(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Response> deleteById(@PathVariable Long id) {
        Response response = memberService.DeleteMember(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/updateMemberDetatils/{id}")
    public ResponseEntity<Response> UpdateMember(@PathVariable Long id, @Valid @RequestBody MemberRequest memberRequest) {
        Response response = memberService.UpdateMember(id, memberRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


}
