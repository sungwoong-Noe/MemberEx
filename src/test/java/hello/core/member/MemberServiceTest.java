package hello.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given: 이런게 주어졌을 떄
        Member member = new Member(1L, "memberA", Gradle.VIP);  //저장할 회원 정보

        //when: 이렇게 했을 때
        memberService.join(member); //저장되는 회원
        Member findByMember = memberService.findMember(1L); //조회되는 회원 : id가 1인 회원

        //then: 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findByMember);  //member에 저장된 회원과 조회되는 id:1인 회원이 같은지
    }

}
