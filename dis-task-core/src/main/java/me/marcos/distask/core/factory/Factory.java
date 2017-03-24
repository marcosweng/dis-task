package me.marcos.distask.core.factory;

import me.marcos.distask.core.product.IProduct;

/**
 * Created by marcos on 2017/3/24.
 * <p>
 * 工厂职能：
 * 生产产品
 * 发布可生产的产品
 */
public interface Factory {

    String getFactoryId();

    void produce(IProduct product);

    void publish(IProduct product);
}
