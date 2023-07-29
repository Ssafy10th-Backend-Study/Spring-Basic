package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


//Bean Definition을 직접 생성해서 스프링 컨테이너에 등록 가능
//그러나 현업에서는 Bean Definition을 직접 정의하거나 사용할 일 거의 X
public class BeanDefinitionTest {

    //getBeanDefinition을 호출하기 위해, ApplicationContext로 변수 선언 X
    //현업에서는 이런 것들을 사용할 일이 거의 없기 때문에, 역할인 ApplicationContext로 선언하는 것을 권장
     AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
     GenericXmlApplicationContext gac = new GenericXmlApplicationContext("appConfig.xml");

     @Test
     @DisplayName("빈 설정 메타정보 확인")
     void findApplicationBean() {
         String[] beanDefinitionNames = gac.getBeanDefinitionNames();
         for (String beanDefinitionName : beanDefinitionNames) {
             //ac(or gac)를 ApplicationContext로 선언하면, getBeanDefinition을 선언할 수 X
             BeanDefinition beanDefinition = gac.getBeanDefinition(beanDefinitionName);

             if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                 System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
             }

         }
     }
}
