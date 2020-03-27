package com.logistics.manage.config;

import com.logistics.manage.interceptor.backLoginIntercetor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


/**
 * @Create 2020-01-17 7:12
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${file.upload.filepath}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:" + filePath,
                "classpath:static/images/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/go/to/index").setViewName("/index");
        registry.addViewController("/go/to/welcome").setViewName("/pages/welcome");
        registry.addViewController("/go/to/login").setViewName("/login");
        registry.addViewController("/frontend/index").setViewName("/frontend/index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new backLoginIntercetor()).addPathPatterns("/go/to/index")
                .excludePathPatterns("/go/to/login");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowedOrigins("*"). //允许跨域的域名，可以用*表示允许任何域名使用
                allowedMethods("*"). //允许任何方法（post、get等）
                allowedHeaders("*"); //允许任何请求头
    }
}