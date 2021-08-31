package hello.core;

import hello.core.member.Gradle;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

//        //AppConfig가 무조건 필요
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();


        //ApplicationContext : 스프링 컨테이너라고 보면된다. @Bean인 객체들을 다 관리해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);    //스프링 컨테이너에 AppConfig클래스의 객체들을 다 넣어준다.

        //memberService 객체를 가져옴
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Gradle.VIP);
        memberService.join(member);


        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
