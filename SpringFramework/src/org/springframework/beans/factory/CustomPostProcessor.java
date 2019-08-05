package org.springframework.beans.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.PostConstruct;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		System.out.println("---CustomPostProcessor Before " + beanName);
		for(Method method: bean.getClass().getDeclaredMethods()) {
			if (method.isAnnotationPresent(PostConstruct.class)) {
				try {
					method.invoke(bean);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("---CustomPostProcessor After " + beanName);
		return bean;
	}

}
