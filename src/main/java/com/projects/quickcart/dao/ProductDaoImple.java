package com.projects.quickcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projects.quickcart.dto.ProductForm;
import com.projects.quickcart.entity.Product;
import com.projects.quickcart.entity.Retailer;

@Repository
public class ProductDaoImple implements ProductDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Product> allProducts() {

		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();
		Query query = ss.createQuery("from Product");
		List<Product> productList = query.getResultList();
		System.out.println("Product List" + productList);
		return productList;
	}

	@Override
	public Product getProductById(int productId) {

		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = session.get(Product.class, productId);
		transaction.commit();
		return product;
	}

	@Override
	public List<Product> findProduct(String category) {

		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();

		String hql = "from Product p where p.category= :category";
		List<Product> products = ss.createQuery(hql, Product.class).setParameter("category", category).list();

		t.commit();
		return products;
	}

	@Override
	public List<Product> getRetailerProducts(long retailerId) {
		return sf.fromSession(session -> {
			var query = session.createQuery("from Product p where p.retailer.id = :id", Product.class);
			query.setParameter("id", retailerId);
			return query.getResultList();
		});
	}

	@Override
	public void addProduct(ProductForm form, Long id) {
		Product product = new Product();
		product.setTitle(form.getTitle());
		product.setDescription(form.getDescription());
		product.setPrice(form.getPrice());
		product.setCategory(form.getCategory());

		sf.inTransaction(session -> {
			var re = session.get(Retailer.class, id);
			product.setRetailer(re);
			session.persist(product);
		});
	}

}
