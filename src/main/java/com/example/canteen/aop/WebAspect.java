package com.example.canteen.aop;

import com.example.canteen.model.ResultCode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;


public class WebAspect {

    @Autowired
    private HttpServletRequest request;

    private Gson gson = new Gson();
    private Logger log = Logger.getLogger(getClass());
    private String ip = "";

    //注入断点
    @Pointcut(value = "execution(* com.example.canteen.controller..*.*(..))")
    public void weblog(){}

    //进入断点
    @Around("weblog()")
    private Object checkSecurity(ProceedingJoinPoint pjp) throws Throwable {
        if(request.getHeader("x-forworded-for") == null){
            System.out.println("" + request.getRemoteAddr());
            ip = request.getRemoteAddr();
        }else{
            System.out.println("" + request.getHeader("x-forwarded- for"));
            ip = request.getHeader("x-forwarded- for");
        }
        return pjp.proceed();
    }

    //请求处理之前调用
    @Before(value = "weblog()")
    private void methodBefore(JoinPoint joinPoint){
        log.info("===============请求内容记录===============");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求路径:" + request.getServletPath());
        log.info("请求方式:" + request.getMethod());
        log.info("请求类方法:" + joinPoint.getSignature());
        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        log.info("IP地址：" + ip);
        log.info("===============请求内容记录===============");
        Date date = new Date();
        System.out.println("aop before "+ date);
    }

    //请求处理结束后调用
    @AfterReturning(pointcut = "weblog()", returning = "retValue")
    private void doAfterReturn(JoinPoint joinPoint, Object retValue){
        System.out.println("retValue is : " + retValue.toString());
        try {
            ResultCode resultCode = gson.fromJson(retValue.toString(), new TypeToken<ResultCode>() {}.getType());
            int rs = resultCode.getRs();
            System.out.println("rs = " + rs + ", msg = " + resultCode.getMsg() +
                    ", value = " + resultCode.getValue().toString());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        System.out.println("aop after"+ date);
        log.info("===============请求内容记录===============");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求路径:" + request.getServletPath());
        log.info("请求方式:" + request.getMethod());
        log.info("请求类方法:" + joinPoint.getSignature());
        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        log.info("IP地址：" + ip);
        log.info("===============请求内容记录===============");
    }
}
