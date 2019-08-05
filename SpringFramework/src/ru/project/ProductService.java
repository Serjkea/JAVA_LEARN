package ru.project;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Resource;
import org.springframework.beans.factory.stereotype.Component;

@Component
public class ProductService implements BeanNameAware,BeanFactoryAware,InitializingBean{
	
	private String beanName;
	private BeanFactory beanFactory;
	
	@Autowired
	private PromotionsService promotionsService;
	
	public PromotionsService getPromotionsService() {
		return promotionsService;
	}
	
	public void setPromotionsService(PromotionsService promotionsService) {
		this.promotionsService = promotionsService;
	}

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
	
	@PostConstruct
	public void init() {
		System.out.println("Bean was Initialized");
	}

}
