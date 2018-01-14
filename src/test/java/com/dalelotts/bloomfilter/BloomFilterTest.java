/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.bloomfilter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Dale "Ducky" Lotts
 * @since 1/14/18.
 */

final class BloomFilterTest {

	@Test
	void containsThrowsExceptionWhenPassedNull() {
		final BloomFilter filter = new BloomFilter();

		final Throwable exception = assertThrows(IllegalArgumentException.class, () -> filter.contains(null));
		assertEquals(exception.getMessage(), "Null: value");
	}

	@Test
	void containsThrowsExceptionWhenPassedEmptyString() {
		final BloomFilter filter = new BloomFilter();

		final Throwable exception = assertThrows(IllegalArgumentException.class, () -> filter.contains(""));
		assertEquals(exception.getMessage(), "Empty: value");
	}
}
