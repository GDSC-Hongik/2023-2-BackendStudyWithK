package homework.hw3;


import java.util.Optional;

public interface MemberRepository {
    void save(Member member);

   // Option<Member> login(String id, String password);

    Optional<String> findById(String id);

    String loginRepository(String id);
}
