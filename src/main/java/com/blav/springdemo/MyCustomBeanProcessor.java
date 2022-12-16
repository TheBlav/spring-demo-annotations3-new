package com.blav.springdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class MyCustomBeanProcessor implements BeanFactoryAware,
        BeanPostProcessor, DisposableBean {

    private BeanFactory beanFactory;
    private final List<Object> prototypeBeans = new LinkedList<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            // after startup we keep track of the prototype scoped beans
            // we will need to know who they're for later destruction
        if (beanFactory.isPrototype(beanName)){
            synchronized (prototypeBeans){
                prototypeBeans.add(bean);
            }
        }
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void destroy() throws Exception {
        // loop through the prototype beans and call destroy in each one of them
        synchronized (prototypeBeans){
            for (Object bean : prototypeBeans) {
                if (bean instanceof DisposableBean){
                    DisposableBean disposable = (DisposableBean) bean;
                    try {
                        disposable.destroy();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            prototypeBeans.clear();
        }
    }
}