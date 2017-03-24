package me.marcos.distask.product;

import me.marcos.distask.core.product.IProduct;
import me.marcos.distask.product.annotations.Product;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by marcos on 2017/3/24.
 */
public class AnnotationProductScannerConfigurer implements ApplicationContextAware {


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {


        Map<String, Object> services = applicationContext.getBeansWithAnnotation(Product.class);

        //解析定时表达式配置
        services
                .values()
                .stream()
                .map((product) -> {
                    return parseAnnotationProduct(product);
                })
                .flatMap((products) -> products.stream())
                .forEach((product -> {
                    //产品收集完毕
                }));
    }

    private List<IProduct> parseAnnotationProduct(Object productService) {
        //解析taskService上的配置
        return Arrays.stream(productService.getClass().getMethods())
                .filter(method -> method.getAnnotation(Product.class) != null)
                .map(method -> {
                    Product product = method.getAnnotation(Product.class);
                    Properties properties = new Properties();
                    properties.put("description", product.description());
                    return MethodProduct.builder()
                            .id(product.getClass().getName() + "." + method.getName())
                            .name(product.value())
                            .properties(properties)
                            .build();
                })
                .collect(Collectors.toList());


    }
}
