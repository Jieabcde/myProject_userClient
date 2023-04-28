package com.example.bishe_.controller;


import com.example.bishe_.config.R;
import com.example.bishe_.entity.Product;
import com.example.bishe_.entity.ProductReview;
import com.example.bishe_.model.ProductDetailModel;
import com.example.bishe_.service.ProductReviewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/productReview")
@CrossOrigin
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    @ApiOperation(value = "新增评论", notes = "新增评论")
    @PostMapping("/addReview")
    public R getProductDetail(@RequestBody ProductReview productReview) {
        productReviewService.addReview(productReview);
        return R.success("评论成功");
    }
}

