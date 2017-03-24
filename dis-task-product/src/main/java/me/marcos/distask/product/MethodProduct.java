package me.marcos.distask.product;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.marcos.distask.core.product.IProduct;

import java.util.Properties;

/**
 * Created by marcos on 2017/3/24.
 */
@Data
@Builder
@NoArgsConstructor
public class MethodProduct implements IProduct {
    private String id;
    private String name;
    private Properties properties;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Properties getProperties() {
        return this.properties;
    }
}
