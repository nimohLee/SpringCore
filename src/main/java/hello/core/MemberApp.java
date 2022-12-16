package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // Spring container 역할 (스프링의 모든것을 관리)

        // Configuration을 annotation한 클래스를 컨테이너로 지정 -> 각각의 빈이 다 등록 됨
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // memberService라는 이름(메서드 이름)의 Bean을 찾음. 타입은 MemberService.class (이름, 타입)
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
