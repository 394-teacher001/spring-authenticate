package com.example.demo.common;

/**
 * データの妥当性検証メソッドを提供する共通クラス
 */
public class Validator {

	/**
	 * 必須入力チェック
	 * @param target チェック対象変数
	 * @return nullまたは空文字列「」の場合はfalse、それ以外はtrue
	 */
	public static boolean isRequired(String target) {
		boolean result = true;
		if (isNull(target) || target.isEmpty()) {
			result = !result;
		}
		return result;
	}

	/**
	 * Null値チェック
	 * @param target チェック対象変数
	 * @return nullの場合はtrue、それ以外はfalse
	 */
	public static boolean isNull(Object target) {
		boolean result = true;
		if (target != null) {
			result = !result;
		}
		return result;
	}

	/**
	 * 空文字チェック
	 * @param target チェック対象変数
	 * @return 空文字の場合はtrue、それ以外はfalse
	 */
	public static boolean isEmpty(String target) {
		boolean result = true;
		if (target == null || target.length() > 0) {
			result = !result;
		}
		return result;
	}

	/**
	 * Null・空文字チェック
	 * @param target チェック対象変数
	 * @return nullまたは空文字の場合はtrue、それ以外はfalse
	 */
	public static boolean isNullEmpty(String target) {
		boolean result = true;
		if (!isNull(target) && !isEmpty(target)) {
			result = !result;
		}
		return result;
	}

	/**
	 * 指定範囲超チェック
	 * @param target チェック対象変数
	 * @param base   指定範囲下限値
	 * @return チェック対象変数が指定範囲下限より大きい場合はtrue、それ以外はfalse
	 */
	public static boolean isGreaterThan(int target, int base) {
		boolean result = false;
		if (base < target) {
			result = !result;
		}
		return result;
	}

	/**
	 * 指定範囲以上チェック
	 * @param target チェック対象変数
	 * @param base   指定範囲下限値
	 * @return チェック対象変数が指定範囲下限以上である場合はtrue、それ以外はfalse
	 */
	public static boolean isGreaterThanEqual(int target, int base) {
		boolean result = true;
		if (target < base) {
			result = !result;
		}
		return result;
	}

	/**
	 * 指定範囲未満チェック
	 * @param target チェック対象変数
	 * @param base   指定範囲上限値
	 * @return チェック対象変数が指定範囲上限未満である場合はtrue、それ以外はfalse
	 */
	public static boolean isLessThan(int target, int base) {
		boolean result = true;
		if (!(target < base)) {
			result = !result;
		}
		return result;
	}

	/**
	 * 指定範囲以下チェック
	 * @param target チェック対象変数
	 * @param base   指定範囲上限値
	 * @return チェック対象変数が指定範囲上限以下である場合はtrue、それ以外はfalse
	 */
	public static boolean isLessThanEqual(int target, int base) {
		boolean result = true;
		if (!(target <= base)) {
			result = !result;
		}
		return result;
	}

	/**
	 * 指定範囲に入っているかどうかのチェック
	 * @param target チェック対象変数
	 * @param lowerLimit 指定範囲下限値
	 * @param upperLimit　指定範囲上限値
	 * @return チェック対象変数が指定範囲の下限値以上上限値以下である場合はtrue、それ以外はfalse
	 */
	public static boolean withinRange(int target, int lowerLimit, int upperLimit) {
		boolean result = true;
		if (!(isGreaterThanEqual(target, lowerLimit) && isLessThanEqual(target, upperLimit))) {
			result = !result;
		}
		return result;
	}

}
