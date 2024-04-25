package com.mohaji._sb0423.config;

import com.mohaji._sb0423.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override        //컨트롤러를 사용하지 않고 첫 화면시 루트로 가는 명령어 실행
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main");
    }

    @Override // 만들어진 인터셉터를 등록한다. (특정 폴더에만 인터셉트 적용)
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor())
                .addPathPatterns("/register/**")
        .excludePathPatterns("/practice/**");
    }
}
