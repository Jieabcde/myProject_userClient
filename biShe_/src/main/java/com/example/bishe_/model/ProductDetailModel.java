package com.example.bishe_.model;

import com.example.bishe_.entity.Product;
import com.example.bishe_.entity.ProductLable;
import com.example.bishe_.entity.ProductReview;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDetailModel extends Product {

    private ProductLable productLable;//商品标签

    private List<ProductReviewModel> productReviewModelList; //商品评论

    private String kname;  //分类名

    private Integer reviewCount; //评论数量

}
