package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    //테스트의 repository랑 다르기에 두 repository를 같게끔 만들어주기
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    private  final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository; //외부에서 repository에 넣어주기
        //직접 new해서 repository를 만들지 않음, 멤버 서비스 입장에서 dependency injection , 즉 di라고 함
    }

    //회원가입

    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
        /* Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m ->{ //만약에 값이 존재한다면, optional이기에 가능한것(null일수도 있기에)
            throw new IllegalStateException("이미 존재하는 회원입니다.");  //예외처리
        } ); */

        vaildateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    private void vaildateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");} );
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
