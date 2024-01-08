package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository { //implements MemberRepository 하면 옵션으로 아래 코드를 자동으로 가져옴

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L; //0,1,2..처럼 키값을 생성해주는 변수

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id는 시스템이 정해주는 것
        store.put(member.getId(),member); //store에 저장 ->  map에 저장됨
        return member; //저장된 결과 반환
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //ofNullable은 NULL이 반환 될 가능성이 있을 때 사용
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
        //찾으면 그냥 반환, member.getName이 파라미터로 넘어온 name과 같은지 확인 하는 것, findAny는 가장 먼저 탐색되는 값 리턴
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
