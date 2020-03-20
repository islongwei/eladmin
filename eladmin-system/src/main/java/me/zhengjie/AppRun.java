package me.zhengjie;

import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.utils.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zheng Jie
 * @date 2018/11/15 9:20:19
 */
@EnableAsync
@RestController
@SpringBootApplication
@EnableTransactionManagement
public class AppRun {

    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
        System.out.println("*******************************************\n" +
                "*                                         *\n" +
                "*******************************************\n" +
                "           _.._        ,-------------------.\n" +
                "        ,'      `.    ( 启动成功！开启学习之旅！          )\n" +
                "       /  __) __` \\    `-,-----------------'\n" +
                "      (  (`-`(-')  ) _.-'\n" +
                "      /)  \\  = /  (\n" +
                "     /'    |--' .  \\\n" +
                "    (  ,---|  `-.)__`\n" +
                "     )(  `-.,--'   _`-.\n" +
                "    '/,'          (  Uu\",\n" +
                "     (_       ,    `/,-' )\n" +
                "     `.__,  : `-'/  /`--'\n" +
                "       |     `--'  |\n" +
                "       `   `-._   /\n" +
                "        \\        (\n" +
                "        /\\ .      \\. \n" +
                "       / |` \\     ,-\\\n" +
                "      /  \\| .)   /   \\\n" +
                "     ( ,'|\\    ,'     :\n" +
                "     | \\,`.`--\"/      }\n" +
                "     `,'    \\  |,'    /\n" +
                "    / \"-._   `-/      |\n" +
                "    \"-.   \"-.,'|     ;\n" +
                "   /        _/[\"---'\"\"]\n" +
                "  :        /  |\"-     '\n" +
                "  '           |      /\n" +
                "              `      |");
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

    @Bean
    public ServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory fa = new TomcatServletWebServerFactory();
        fa.addConnectorCustomizers(connector -> connector.setProperty("relaxedQueryChars", "[]{}"));
        return fa;
    }

    /**
     * 访问首页提示
     * @return /
     */
    @GetMapping("/")
    @AnonymousAccess
    public String index() {
        return "Backend service started successfully";
    }
}
