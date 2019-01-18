package com.imooc.seller.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * webhook
 */
@RestController
@RequestMapping("/webhooks")
public class WebHookController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String hook(@RequestBody byte[] bytes){
        System.out.println(new String(bytes));
        return null;
    }
}
