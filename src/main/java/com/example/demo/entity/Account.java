package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int role;
	private String name;
	private String email;
	private String password;

	/**
	 * デフォルトコンストラクタ
	 */
	public Account() {
	}

	/**
	 * コンストラクタ
	 * @param name     アカウント名
	 * @param email    メールアドレス
	 * @param password パスワード
	 */
	public Account(int role, String name, String email, String password) {
		this.role = role;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	/**
	 * コンストラクタ
	 * @param id       アカウントID
	 * @param name     アカウント名
	 * @param email    メールアドレス
	 * @param password パスワード
	 */
	public Account(int id, int role, String name, String email, String password) {
		this(role, name, email, password);
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
