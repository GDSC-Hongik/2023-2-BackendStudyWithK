package homework.hw3.service;

import homework.hw3.repository.DbMemberRepo;
import homework.hw3.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() { return new MemberService(memberRepository()); }

    @Bean
    public MemberRepository memberRepository() {
        return new DbMemberRepo(em);
    }
}
