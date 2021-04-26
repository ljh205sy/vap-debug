package com.vrv.vap.consumer;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;

/**
 * <p>
 * Mybatis generator的逆向生成工具类
 *
 * @author liujinhui
 * @date 2021/3/19 22:57
 *  需要依赖
 *         <dependency>
*             <groupId>org.mybatis.generator</groupId>
*             <artifactId>mybatis-generator-core</artifactId>
*             <version>1.3.5</version>
*         </dependency>
 */

public class MybatisGenerator {

    public static void main(String[] args) throws Exception {
        MybatisGenerator mybatisGenerator = new MybatisGenerator();
        mybatisGenerator.generator();
    }

    public void generator() throws Exception {
        ArrayList<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        // 指定你想工程配置文件
        File configFile = new File("D:\\VRV\\vap\\gitlab\\vap-bug\\api-service\\api-provider\\src\\main\\resources\\generator\\generatorConfig.xml");
        System.out.println(configFile.getAbsolutePath());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
