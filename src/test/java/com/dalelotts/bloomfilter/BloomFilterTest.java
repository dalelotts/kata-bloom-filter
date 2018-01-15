/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.bloomfilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Dale "Ducky" Lotts
 * @since 1/14/18.
 */

final class BloomFilterTest {

	private BloomFilter filter;

	@BeforeEach
	void before() {
		filter = new BloomFilter();
	}

	@Test
	void containsReturnsFalseWhenPassedValueNotInSet() {
		filter.add("a");
		assertFalse(filter.contains("b"));
	}

	@Test
	void containsReturnsTrueWhenPassedValueInSet() {
		filter.add("a");
		assertTrue(filter.contains("a"));
	}

	@Test
	void containsThrowsExceptionWhenPassedEmptyString() {
		final Throwable exception = assertThrows(IllegalArgumentException.class, () -> filter.contains(""));
		assertEquals(exception.getMessage(), "Empty: value");
	}

	@Test
	void containsThrowsExceptionWhenPassedNull() {
		final Throwable exception = assertThrows(IllegalArgumentException.class, () -> filter.contains(null));
		assertEquals(exception.getMessage(), "Null: value");
	}
}
