package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " Object = " + bean);
        }

    }

    @Test
    @DisplayName("사용하는 빈 출력하기")
    void findUseBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            BeanDefinition bf = ac.getBeanDefinition(beanDefinitionName);
            //System.out.println("BeanDefinition.ROLE_APPLICATION = " + BeanDefinition.ROLE_APPLICATION);
            if (bf.getRole() == BeanDefinition.ROLE_APPLICATION){
               System.out.println("name = " + beanDefinitionName + " Object = " + bean);
            }
        }
    }

}
