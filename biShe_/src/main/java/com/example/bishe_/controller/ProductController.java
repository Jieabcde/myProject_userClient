package com.example.bishe_.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bishe_.config.R;
import com.example.bishe_.entity.Product;
import com.example.bishe_.entity.ProductKind;
import com.example.bishe_.model.ProductDetailModel;
import com.example.bishe_.service.ProductKindService;
import com.example.bishe_.service.ProductReviewService;
import com.example.bishe_.service.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/product")
@CrossOrigin
@Slf4j
public class ProductController {


    @Autowired
    private ProductKindService productKindService;

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "商品分类列表", notes = "商品分类列表")
    @GetMapping("/getCategory")
    public R getCategory() {
        List<ProductKind> productList=productKindService.getCategory();
        return R.success(productList);
    }


    @ApiOperation(value = "获取销量最好的前9个商品", notes = "获取销量最好的前9个商品")
    @GetMapping("/getProductListLimitNine")
    public R getProductListLimitNine() {
        List<Product> productList=productService.getProductListLimitNine();
        return R.success(productList);
    }


    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page")
    public R getPage(Integer page, Integer pageSize, String searchName,Integer kid) {
        Page<Product> pageInfo = new Page<>(page, pageSize);
        productService.getPageInfo(pageInfo, searchName,kid);
        return R.success(pageInfo);
    }

    @ApiOperation(value = "商品详情", notes = "商品详情")
    @GetMapping("/detail")
    public R getProductDetail(Integer pid) {
        ProductDetailModel productDetailModel = productService.getProductDetail(pid);
        return R.success(productDetailModel);
    }




}

