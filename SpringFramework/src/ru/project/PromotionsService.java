package ru.project;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.stereotype.Component;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@Component
public class PromotionsService implements BeanNameAware,BeanFactoryAware,InitializingBean,ApplicationListener<ContextClosedEvent> {
	
	private String beanName;
	private BeanFactory beanFactory;
	
	@Override
	public void setBeanName(String name) {
		beanName = name;
	}
	
	public String getBeanName() {
		return beanName;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;		
	}

	@Override
	public void afterPropertiesSet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		System.out.println(">> ContextClosed EVENT");
		
	}
}
