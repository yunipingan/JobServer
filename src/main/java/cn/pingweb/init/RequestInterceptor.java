package cn.pingweb.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhuyuping
 * @date 2018/1/11.
 */
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURL().toString();
        if(null != httpServletRequest.getSession().getAttribute("login")) {
            // 跳转登录
            return false;
        }
        //等待验证
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

//    public void init(){
//        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
//        //获取url与类和方法的对应信息
//        Map<RequestMappingInfo,HandlerMethod> map = mapping.getHandlerMethods();
//        List<String> urlList = new ArrayList<String>();
//        for (RequestMappingInfo info : map.keySet()){
//            //获取url的Set集合，一个方法可能对应多个url
//            Set<String> patterns = info.getPatternsCondition().getPatterns();
//            for (String url : patterns){
//                urlList.add(url);
//            }
//        }
//        this.urlList = urlList;
//    }
}
