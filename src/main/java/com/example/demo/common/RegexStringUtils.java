package com.example.demo.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正規表現を利用した文字列操作ユーティリティクラス
 */
public class RegexStringUtils {

	/**
	 * クラス定数群
	 */
	private static final String FORMAT_PHONE_NUMBER = "(\\d{2,4}-){2}\\d{4}";

	/**
	 * 文字列のパターンマッチングチェック
	 * @param target  処理対象文字列
	 * @param pattern マッチングパターン文字列
	 * @return 処理対象文字列にマッチングパターンが含まれている場合はtrue、それ以外はfalse
	 */
	public static boolean isMatched(String target, String pattern) {
		Pattern patternString = Pattern.compile(ConvPattern(pattern));
		Matcher matched = patternString.matcher(target);
		return matched.find();
	}

	public static boolean isMatchedPhoneFormat(String target) {
		return isMatched(target, FORMAT_PHONE_NUMBER);
		/*
		Pattern patternString = Pattern.compile(pattern);
		Matcher matched = patternString.matcher(target);
		boolean result = matched.find();
		return result;
		*/
	}

	/**
	 * パターン文字列を正規表現パターンに変換する
	 * @param pattern パターン文字列
	 * @return 変換された正規表現パターン
	 */
	private static String ConvPattern(String pattern) {
		return ".*" + pattern + ".*";
	}

	/**
	 * 文字列を置換する
	 * @param target      処理対象文字列
	 * @param pattern     置換パターン
	 * @param replacement 置換後文字列
	 * @return 処理対象文字列を置換パターンで置換した文字列
	 */
	public static String replace(
			String target,
			String pattern,
			String replacement) {
		String result = null;
		if (!(Validator.isNull(target) || Validator.isNull(replacement) || Validator.isNull(pattern))) {
			result = target.replace(pattern, replacement);
		}
		return result;
	}
}
