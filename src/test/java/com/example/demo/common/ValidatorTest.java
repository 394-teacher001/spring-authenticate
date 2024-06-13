package com.example.demo.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ValidatorTest {

	@Nested
	@DisplayName("Validator#withinRange(int, int, int)メソッドのテストクラス")
	class WithinRangeTest {
		@Test
		@DisplayName("Test82：3は4と6の範囲に入っていない")
		void test82() {
			// setup
			int target = 3;
			int lowerLimit = 4;
			int upperLimit = 6;
			// execute & verify
			assertFalse(Validator.withinRange(target, lowerLimit, upperLimit));
		}

		@Test
		@DisplayName("Test81：5は4と6の範囲に入っている")
		void test81() {
			// setup
			int target = 5;
			int lowerLimit = 4;
			int upperLimit = 6;
			// execute & verify
			assertTrue(Validator.withinRange(target, lowerLimit, upperLimit));
		}
	}

	@Nested
	@DisplayName("Validator#isLessThanEqual(int, int)メソッドのテストクラス")
	class IsLessThanEqualTest {
		@Test
		@DisplayName("Test73：1は0以下ではない")
		void test73() {
			// setyup
			int target = 1;
			int base = 0;
			// execute & verify
			assertFalse(Validator.isLessThanEqual(target, base));
		}

		@Test
		@DisplayName("Test72：0は0以下である")
		void test72() {
			// setyup
			int target = 0;
			int base = 0;
			// execute & verify
			assertTrue(Validator.isLessThanEqual(target, base));
		}

		@Test
		@DisplayName("Test71：-1は0以下である")
		void test71() {
			// setyup
			int target = -1;
			int base = 0;
			// execute & verify
			assertTrue(Validator.isLessThanEqual(target, base));
		}
	}

	@Nested
	@DisplayName("Validator#isLessThan(int, int)メソッドのテストクラス")
	class IsLessThanTest {
		@Test
		@DisplayName("Test62：0は0より小さくない")
		void test62() {
			// setup
			int target = 0;
			int base = 0;
			// execute & verify
			assertFalse(Validator.isLessThan(target, base));
		}

		@Test
		@DisplayName("Test61：-1は0より小さい")
		void test61() {
			// setup
			int target = -1;
			int base = 0;
			// execute & verify
			assertTrue(Validator.isLessThan(target, base));
		}
	}

	@Nested
	@DisplayName("Validator#isGreaterThanEqual(int, int)メソッドのテストクラス")
	class IsGreaterThanEqualTest {
		@Test
		@DisplayName("Test53：-1は0以上ではない")
		void test53() {
			// setup
			int target = -1;
			int base = 0;
			// execute & verify
			assertFalse(Validator.isGreaterThanEqual(target, base));
		}

		@Test
		@DisplayName("Test5：0は0以上である")
		void test52() {
			// setup
			int target = 0;
			int base = 0;
			// execute & verify
			assertTrue(Validator.isGreaterThanEqual(target, base));
		}

		@Test
		@DisplayName("Test51：1は0以上である")
		void test51() {
			// setup
			int target = 1;
			int base = 0;
			// execute & verify
			assertTrue(Validator.isGreaterThanEqual(target, base));
		}

	}

	@Nested
	@DisplayName("Validator#isGreaterThan(int, int)メソッドのテストクラス")
	class IsGreaterThanTest {
		@Test
		@DisplayName("Test41：0は0より大きくない")
		void test42() {
			// setup
			int target = 0;
			int base = 0;
			// execute & verify
			assertFalse(Validator.isGreaterThan(target, base));
		}

		@Test
		@DisplayName("Test41：1は0より大きい")
		void test41() {
			// setup
			int target = 1;
			int base = 0;
			// execute & verify
			assertTrue(Validator.isGreaterThan(target, base));
		}
	}

	@Nested
	@DisplayName("Validator#isNullEmpty(String)メソッドのテストクラス")
	class IsNullEmpty {
		@Test
		@DisplayName("Test33：文字列「hogehoge」が代入された変数はfalseである")
		void test33() {
			// setup
			String target = "hogehoge";
			// execute & verify
			assertFalse(Validator.isNullEmpty(target));
		}

		@Test
		@DisplayName("Test32：空文字列「」が代入された変数はtrueである")
		void test32() {
			// setup
			String target = "";
			// execute & verify
			assertTrue(Validator.isNullEmpty(target));
		}

		@Test
		@DisplayName("Test31：nullが代入された変数はtrueである")
		void test31() {
			// setup
			String target = null;
			// execute & verify
			assertTrue(Validator.isNullEmpty(target));
		}
	}

	@Nested
	@DisplayName("Validator#isEmpty(String)メソッドのテストクラス")
	class IsEmptyTest {
		@Test
		@DisplayName("Test23：nullが代入された変数はfalseである")
		void test23() {
			// setup
			String target = null;
			// execute & verify
			assertFalse(Validator.isEmpty(target));
		}

		@Test
		@DisplayName("Test22：文字列「ほげ」が代入された変数はfalseである")
		void test22() {
			// setup
			String target = "ほげ";
			// execute & verify
			assertFalse(Validator.isEmpty(target));
		}

		@Test
		@DisplayName("Test21：空文字列「」が代入された変数はtrueである")
		void test21() {
			// setup
			String target = "";
			// execute & verify
			assertTrue(Validator.isEmpty(target));
		}
	}

	@Nested
	@DisplayName("Validator#isNull(Object)メソッドのテストクラス")
	class IsNullTest {
		@Test
		@DisplayName("Test12：空文字列「」が代入された変数はfalseである")
		void test13() {
			// setup
			String target = "";
			// execute & verify
			assertFalse(Validator.isNull(target));
		}

		@Test
		@DisplayName("Test12：文字列「null」が代入された変数はfalseである")
		void test12() {
			// setup
			Object target = "null";
			// execute & verify
			assertFalse(Validator.isNull(target));
		}

		@Test
		@DisplayName("Test11：nullが代入された変数はtrueである")
		void test11() {
			// setup
			Object target = null;
			// execute & verify
			assertTrue(Validator.isNull(target));
		}
	}

	@Nested
	@DisplayName("Validator#isRequired(String)メソッドのテストケース")
	class IsRequiredTest {

		@Test
		@DisplayName("Test03：nullが代入されている変数はfalseとなる")
		void test03() {
			// setup
			String target = null;
			// execute
			boolean actual = Validator.isRequired(target);
			// verify
			assertFalse(actual);
		}

		@Test
		@DisplayName("Test02：空文字列「」が代入されている変数はfalseとなる")
		void test02() {
			// setup
			String target = "";
			// execute
			boolean actual = Validator.isRequired(target);
			// verify
			assertFalse(actual);
		}

		@Test
		@DisplayName("Test01：「hoge」が代入されている変数はtrueとなる")
		void test01() {
			// setup
			String target = "hoge";
			// execute
			boolean actual = Validator.isRequired(target);
			// verify
			assertTrue(actual);
		}

	}

}
