package com.ZenPack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomWebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private JwtInterceptor jwtInterceptor;

//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//
//        //sort
//        SortHandlerMethodArgumentResolver sortResolver = new SortHandlerMethodArgumentResolver();
//        sortResolver.setSortParameter("order-by");
//
//        PageableHandlerMethodArgumentResolver pageResolver = new PageableHandlerMethodArgumentResolver(sortResolver);
//
//        pageResolver.setPageParameterName("page-number");
//        pageResolver.setSizeParameterName("page-size");
//        pageResolver.setOneIndexedParameters(true);
//
//        Pageable defaultPageable = new PageRequest(0, 5);
//        pageResolver.setFallbackPageable(defaultPageable);
//
//        argumentResolvers.add(pageResolver);
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor);
    }

}
