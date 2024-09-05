package com.projects.quickcart.service;

import java.util.List;

import com.projects.quickcart.entity.Products;

public interface RetailerService {
  List<Products> getProducts(Long id);
}
