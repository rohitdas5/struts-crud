package org.apache.struts.crud;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean strutsExecuteFilter() {
        return buildFilterRegistration(0, new StrutsPrepareAndExecuteFilter());
    }

    private FilterRegistrationBean buildFilterRegistration(int order, Filter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);

        List<String> urls = new ArrayList<String>();

        urls.add("/");
        urls.add("/persons.jsp");
        urls.add("/persons.action");
        urls.add("/editPerson.jsp");
        urls.add("/editPerson.action");
        urls.add("/index.jsp");
        urls.add("/index.action");
        urls.add("/inputPerson.action");
        urls.add("/deletePerson.action");
        urls.add("/savePerson.action");
        urls.add("/deletePerson.action");

        registration.setUrlPatterns(urls);
        /*registration.setUrlPatterns(singletonList("/*"));*/
        registration.setOrder(order);
        return registration;
    }

}