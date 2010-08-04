package com.ncrash.code.h2db;

import static org.h2.jaqu.Function.count;
import static org.h2.jaqu.Function.length;

import java.math.BigDecimal;
import java.util.List;

import org.h2.jaqu.Db;
import org.h2.test.jaqu.Customer;
import org.h2.test.jaqu.Order;
import org.h2.test.jaqu.Product;
import org.junit.Test;


public class JaquTest {
	
    Db db;

    @Test
	public void testJaqu() throws Exception {
    	db = Db.open("jdbc:h2:mem:", "sa", "");
    	db.insertAll(Product.getList());
    	db.insertAll(Customer.getList());
    	db.insertAll(Order.getList());
    	testLength();
    	testCount();
    	testGroup();
    	testSelectManyCompoundFrom2();
    	testWhereSimple4();
    	testSelectSimple2();
    	testAnonymousTypes3();
    	testWhereSimple2();
    	testWhereSimple3();
    	db.close();
	}

    private void testWhereSimple2() throws Exception {
        Product p = new Product();
        List<Product> soldOutProducts =
            db.from(p).
            where(p.unitsInStock).is(0).
            orderBy(p.productId).select();
    }

    private void testWhereSimple3() throws Exception {
        Product p = new Product();
        List<Product> expensiveInStockProducts =
            db.from(p).
            where(p.unitsInStock).bigger(0).
            and(p.unitPrice).bigger(3.0).
            orderBy(p.productId).select();
    }

    private void testWhereSimple4() throws Exception {
        Customer c = new Customer();
        List<Customer> waCustomers =
            db.from(c).
            where(c.region).is("WA").
            select();
    }

    private void testSelectSimple2() throws Exception {
        Product p = new Product();
        List<String> productNames =
            db.from(p).
            orderBy(p.productId).select(p.productName);
    }

    public static class ProductPrice {
        public String productName;
        public String category;
        public Double price;
    }

    private void testAnonymousTypes3() throws Exception {
        final Product p = new Product();
        List<ProductPrice> productInfos =
            db.from(p).orderBy(p.productId).
            select(new ProductPrice() {{
                    productName = p.productName;
                    category = p.category;
                    price = p.unitPrice;
            }});
    }

    public static class CustOrder {
        public String customerId;
        public Integer orderId;
        public BigDecimal total;
    }

    private void testSelectManyCompoundFrom2() throws Exception {
        final Customer c = new Customer();
        final Order o = new Order();
        List<CustOrder> orders =
            db.from(c).
            innerJoin(o).on(c.customerId).is(o.customerId).
            where(o.total).smaller(new BigDecimal("500.00")).
            orderBy(1).
            select(new CustOrder() {{
                customerId = c.customerId;
                orderId = o.orderId;
                total = o.total;
            }});
    }

    private void testLength() throws Exception {
        Product p = new Product();
        List<Integer> lengths =
            db.from(p).
            where(length(p.productName)).smaller(10).
            orderBy(1).
            selectDistinct(length(p.productName));
    }

    private void testCount() throws Exception {
        long count = db.from(new Product()).selectCount();
    }

    public static class ProductGroup {
        public String category;
        public Long productCount;
    }

    private void testGroup() throws Exception {
        final Product p = new Product();
        List<ProductGroup> list =
            db.from(p).
            groupBy(p.category).
            orderBy(1).
            select(new ProductGroup() {{
                category = p.category;
                productCount = count();
            }});
    }

}
