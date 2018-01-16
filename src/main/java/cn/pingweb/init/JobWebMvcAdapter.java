package cn.pingweb.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhuyuping
 * @date 2018/1/11.
 */
@Configuration
public class JobWebMvcAdapter extends WebMvcConfigurerAdapter implements ApplicationContextAware,InitializingBean {

    private ApplicationContext applicationContext;
    private RequestInterceptor requestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        this.requestInterceptor = new RequestInterceptor();
        registry.addInterceptor(this.requestInterceptor).addPathPatterns("/**").excludePathPatterns("/common/**");
        super.addInterceptors(registry);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //this.requestInterceptor.init();
    }
}
