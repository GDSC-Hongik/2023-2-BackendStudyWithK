package homework.hw3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServiceTest {
    Service service;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeAll(){
        memberRepository = new MemoryMemberRepository();
        service = new Service(memberRepository);
    }

    @Test
    void 회원가입(){
        //given
        Member member = new Member("id1","pw1");


        //when
        String saveId = service.join(member);
        //then
        String findMember = service.findOne(saveId).get();
        assertThat(member.getId()).isEqualTo(findMember)
    }
}
