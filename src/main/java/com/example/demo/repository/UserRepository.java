package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * 電子メールアドレスが一致する利用者を取得する
	 * @param email 電子メールアドレス
	 * @return 一致した利用者クラスのインスタンス
	 */
	User findByEmail(String email);

}
