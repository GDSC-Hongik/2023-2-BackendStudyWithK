package homework.hw3.service;

import homework.hw3.domain.Member;
import homework.hw3.domain.MemberInfo;
import homework.hw3.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    final String admin_id = "admin";
    final String admin_pw = "1234";

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberInfo login(Member member) {
        MemberInfo memberInfo = convert(member);

        if(memberInfo.getId().equals(admin_id) && memberInfo.getPw().equals(admin_pw)) {
            return memberInfo;
        }

        Optional<MemberInfo> member1info = memberRepository.find(member.getId(), member.getPw());
        if(member1info.isEmpty()) {throw new IllegalStateException("없는 회원입니다.");}

        return member1info.get();
    }

    public boolean signUp(Member member) {
        if(isDuplicated(member)) return false;

        memberRepository.save(member);
        return true;
    }

    public Optional<MemberInfo> getInfo(String id) {
        return memberRepository.findById(id);
    }

    public List<MemberInfo> findMembers() { return memberRepository.findAll(); }

    private boolean isDuplicated(Member member) {
        return memberRepository.find(member.getId(), member.getPw()).isEmpty();
    }
    private MemberInfo convert(Member member) {
        MemberInfo memberInfo = new MemberInfo();

        memberInfo.setId(member.getId());
        memberInfo.setPw(member.getPw());
        memberInfo.setName("");
        memberInfo.setAge(0);
        memberInfo.setDescribe("");

        return memberInfo;
    }
}