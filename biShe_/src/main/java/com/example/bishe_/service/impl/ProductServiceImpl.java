package com.example.bishe_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bishe_.entity.*;
import com.example.bishe_.mapper.ProductMapper;
import com.example.bishe_.model.ProductDetailModel;
import com.example.bishe_.model.ProductReviewModel;
import com.example.bishe_.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bishe_.util.TypeTransUtil;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangYanJie
 * @since 2023-03-16
 */
@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductReviewService productReviewService;

    @Autowired
    private ProductLableService productLableService;

    @Autowired
    private ProductKindService productKindService;

    @Autowired
    private UserService userService;



    @Override
    public List<Product> getProductListLimitNine() {
        return lambdaQuery().eq(Product::getPstatus, 1).last("LIMIT 9").list();
    }


    @Override
    public Page<Product> getPageInfo(Page<Product> pageInfo, String searchName,Integer kid) {
        log.info(searchName);
        LambdaQueryWrapper<Product> productLambdaQueryWrapper = new LambdaQueryWrapper<>();
        productLambdaQueryWrapper.like(searchName != null, Product::getPname, searchName);
        productLambdaQueryWrapper.eq(kid != null, Product::getKid, kid);
        this.page(pageInfo, productLambdaQueryWrapper);
        return null;
    }

    @Override
    public ProductDetailModel getProductDetail(Integer pid) {
        Product product = this.getById(pid);

        ProductDetailModel productDetailModel = new ProductDetailModel();

        BeanUtils.copyProperties(product, productDetailModel);

        //查找对应的评论
        //这些对应的评论都有用户id，通过用户id找到用户名字，用户头像位置，然后封装到ProductReviewModel
        List<ProductReview> productReviewList =productReviewService.getReviewByPid(pid);

        if (productReviewList.size() > 0) {
            List<ProductReviewModel> productReviewModelList = TypeTransUtil.entityListToModelList(productReviewList, ProductReviewModel.class); //用户名，存储头像

            //存用户id的集合
            List<Integer> uidList = productReviewModelList
                    .stream()
                    .map(ProductReviewModel::getUid)
                    .collect(Collectors.toList());

            Map<Integer, User> userInfoMap = userService.getUserInfo(uidList)
                    .stream()
                    .collect(Collectors.toMap(User::getUid, u -> u));

            productReviewModelList.forEach(p -> {
                User user = userInfoMap.get(p.getUid());
                p.setUtel(user.getUtel());
                p.setImage(user.getImage());
            });
            productDetailModel.setProductReviewModelList(productReviewModelList);
        }


        //查找对应的标签
        ProductLable productLable = productLableService.getLableByPid(pid);

        //查找此商品分类名
        String kname = productKindService.getKnameByPid(product.getKid());

        productDetailModel.setReviewCount(productReviewList.size());

        productDetailModel.setProductLable(productLable);
        productDetailModel.setKname(kname);

        return productDetailModel;
    }

    @Override
    public void reductStock(List<UserCart> userCartList) {
        Map<Integer, Integer> reduceStockMap = userCartList.stream()
                .collect(Collectors.toMap(UserCart::getPid, UserCart::getCartcount));

        List<Integer> pidList = userCartList.stream().map(UserCart::getPid).collect(Collectors.toList());

        List<Product> dbPidProductList = lambdaQuery().in(Product::getPid, pidList).list();

        dbPidProductList.forEach(product -> {
            product.setPstock(product.getPstock() - reduceStockMap.get(product.getPid()));
            product.setPmonthsale(product.getPmonthsale() + reduceStockMap.get(product.getPid()));
        });

        this.updateBatchById(dbPidProductList);
    }
}
