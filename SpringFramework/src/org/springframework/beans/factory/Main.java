package org.springframework.beans.factory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

import javax.management.relation.RelationException;

import org.springframework.context.ApplicationContext;

import ru.project.ProductService;
import ru.project.PromotionsService;

public class Main {
	
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ApplicationContext("ru.project");
			context.close();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
/*		BeanFactory beanFactory =  new BeanFactory();
		beanFactory.addPostProcessor(new CustomPostProcessor());
		try {
			try {
				beanFactory.instantiate("ru.project");
				ProductService productService = (ProductService)beanFactory.getBean("productService");
				System.out.println(productService);
				try {
					beanFactory.populateProperties();
					System.out.println(productService.getPromotionsService());
					PromotionsService promotionsService = (PromotionsService)beanFactory.getBean("promotionsService");
					beanFactory.injectBeanName();					
					System.out.println(promotionsService.getBeanName());
					beanFactory.initializeBeans();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}

}
