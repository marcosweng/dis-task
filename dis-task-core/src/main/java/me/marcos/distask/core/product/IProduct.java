package me.marcos.distask.core.product;

import java.util.Properties;

/**
 * Created by marcos on 2017/3/24.
 * 产品要素：
 *  产品名称
 *  产品配置
 */
public interface IProduct {
    String getId();
    String getName();
    Properties getProperties();
}
