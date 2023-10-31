package oopWithNLayeredApp2.Bussiness;

import oopWithNLayeredApp2.core.logging.Logger;
import oopWithNLayeredApp2.dataAccess.HibernateProductDao;
import oopWithNLayeredApp2.dataAccess.JdbcProductDao;
import oopWithNLayeredApp2.dataAccess.ProductDao;
import oopWithNLayeredApp2.entities.Product;

import java.util.List;

public class ProductManager {
    private ProductDao productDao;
    private Logger[] loggers;

    public ProductManager(ProductDao productDao, Logger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public void add(Product product) throws Exception {
        //iş kuralları yazılır
        if (product.getUnitPrice()<10){
            throw new Exception("Ürün fiyatı 10 dan küçük olamaz");
        }
        productDao.add(product);

        for (Logger logger: loggers) {
            logger.Log(product.getName());
        }
    }
}
