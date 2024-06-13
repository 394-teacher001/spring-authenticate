package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.vAccount;

public interface vAccountRepository extends JpaRepository<vAccount, Integer> {

	/**
	 * メールアドレスとパスワードからログインに必要な登録情報を取得する
	 * @param email    メールアドレス
	 * @param password パスワード
	 * @return 登録情報がある場合はvAccountクラスのインスタンス、それ以外はnull
	 */
	vAccount findByEmailAndPassword(String email, String password);

}
