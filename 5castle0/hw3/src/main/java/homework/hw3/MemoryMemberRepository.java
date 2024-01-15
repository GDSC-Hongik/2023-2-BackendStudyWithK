package homework.hw3;


import org.springframework.stereotype.Repository;
import homework.hw3.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<String,String> store =new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member.getPassword());
    }

    @Override
    public Optional <String> findById(String id){
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public String loginRepository(String id){
        return store.get(id);
    }

}
