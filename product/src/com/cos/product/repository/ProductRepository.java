package com.cos.product.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.product.db.DBConn;
import com.cos.product.model.Product;
import com.cos.product.model.type;


public class ProductRepository {
	private static final String TAG = "ProductRepository :";
	private static ProductRepository instance = new ProductRepository();
	private ProductRepository() {}
	public static ProductRepository getInstance() {
		return instance;
	}
	
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection conn = null;
	
	
	
	//findall asc
	public List<Product> findAll() {
		
		final String SQL = "SELECT * FROM product ORDER BY id";
		try {
			
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			List<Product> products = new ArrayList<>();
			// while문 
			while (rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(type.valueOf(rs.getString(3)))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
				
			}
				return products;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+" findAll : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	//가격순 desc
	public List<Product> price() {
		final String SQL = "SELECT * FROM product ORDER BY price DESC";
				
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			List<Product> products = new ArrayList<>();
			
			// while문 
			while (rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(type.valueOf(rs.getString(3)))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
			}
			return products;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+" price : "+e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	//판매순 desc
	public List<Product> count() {
		final String SQL = "SELECT * FROM product ORDER BY count DESC ";
		List<Product> products = new ArrayList<>();
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			// while문 
			while (rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(type.valueOf(rs.getString(3)))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+" count : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int remove(int id) {
		final String SQL = "DELETE FROM product WHERE id = ? ";
		List<Product> products = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			//물음표 완성
			pstmt.setInt(1, id);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG+" remove : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return -1;
	}
}
