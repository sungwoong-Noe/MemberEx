package hello.core;

import hello.core.member.Gradle;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        //AppConfig가 무조건 필요
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();


        Member member = new Member(1L, "memberA", Gradle.VIP);
        memberService.join(member);


        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
