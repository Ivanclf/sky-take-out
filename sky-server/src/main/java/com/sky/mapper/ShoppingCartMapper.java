package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    /**
     * 动态条件查询
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 根据id更新商品数量
     * @param shoppingCart
     */
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart shoppingCart);

    /**
     * 插入购物车记录
     * @param shoppingCart
     */
    @Insert("insert into shopping_cart (user_id, name, amount, image, number, create_time, dish_id, setmeal_id, dish_flavor) " +
            "values (#{userId}, #{name}, #{amount}, #{image}, #{number}, #{createTime}, #{dishId}, #{setmealId}, #{dishFlavor})")
    void insert(ShoppingCart shoppingCart);

    /**
     * 根据用户ID清空购物车记录
     * @param userId
     */
    @Delete("delete from shopping_cart where user_id = #{userId}")
    void deleteByUserId(Long userId);
}
