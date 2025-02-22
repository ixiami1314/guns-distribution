/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.stylefeng.guns.config.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 *
 * @author Fu Fei
 * @date @date 2020/7/10
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket distributionRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(distributionApiInfo())
                .groupName("distribution")
                .select()
                // 限定扫描包路径
//                .apis(RequestHandlerSelectors.basePackage("cn.stylefeng.guns.modular.distribution.api"))
                .apis(RequestHandlerSelectors.basePackage("cn.stylefeng.guns"))
                // 限定接口注解
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo distributionApiInfo() {
        return new ApiInfoBuilder()
                .title("Distribution Doc")
                .description("Distribution Api文档")
                .version("1.0")
                .build();
    }

}