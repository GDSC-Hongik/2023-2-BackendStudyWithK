package homework.hw3.repository;

import homework.hw3.domain.Member;
import homework.hw3.domain.MemberInfo;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    MemberInfo save(Member member); // 저장후 그대로 반환
    Optional<MemberInfo> find(String id, String pw);
    Optional<MemberInfo> findById(String id);
    List<MemberInfo> findAll();

}
