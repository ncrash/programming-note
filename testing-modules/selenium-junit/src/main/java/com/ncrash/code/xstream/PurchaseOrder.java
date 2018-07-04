package com.ncrash.code.xstream;

/**
 * @author daekwon.kang
 * @since 2010. 6. 10.
 * @see
 */

import java.util.List;

public class PurchaseOrder {
  Customer customer;
  List<Product> items = null;
  ShippingInfo shippingInfo;

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<Product> getItems() {
    return items;
  }

  public void setItems(List<Product> items) {
    this.items = items;
  }

  public ShippingInfo getShippingInfo() {
    return shippingInfo;
  }

  public void setShippingInfo(ShippingInfo shippingInfo) {
    this.shippingInfo = shippingInfo;
  }
}
