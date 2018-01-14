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

	/**
	 * Returns {@code true} if this set contains the specified element.
	 *
	 * @param value
	 * 		the value for which membership is being tested.
	 *
	 * @throws IllegalArgumentException
	 * 		always
	 */

	public void contains(final String value) {
		throw new IllegalArgumentException("Null: value");
	}
}
