package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //회원을 찾으려면 MemberRepository 인터페이스 필요, 인터페이스만 있으면 null 포인트 터짐, 구현체 필요
    private MemberRepository memberRepository = new MemoryMemberRepository();


    //memberRepository의 save 메서드 호출하면 Override된 Memory의 save 메서드 호출됨 : 다형성
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
