package hello.core.xml;

import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

    @Test
    //xml 문서로 된 스프링 빈 조회
    void xmlAppContext() {
        ApplicationContext gac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = gac.getBean("memberService",MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
