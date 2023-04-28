package com.example.bishe_.common;


import com.example.bishe_.config.R;
import com.example.bishe_.util.JwtUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {
    @Value("${shiXun.kind}")
    private String kindPath;

    @Value("${shiXun.product}")
    private String productPath;

    @Value("${shiXun.addProduct}")
    private String addProductPath;

    @Value("${shiXun.user}")
    private String userPath;

    private String basePath;



    @ApiOperation("检验令牌")
    @GetMapping("/checkToken")
    public R checkToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        boolean result = JwtUtils.checkToken(token);
        System.err.println(11111);
        if (result) {
            return R.success("检验成功");
        } else {
            return R.error("当前未登录");
        }
    }


    /**
     * 将图片下载到页面，再页面中展示。以流的方式传输
     *
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response, String type) {
        log.warn("type值为{}",type);
        if ("kind".equals(type)) {
            basePath = kindPath;
        } else if ("add".equals(type)) {
            basePath = addProductPath;
        } else if ("user".equals(type)) {
            basePath = userPath;
        } else {
            basePath = productPath;
        }
        try {
            //输入流，通过输入流找到并读取文件内容
            System.out.println(basePath + name);
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));
            //输出流，通过输出流将文件写回浏览器，最终再浏览器展示图片
            ServletOutputStream outputStream = response.getOutputStream();//通过响应对象获取输出流对象

            response.setContentType("image/jpeg");//说明响应回去的到底是什么类型文件，这里是固定写法

            int len = 0;
            byte[] bytes = new byte[1024];

            //InputStream.read() 和 OutputStream.write()方法组合使用可以完成文件的复制功能。
            //从输入流读取 b (2048)个字节，并将它们存储到缓冲区b ，如到输入流到末尾则返回-1。所以这里当len为-1表示读取完毕
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);//：指定的字节;off:数组b中将写⼊数据的初始偏移量；len：要读取的最⼤字节数
                outputStream.flush(); //刷新
            }
            //关闭资源
            outputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }








}
