package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 利用者情報を管理するクラス
 */
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String zipcode;
	private String address;
	private String phone;
	private String email;
	private LocalDate birthday;
	private int role;
	@Column(name = "signuped_on")
	private LocalDateTime signupOn;
	@Column(name = "canceled_on")
	private LocalDateTime canceledOn;

	/**
	 * デフォルトコンストラクタ
	 */
	public User() {
	}

	/**
	 * コンストラクタ
	 * @param name     利用者氏名
	 * @param zipcode  郵便番号
	 * @param address  住所
	 * @param phone    電話番号
	 * @param email    電子メールアドレス
	 * @param birthday 生年月日
	 * @param role     権限コード
	 */
	public User(String name, String zipcode, String address, String phone, String email, LocalDate birthday, int role) {
		this.name = name;
		this.zipcode = zipcode;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.role = role;
		this.signupOn = LocalDateTime.now();
		this.canceledOn = null;
	}

	/**
	 * コンストラクタ
	 * @param id       利用者ID
	 * @param name     利用者氏名
	 * @param zipcode  郵便番号
	 * @param address  住所
	 * @param phone    電話番号
	 * @param email    電子メールアドレス
	 * @param birthday 生年月日
	 * @param role     権限コード
	 */
	public User(int id, String name, String zipcode, String address, String phone, String email, LocalDate birthday,
			int role) {
		this(name, zipcode, address, phone, email, birthday, role);
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

	public LocalDateTime getSignupOn() {
		return signupOn;
	}

	public void setSignupOn(LocalDateTime signupOn) {
		this.signupOn = signupOn;
	}

	public LocalDateTime getCanceledOn() {
		return canceledOn;
	}

	public void setCanceledOn(LocalDateTime canceledOn) {
		this.canceledOn = canceledOn;
	}

}
