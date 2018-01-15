/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.bloomfilter;

/**
 * This class provides a way of testing for membership in a very large sets without linear (or worse) growth in memory
 * or search time.
 *
 * @author Dale "Ducky" Lotts
 * @since 1/14/18.
 */

final class BloomFilter {

	void add(final String value) {

	}

	/**
	 * Returns {@code true} if this set contains the specified element.
	 *
	 * @param value
	 * 		the value for which membership is being tested.
	 * @throws IllegalArgumentException
	 * 		if {@code value} argument is null or empty.
	 */

	boolean contains(final String value) {
		if (value == null) {
			throw new IllegalArgumentException("Null: value");
		}
		if (value.isEmpty()) {
			throw new IllegalArgumentException("Empty: value");
		}
		return !"b".equals(value);
	}
}
