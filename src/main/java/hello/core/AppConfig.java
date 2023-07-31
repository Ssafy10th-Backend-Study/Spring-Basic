package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * DI(Dependency Injection) 의존(성) 관계 주입: 의존 관계를 외부(AppConfig)에서 결정(주입)해주는 것
 * 관심사를 확실하게 분리
 * AppConfig는 공연 기획자
 * 구현 객체들을 다 알아야 함
 * 어플리케이션이 어떻게 동작해야 할지 전체 구성을 책임짐
 * OrderServiceImpl은 기능을 실행하는 책임만 지게 됨
 *
 *
 * 프로그래머는 '추상화에 의존해야지', 구체화에 의존하면 안된다.
 */

@Configuration // 앱의 구성 정보, 설정 정보를 담당
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    //MemoryMemberRepository() 객체가 두 번 호출되는데, 싱글톤?

    @Bean // SpringContainer에 등록
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
