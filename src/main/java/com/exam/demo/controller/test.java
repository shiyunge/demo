package com.exam.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@PropertySource(value="classpath:/application.properties",encoding = "UTF-8")
public class test {

    @Value("${syg}")
    private String str;

    @RequestMapping("/test")
    public String index_() {
        System.out.print(str);
        return str;
    }

    //解决办法之前创建配置文件的时候并没有给他的编码格式设置为utf-8的格式
    //然后改了文件的格式 之后各种的方法去尝试最后还是行不通
    //最后解决办法是把之前的配置文件删除掉，重新创建了一个文件便行得通了
    //这个自己以后还是需要自己去注意的、、
    //没有跳转的页面那么只会返回到自己的页面上去，也就是页面放回到当前的页面
}
