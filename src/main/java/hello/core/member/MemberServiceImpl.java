package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //회원을 찾으려면 MemberRepository 인터페이스 필요, 인터페이스만 있으면 null 포인트 터짐, 구현체 필요
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
//memberServiceImpldms  MemberRepository, MemoryMemberRepository(); 둘 다 의존중이다. 추상화와 구체화 둘 다 의존중이다. : DIP 위반


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
