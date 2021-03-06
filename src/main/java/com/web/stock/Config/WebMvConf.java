package com.web.stock.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvConf implements WebMvcConfigurer {
    /**
     * 注入第一步定义好的拦截器
     */
    @Autowired
    private ConfigInterceptor configInterceptor;

    /**
     * 定义拦截规则, 根据自己需要进行配置拦截和排除的接口
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(configInterceptor)
                // .addPathPatterns() 是配置需要拦截的路径
                .addPathPatterns("/**").excludePathPatterns("/code") // 排除登录页获取验证码接口
                .excludePathPatterns("/loginVerify") // 排除验证账号密码接口
                .excludePathPatterns("/outToLogin").excludePathPatterns("/lib/**") // 排除静态文件
                .excludePathPatterns("/pages/**") // 排除静态文件
                .excludePathPatterns("/page/**") // 排除静态文件
                .excludePathPatterns("/test")
                .excludePathPatterns("/swagger-resources/**", "/v2/**", "/swagger-ui.html/**",
                        "/configuration/**")
                .excludePathPatterns("/**.html")// swagger
                .excludePathPatterns("/gotologin").excludePathPatterns("/webjars/**")
                .excludePathPatterns("/gotoregister").excludePathPatterns("/static/**").excludePathPatterns("/js/**")
                .excludePathPatterns("/lo/**") // 所有login界面的路由
                .excludePathPatterns("/login").excludePathPatterns("/signin").excludePathPatterns("/images/**")
                .excludePathPatterns("/css/**");
    }

}
