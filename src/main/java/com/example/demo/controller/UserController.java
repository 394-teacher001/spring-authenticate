package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.UserForm;
import com.example.demo.common.Validator;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;

/**
 * 利用者に関する処理を制御するコントローラ
 */
@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AccountRepository accountRepository;

	/**
	 * 利用者登録処理を実行する
	 * @param name
	 * @param zipcode
	 * @param address
	 * @param phone
	 * @param email
	 * @param password
	 * @param birthday
	 * @param role
	 * @param model
	 * @return
	 */
	@PostMapping("/user/entry")
	public String store(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "zipcode", defaultValue = "") String zipcode,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "phone", defaultValue = "") String phone,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "password", defaultValue = "") String password,
			@RequestParam(name = "birthday", defaultValue = "") LocalDate birthday,
			@RequestParam(name = "role", defaultValue = "1") Integer role,
			Model model) {
		// リクエストパラメータからUserクラスをインスタンス化
		User user = new User(name, zipcode, address, phone, email, birthday, role);
		// 利用者クラスのインスタンスをusersテーブルに永続化
		userRepository.save(user);
		// リクエストからAccountクラスをインスタンス化
		Account account = new Account(role, name, email, password);
		// Accountクラスのインスタンスをaccountsテーブルに永続化
		accountRepository.save(account);
		// 画面遷移
		return "login";
	}

	/**
	 * 利用者登録情報の確認画面を表示する
	 * @param name
	 * @param zipcode
	 * @param address
	 * @param phone
	 * @param email
	 * @param password
	 * @param birthday
	 * @param role
	 * @param model スコープ
	 * @return 遷移先Thymeleafテンプレート名
	 */
	@PostMapping("/user/confirm")
	public String confirm(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "zipcode", defaultValue = "") String zipcode,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "phone", defaultValue = "") String phone,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "password", defaultValue = "") String password,
			@RequestParam(name = "birthday", defaultValue = "") LocalDate birthday,
			@RequestParam(name = "role", defaultValue = "1") Integer role,
			Model model) {
		// Userインスタンスに属性を設定
		UserForm userForm = this.validate(name, zipcode, address, phone, email, password, birthday, role);
		// Userインスタンスをスコープに設定
		model.addAttribute("user", userForm);
		// エラーの有無で遷移先URLを分岐
		String nextURL = "";
		if (userForm.hasError()) {
			// エラーがある場合：自画面遷移
			nextURL = "user/entry";
		} else {
			// エラーがない場合：確認画面に遷移
			nextURL = "user/confirm";
		}
		// 画面遷移
		return nextURL;
	}

	/**
	 * 利用者登録画面を表示する
	 * @return 遷移先Thymeleafテンプレート名
	 */
	@GetMapping("/user/entry")
	public String index(Model model) {
		// 画面表示用ダミーUserをインスタンス化
		UserForm userForm = new UserForm();
		model.addAttribute("user", userForm);
		// 画面遷移
		return "user/entry";
	}

	/**
	 * 入力値妥当性検査
	 * @param name     利用者名
	 * @param zipcode  郵便番号
	 * @param address  住所
	 * @param phone    電話番号
	 * @param email    電子メールアドレス
	 * @param password パスワード
	 * @param birthday 生年月日
	 * @param role     権限コード
	 * @return UserFormクラスのインスタンス
	 */
	private UserForm validate(String name, String zipcode, String address, String phone, String email,
			String password, LocalDate birthday, Integer role) {
		UserForm user = new UserForm(name, zipcode, address, phone, email, password, birthday, role);
		// 利用者氏名のチェック
		if (!Validator.isRequired(name)) {
			user.addError("利用者氏名は必須です。");
		}
		if (!Validator.isRequired(email)) {

		}
		// 電話番号チェック
		if (!Validator.isRequired(phone)) {
			user.addError("電話番号は必須です。");
		}
		// 電子メールアドレスのチェック
		if (!Validator.isRequired(email)) {
			user.addError("電子メールアドレスは必須です。");
		} else if (userRepository.findByEmail(email) != null) {
			user.addError("すでに登録された電子メールアドレスなので変更してください。");
		}
		// パスワードのチェック
		if (!Validator.isRequired(password)) {
			user.addError("パスワードは必須です。");
		}
		// UserFormインスタンスを返却
		return user;
	}
}
