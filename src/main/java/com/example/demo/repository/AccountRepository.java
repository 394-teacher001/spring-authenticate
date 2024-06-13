package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	/**
	 * メールアドレスとパスワードの組み合わせが一致するアカウントを取得する
	 * SELECT * FROM accounts WHERE email = :email AND password = :password
	 * @param email    メールアドレス
	 * @param password パスワード
	 * @return メールアドレスとパスワードが一致したアカウントのインスタンス
	 */
	Account findByEmailAndPassword(String email, String password);

}
