package com.osi.oneconnect.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MailUtil {
	
	public static String concatenate(List<String> listOfItems, String separator) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> stit = listOfItems.iterator();

		while (stit.hasNext()) {
			sb.append(stit.next());
			if (stit.hasNext()) {
				sb.append(separator);
			}
		}

		return sb.toString();
	}
	
	
	/**
	 * Checks if is collection empty.
	 *
	 * @param collection the collection
	 * @return true, if is collection empty
	 */
	private static boolean isCollectionEmpty(Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if is object empty.
	 *
	 * @param object the object
	 * @return true, if is object empty
	 */
	public static boolean isObjectEmpty(Object object) {
		if(object == null) return true;
		else if(object instanceof String) {
			if (((String)object).trim().length() == 0) {
				return true;
			}
		} else if(object instanceof Collection) {
			return isCollectionEmpty((Collection<?>)object);
		}
		return false;
	}

	/**
	 * Converts each word separated by white space to title case.
	 *
	 * Note: Replaces multiple whitespaces between words with a single space.
	 * */
	public static String toTitleCase(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}

		String[] words = str.split("\\s+");
		StringBuilder result = new StringBuilder();
		for (String eachWord : words) {

			result.append(Character.toTitleCase(eachWord.charAt(0)))
					.append(eachWord.substring(1).toLowerCase())
					.append(" ");
		}

		if (
				result.length() > 0
				&& result.charAt(result.length() - 1) == ' '
		) {
			result.deleteCharAt(result.length() - 1);
		}

		return result.toString();
	}

}
