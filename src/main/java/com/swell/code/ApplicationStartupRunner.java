package com.swell.code;

import com.swell.code.platform.helper.SqlHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 应用启动执行
 */
@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {

        //加载sql资源
        SqlHelper.initSqls();
    }
}
