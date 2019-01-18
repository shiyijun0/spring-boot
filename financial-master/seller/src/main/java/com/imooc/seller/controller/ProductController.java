package com.imooc.seller.controller;

import com.imooc.entity.Product;
import com.imooc.seller.service.ProductRpcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 产品相关
 */
@RestController
@RequestMapping("/product")
@Api(tags = "产品控制器")
public class ProductController {

    @Autowired
    private ProductRpcService productRpcService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findOne(@PathVariable String id){
        return productRpcService.findOne(id);
    }

    @PostMapping("/save")
    public Product save(Product product){
        return productRpcService.save(product);
    }

    @PostMapping("/save1")
    @ApiOperation(value = "保存产品")
    public Product saveproduct(@RequestBody Product product){
        return productRpcService.save(product);
    }

}
