package com.rahul.spring.configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class CarDirectoryInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { CarDirectoryConfiguration.class };
    }
   
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
   
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/api/*" };
    }
}
