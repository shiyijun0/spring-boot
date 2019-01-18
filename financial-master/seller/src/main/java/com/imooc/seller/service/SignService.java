package com.imooc.seller.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 签名服务
 */
@Service
public class SignService  {
    static Map<String,String> PUBLIC_KEYS = new HashMap<>();
    @Value("${public.key}")
    private  String ming;

    @Value("${private.key}")
    private String mi;

    @Value("${authId}")
    private  String authId;

    @Value("${mid}")
    private  String mid;

    @PostConstruct
    private void  init(){
        PUBLIC_KEYS.put(authId,ming);
        PUBLIC_KEYS.put(mid,mi);
    }

    static {
        String publicKey1 ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5sNWySA+cBS+/DjLRk5s/ej1mi81dBBKsaIFb1JYiliW21OwOQAmBZ4flxMysRFZzuvj/C39atL26NhF7Vb124Tn+HmbXepTvDsD2XzkkqZ/+EPOqwH+4xQ92iGznvncIHfMbI2Rl74ysE5PIjmmqsm14twYs6b9Y7b8IqGAtIQIDAQAB";
        PUBLIC_KEYS.put("1000",publicKey1);


    }

    /**
     * 根据授权编号获取公钥
     * @param authId
     * @return
     */
    public String getPublicKey(String authId){
        return PUBLIC_KEYS.get(authId);

    }

    /**
     * 根据授权编号获取公钥
     * @param mid
     * @return
     */
    public String getPrivateKey(String mid){
        return PUBLIC_KEYS.get(mid);

    }
}
