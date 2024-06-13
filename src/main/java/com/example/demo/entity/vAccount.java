package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaccounts")
public class vAccount {
	@Id
	private int id;

	private String name;
	private String email;
	private int role;
	private String password;

	/**
	 * デフォルトコンストラクタ
	 */
	public vAccount() {
	}

	/**
	 * コンストラクタ
	 * @param id    アカウントID
	 * @param name  アカウント名
	 * @param email メールアドレス
	 * @param role  権限コード
	 */
	public vAccount(int id, String name, String email, int role, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
