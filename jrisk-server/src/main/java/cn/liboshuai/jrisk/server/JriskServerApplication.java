package cn.liboshuai.jrisk.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目的启动类
 *
 * @author 李博帅
 */
@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${jrisk.info.base-package}
@SpringBootApplication(scanBasePackages = {"${jrisk.info.base-package}.server", "${jrisk.info.base-package}.module"})
public class JriskServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(JriskServerApplication.class, args);
//        new SpringApplicationBuilder(JriskServerApplication.class)
//                .applicationStartup(new BufferingApplicationStartup(20480))
//                .run(args);

    }

}
