package com.example.bishe_.model;

import com.example.bishe_.entity.ProductReview;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductReviewModel extends ProductReview {

    private String utel; //电话

    private String image; //头像存储位置
}
