package com.imooc.api;


import com.googlecode.jsonrpc4j.JsonRpcService;
import com.imooc.api.domain.ParamInf;
import com.imooc.api.domain.ProductRpcReq;
import com.imooc.entity.Product;
import org.h2.store.Page;
//import org.springframework.data.domain.Page;

import java.util.List;

/** 
*@ClassName: ProductRpc 
*@Description: 
*@user: DELL
*@Author: shiyijun
*@Date: 2019/1/17 
*/ 
@JsonRpcService
public interface ProductRpc {
    /**
     * 查询多个产品
     *
     * @param req
     * @return
     */
    List<Product> query(ParamInf req);

    /**
     * 查询单个产品
     *
     * @param id
     * @return
     */
    Product findOne(String id);

  
   /**
    * @Description:
    * @MethodName:
    * @Param: pro
    * @return: pr
    * @Author: shiyijun
    * @Date: 2019/1/17
    */
    Product save(Product product);



}
