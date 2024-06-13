package com.example.demo.model;

public class Item {

	/**
	 * フィールド
	 */
	private int id; // 商品ID
	private String name; // 商品名
	private int price; // 価格

	/**
	 * デフォルトコンストラクタ
	 */
	public Item() {
	}

	/**
	 * コンストラクタ
	 * @param name  商品名
	 * @param price 価格
	 */
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * コンストラクタ
	 * @param id    商品ID
	 * @param name  商品名
	 * @param price 価格
	 */
	public Item(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
