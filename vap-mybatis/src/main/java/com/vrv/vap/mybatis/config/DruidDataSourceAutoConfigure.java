package com.vrv.vap.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * @author wh1107066
 */
@Configuration
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(prefix = "spring.datasource", name = "url")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidDataSourceAutoConfigure {

    /**
     * 主数据源
     * @return 返回datasource
     */
    @Bean
    @ConditionalOnMissingBean(DataSource.class)
    public DataSource masterDataSource(DruidProperties druidProperties) {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(dataSource);
    }

    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/static/*,/druid/*");
        return filterRegistrationBean;
    }

}