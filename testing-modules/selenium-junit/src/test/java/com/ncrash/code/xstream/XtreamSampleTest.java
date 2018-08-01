package com.ncrash.code.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import java.util.ArrayList;
import org.junit.Test;

/**
 * @author daekwon.kang
 * @since 2010. 6. 10.
 * @see
 */
public class XtreamSampleTest {

  @Test
  public void testXStream() throws Exception {
    PurchaseOrder po = new PurchaseOrder();

    Customer customer = new Customer();
    customer.setCustomerId("cid1");
    customer.setEmail("email@gmail.com");
    po.setCustomer(customer);

    ShippingInfo shippingInfo = new ShippingInfo();
    shippingInfo.setAddress("address1");
    po.setShippingInfo(shippingInfo);

    ArrayList<Product> items = new ArrayList<Product>();
    Product item1 = new Product();
    item1.setProductId("pid1");
    item1.setPrice(100);
    items.add(item1);

    Product item2 = new Product();
    item2.setProductId("pid2");
    item2.setPrice(200);
    items.add(item2);

    po.setItems(items);

    XStream xstream4XML = new XStream();
    xstream4XML.alias("purchaseOrder", PurchaseOrder.class);
    xstream4XML.alias("customer", Customer.class);
    xstream4XML.alias("product", Product.class);
    xstream4XML.alias("shipping", ShippingInfo.class);

    System.out.println("XML RESULT");
    System.out.println(xstream4XML.toXML(po));

    XStream xstream4JSON = new XStream(new JettisonMappedXmlDriver());
    xstream4JSON.alias("purchaseOrder", PurchaseOrder.class);
    xstream4JSON.alias("customer", Customer.class);
    xstream4JSON.alias("product", Product.class);
    xstream4JSON.alias("shipping", ShippingInfo.class);

    System.out.println();
    System.out.println("JSON RESULT");
    System.out.println(xstream4JSON.toXML(po));
  }
}
