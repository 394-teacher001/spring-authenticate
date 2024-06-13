package com.example.demo.common;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * 正規表現を利用した文字列操作ユーティリティクラスのテストクラス
 */
class RegexStrungUtilsTest {

	@Nested
	@DisplayName("Validator#isMatchedPhoneFormat(String)のテストクラス")
	class IsMatchedPhineFormatTest {
		@Test
		@DisplayName("Test1006：文字列「0000-00-0000」	は電話番号の書式である")
		void test1006() {
			// setup
			String target = "0000-00-0000";
			// execute & verify
			assertTrue(RegexStringUtils.isMatchedPhoneFormat(target));
		}

		@Test
		@DisplayName("Test1005：文字列「0000-000-0000」	は電話番号の書式である")
		void test1005() {
			// setup
			String target = "0000-000-0000";
			// execute & verify
			assertTrue(RegexStringUtils.isMatchedPhoneFormat(target));
		}

		@Test
		@DisplayName("Test1004：文字列「0000-0000-0000」	は電話番号の書式である")
		void test1004() {
			// setup
			String target = "0000-0000-0000";
			// execute & verify
			assertTrue(RegexStringUtils.isMatchedPhoneFormat(target));
		}

		@Test
		@DisplayName("Test1003：文字列「00-0000-0000」	は電話番号の書式である")
		void test1003() {
			// setup
			String target = "00-0000-0000";
			// execute & verify
			assertTrue(RegexStringUtils.isMatchedPhoneFormat(target));
		}

		@Test
		@DisplayName("Test1002:文字列「0000000-0000」は電話番号の書式ではない")
		void test1002() {
			// setup
			String target = "0000000-0000";
			// execute & verify
			assertFalse(RegexStringUtils.isMatchedPhoneFormat(target));
		}

		@Test
		@DisplayName("Test1001：文字列「000-0000-0000」	は電話番号の書式である")
		void test1001() {
			// setup
			String target = "000-0000-0000";
			// execute & verify
			assertTrue(RegexStringUtils.isMatchedPhoneFormat(target));
		}
	}

	@Nested
	@DisplayName("Validator#isMatched(String, String)のテストクラス")
	class IsMatchedTest {
		@Test
		@DisplayName("Test0903：文字列「おほほおほほおほほ」にはパターン「いひひ」は含まれていない")
		void test0903() {
			// setup
			String target = "おほほおほほおほほ";
			String pattern = "いひひ";
			// execute & verify
			assertFalse(RegexStringUtils.isMatched(target, pattern));
		}

		@Test
		@DisplayName("Test0902：文字列「おほほおほほおほほ」にはパターン「おほほほ」は含まれていない")
		void test0902() {
			// setup
			String target = "おほほおほほおほほ";
			String pattern = "おほほほ";
			// execute & verify
			assertFalse(RegexStringUtils.isMatched(target, pattern));
		}

		@Test
		@DisplayName("Test0901：文字列「おほほおほほおほほ」にはパターン「おほほ」は含まれている")
		void test0901() {
			// setup
			String target = "おほほおほほおほほ";
			String pattern = "おほほ";
			// execute & verify
			assertTrue(RegexStringUtils.isMatched(target, pattern));
		}
	}

	@Nested
	@DisplayName("Validator#replace(String, String)メソッドのテストクラス")
	class ReplaceTest {
		@Test
		@DisplayName("Test07：文字列「吾輩は猫である」に対してパターン「猫」を空文字列「」に置換すると「吾輩はである」である")
		void Test07() {
			// setup
			String target = "吾輩は猫である";
			String replacement = "猪";
			String pattern = "";
			String expected = "猪吾猪輩猪は猪猫猪で猪あ猪る猪";
			// execute & verify
			assertThat(RegexStringUtils.replace(target, pattern, replacement), is(expected));
		}

		@Test
		@DisplayName("Test06：文字列「吾輩は猫である」に対してパターン「猫」を空文字列「」に置換すると「吾輩はである」である")
		void Test06() {
			// setup
			String target = "吾輩は猫である";
			String replacement = "";
			String pattern = "猫";
			String expected = "吾輩はである";
			// execute & verify
			assertThat(RegexStringUtils.replace(target, pattern, replacement), is(expected));
		}

		@Test
		@DisplayName("Test05：文字列「吾輩は猫である」に対してパターンnullを「猪」lに置換するとnullである")
		void Test05() {
			// setup
			String target = "吾輩は猫である";
			String replacement = "猪";
			String pattern = null;
			String expected = null;
			// execute & verify
			assertThat(RegexStringUtils.replace(target, pattern, replacement), is(expected));
		}

		@Test
		@DisplayName("Test04：文字列「吾輩は猫である」に対してパターン「猫」をnullに置換するとnullである")
		void Test04() {
			// setup
			String target = "吾輩は猫である";
			String replacement = null;
			String pattern = "猫";
			String expected = null;
			// execute & verify
			assertThat(RegexStringUtils.replace(target, pattern, replacement), is(expected));
		}

		@Test
		@DisplayName("Test03：nullに対してパターン「猫」を「猪」に置換するとnullである")
		void Test03() {
			// setup
			String target = null;
			String replacement = "猪";
			String pattern = "猫";
			String expected = null;
			// execute & verify
			assertThat(RegexStringUtils.replace(target, pattern, replacement), is(expected));
		}

		@Test
		@DisplayName("Test02：文字列「吾輩は猫である」に対してパターン「猫」を「猪」に置換すると「吾輩は猪である」である")
		void Test02() {
			// setup
			String target = "吾輩は猫である";
			String replacement = "猪";
			String pattern = "猫";
			String expected = "吾輩は猪である";
			// execute & verify
			assertThat(RegexStringUtils.replace(target, pattern, replacement), is(expected));
		}

		@Test
		@DisplayName("Test01：文字列「東京都千代田区」に対してパターン「京都」を「@@」に置換すると「東@@千代田区」である")
		void Test01() {
			// setup
			String target = "東京都千代田区";
			String replacement = "@@";
			String pattern = "京都";
			String expected = "東@@千代田区";
			// execute & verify
			assertThat(RegexStringUtils.replace(target, pattern, replacement), is(expected));
		}
	}
}
