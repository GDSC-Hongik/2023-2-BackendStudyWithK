package homework.hw3;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    private final MemberRepository memberRepository;

    @Autowired
    public Service(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    public String join(Member member) {
        Optional<String> checkId = memberRepository.findById(member.getId());
        if (checkId.isEmpty()) {
            memberRepository.save(member);
            return member.getId() + member.getPassword();

        }
        else System.out.println("Already exist!");
        return "";
    }

    public String login(String id,String pw){
        Optional<String> checkId = memberRepository.findById(id); //id가 존재하는지 test
        if(checkId.isPresent()){
            String repositoryPw = memberRepository.loginRepository(id);
            if(pw.equals(repositoryPw)){
                return "success";
            }
            else return "loginFail";
        }
        else return "noExist";
    }

    public Optional<String> findOne(String memberid){
        return memberRepository.findById(memberid);
    }


}


