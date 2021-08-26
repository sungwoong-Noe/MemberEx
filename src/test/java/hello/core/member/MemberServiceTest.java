package hello.core.member;


import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class MemberServiceTest {


    MemberService memberService;

    @BeforeEach //테스트 실행 전에 무조건 실행되는 것
    public void beforeEach(){

        //테스트 실행전에 위에 아래 코드가 실행되어 AppConfig에서 구현체들을 주입 받아 memberService에 주입시켜준다.
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();

    }


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
