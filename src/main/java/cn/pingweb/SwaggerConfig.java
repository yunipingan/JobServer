package cn.pingweb;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // 该注解就是告诉Spring这个是一个配置文件类，这里配置的Bean要交给Spring去管理。这个就是用来取代Beans.xml这种文件的。
@EnableSwagger2 // 启用 Swagger
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                // if (declaringClass == BasicErrorController.class)// 排除
                // return false;
                if (declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
                    return true;
                if (input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
                    return true;
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                // .genericModelSubstitutes(DeferredResult.class)
                // .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                // .forCodeGeneration(false)
                .select().apis(predicate)
                // .paths(PathSelectors.any())//过滤的接口
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("接口服务")// 大标题
                .version("1.0")// 版本
                .build();
    }
}