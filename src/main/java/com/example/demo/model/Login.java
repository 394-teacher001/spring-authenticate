package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * セッションに登録するログイン情報を保持するModel
 * TODO:DTOとするかモデル（JavaBean）とするかは要検討
 */
@Component
@SessionScope
public class Login {

	/**
	 * フィールド
	 */
	private String name; // アカウント名
	private String email; // メールアドレス
	private int role; // 権限コード

	/**
	 * デフォルトコンストラクタ
	 */
	public Login() {
	}

	/**
	 * コンストラクタ
	 * @param name  アカウント名
	 * @param email メールアドレス
	 * @param role  権限コード
	 */
	public Login(int role, String email, String name) {
		this.role = role;
		this.email = email;
		this.name = name;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
