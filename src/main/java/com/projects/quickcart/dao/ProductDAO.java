package com.projects.quickcart.dao;

import java.util.List;

import com.projects.quickcart.entity.Product;

public interface ProductDAO {
  List<Product> allProducts();
}
