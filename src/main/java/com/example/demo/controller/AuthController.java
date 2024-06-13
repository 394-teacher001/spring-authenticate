package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.vAccount;
import com.example.demo.model.Login;
import com.example.demo.repository.vAccountRepository;

import jakarta.servlet.http.HttpSession;

/**
 * ユーザ認証に関する処理を制御するコントローラ
 */
@Controller
public class AuthController {

	@Autowired
	HttpSession session;

	@Autowired
	Login login;

	@Autowired
	vAccountRepository vaccountRepository;

	/**
	 * ログイン処理を実行する
	 * @param email    メールアドレス
	 * @param password パスワード
	 * @param model    遷移先Thymeleafテンプレート名
	 * @return
	 */
	@PostMapping("/login")
	public String login(
			@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password,
			Model model) {
		// リクエストパラメータに合致したアカウントのインスタンスを取得
		vAccount account = vaccountRepository.findByEmailAndPassword(email, password);
		if (account == null) {
			// インスタンスを取得できなかった場合⇒認証失敗
			model.addAttribute("message", "メールアドレスとパスワードが一致しませんでした");
			return "login";
		}
		// インスタンスを取得できた場合⇒認証成功：ログイン情報をセッションに登録
		login.setEmail(account.getEmail());
		login.setName(account.getName());
		login.setRole(account.getRole());
		// 画面遷移
		return "top";
	}

	/**
	 * ログイン画面を表示する
	 * @return 遷移先Thymeleafテンプレート名
	 */
	@GetMapping({ "/", "/login", "/logout" })
	public String index() {
		// セッションの破棄
		session.invalidate();
		// 画面遷移
		return "login";
	}
}
