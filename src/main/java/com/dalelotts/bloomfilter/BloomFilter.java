/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.bloomfilter;

import com.sangupta.murmur.Murmur3;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * This class provides a way of testing for membership in a very large sets without linear (or worse) growth in memory
 * or search time.
 *
 * @author Dale "Ducky" Lotts
 * @since 1/14/18.
 */

final class BloomFilter {

	private final BitSet bitSet = new BitSet();

	void add(final String value) {
		bitSet.or(computeHashes(value).stream().collect(BitSet::new, BitSet::set, BitSet::or));
	}

	private static List<Integer> computeHashes(final String value) {
		final byte[] valueBytes = value.getBytes();
		final long   murmurHash = Murmur3.hash_x86_32(valueBytes, valueBytes.length, 78184L);
		final int    rightHash  = (int) (murmurHash >> 32);
		final int    leftHash   = (int) murmurHash;
		return Arrays.asList(Math.abs(rightHash), Math.abs(leftHash));
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

		return computeHashes(value)
				.stream()
				.map(bitSet::get)
				.reduce((previous, current) -> previous && current)
				.orElse(true);
	}
}
