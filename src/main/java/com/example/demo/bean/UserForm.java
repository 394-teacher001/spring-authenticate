package com.example.demo.bean;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 画面から入力された情報を管理するJavaBean
 */
public class UserForm {

	/**
	 * フィールド
	 */
	private int id; // 利用者ID
	private String name; // 利用者氏名
	private String zipcode; // 郵便番号
	private String address; // 住所
	private String phone; // 電話番号
	private String email; // 電子メールアドレス
	private String password; // パスワード
	private LocalDate birthday; // 生年月日
	private int role; // 権限コード
	ArrayList<String> errors = new ArrayList<>(); // エラーメッセージリスト

	/**
	 * デフォルトコンストラクタ
	 */
	public UserForm() {
	}

	/**
	 * コンストラクタ
	 * @param name     利用者氏名
	 * @param zipcode  郵便番号
	 * @param address  住所
	 * @param phone    電話番号
	 * @param password パスワード
	 * @param email    電子メールアドレス
	 * @param birthday 生年月日
	 * @param role     権限コード
	 */
	public UserForm(String name, String zipcode, String address, String phone, String email, String password,
			LocalDate birthday,
			int role) {
		this.name = name;
		this.zipcode = zipcode;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.role = role;
	}

	/**
	 * コンストラクタ
	 * @param id        利用者ID
	 * @param name      利用者氏名
	 * @param zipcode   郵便番号
	 * @param address   住所
	 * @param phone     電話番号
	 * @param email     電子メールアドレス
	 * @param passwortd パスワード
	 * @param birthday  生年月日
	 * @param role      権限コード
	 */
	public UserForm(int id, String name, String zipcode, String address, String phone, String email, String password,
			LocalDate birthday,
			int role) {
		this(name, zipcode, address, phone, email, password, birthday, role);
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void addError(String message) {
		this.errors.add(message);
	}

	public ArrayList<String> getErrors() {
		return this.errors;
	}

	public boolean hasError() {
		boolean result = false;
		if (this.errors.size() > 0) {
			result = !result;
		}
		return result;
	}

}
