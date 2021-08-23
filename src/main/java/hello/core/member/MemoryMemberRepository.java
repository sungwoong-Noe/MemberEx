package hello.core.member;

import java.util.HashMap;
import java.util.Map;

//메모리 MemberRepository 사용
public class MemoryMemberRepository implements MemberRepository{

    //저장소
    private static Map<Long, Member> store = new HashMap<>();


    //저장
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    //조회
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
