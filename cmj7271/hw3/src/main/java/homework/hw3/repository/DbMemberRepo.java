package homework.hw3.repository;

import homework.hw3.domain.Member;
import homework.hw3.domain.MemberInfo;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class DbMemberRepo implements MemberRepository {

    private final EntityManager em;

    public DbMemberRepo(EntityManager em) {
        this.em = em;
    }

    @Override
    public MemberInfo save(Member member) {
        MemberInfo memberInfo = convert(member);
        em.persist(memberInfo);
        return memberInfo;
    }

    @Override
    public Optional<MemberInfo> find(String id, String pw) {
        List<MemberInfo> resultList = em.createQuery("select m from MemberInfo m where m.id = :id and m.pw = :pw", MemberInfo.class)
                .setParameter("id", id)
                .setParameter("pw", pw)
                .getResultList();
        return resultList.stream().findAny();
    }

    @Override
    public Optional<MemberInfo> findById(String id) {
        List<MemberInfo> resultList = em.createQuery("select m from MemberInfo m where m.id = :id", MemberInfo.class)
                .setParameter("id", id)
                .getResultList();
        return resultList.stream().findAny();
    }

    @Override
    public List<MemberInfo> findAll() {
        return em.createQuery("select m from MemberInfo m", MemberInfo.class)
                .getResultList();
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
