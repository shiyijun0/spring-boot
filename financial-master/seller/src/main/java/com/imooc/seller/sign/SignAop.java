package com.imooc.seller.sign;

import com.imooc.seller.service.SignService;
import com.imooc.util.RSAUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 验签aop
 */
@Component
@Aspect
public class SignAop {


    @Autowired
    private SignService signService;

    @Value("${mid}")
    private  String mid;

    @Pointcut(value = "execution(* com.imooc.seller.controller.*.*(..))")
    public void pointcut(){}

   // @Before(value = "execution(* com.imooc.seller.controller.*.*(..)) && args(authId,sign,text,..)")
    public void verify(String authId,String sign,SignText text){
        String publicKey = signService.getPublicKey(authId);
        System.out.println(publicKey);
        System.out.println(text.toText());
        Assert.isTrue(RSAUtil.verify(text.toText(),sign,publicKey),"验签失败");
    }

    @Before(value = "execution(* com.imooc.seller.controller.*.*(..)) && args(authId,sign,text,..)")
    public void ve(String authId,String sign,SignText text){
        String publicKey = signService.getPublicKey(authId);
        String privateKey = signService.getPrivateKey(mid);
        String sign1=RSAUtil.sign(text.toText(),privateKey);
        System.out.println(sign1);
        Assert.isTrue(RSAUtil.verify(text.toText(),sign,publicKey),"验签失败");

    }
}
