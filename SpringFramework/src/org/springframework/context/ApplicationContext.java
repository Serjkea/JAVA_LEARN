package org.springframework.context;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URISyntaxException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.event.ContextClosedEvent;

public class ApplicationContext {
	
	private BeanFactory beanFactory = new BeanFactory();
	
	public ApplicationContext(String basePackage) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, URISyntaxException, ClassNotFoundException, InstantiationException {
        System.out.println("******Context is under construction******");
        beanFactory.instantiate(basePackage);
        beanFactory.populateProperties();
        beanFactory.injectBeanName();
        beanFactory.initializeBeans();
	}
	
	public void close() {
		beanFactory.close();
		for(Object bean: beanFactory.getSingletons().values()) {
			for(Type type : bean.getClass().getGenericInterfaces()) {
				if (type instanceof ParameterizedType) {
					ParameterizedType parameterizedType = (ParameterizedType) type;
					Type firstParameter = parameterizedType.getActualTypeArguments()[0];
					if(firstParameter.equals(ContextClosedEvent.class)){
					    Method method = null;
						try {
							method = bean.getClass().getMethod("onApplicationEvent", ContextClosedEvent.class);
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    try {
							method.invoke(bean, new ContextClosedEvent());
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
			}
		}
	}
}
