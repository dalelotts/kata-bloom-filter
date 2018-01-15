/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.bloomfilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * @author Dale "Ducky" Lotts
 * @since 1/14/18.
 */

final class BloomFilterTest {

	private BloomFilter filter;

	@BeforeEach
	void beforeEach() {
		filter = new BloomFilter();
	}

	@Test
	void addThrowsExceptionWhenPassedEmptyString() {
		final Throwable exception = assertThrows(IllegalArgumentException.class, () -> filter.add(""));
		assertEquals(exception.getMessage(), "Empty: value");
	}

	@Test
	void addThrowsExceptionWhenPassedNull() {
		final Throwable exception = assertThrows(IllegalArgumentException.class, () -> filter.add(null));
		assertEquals(exception.getMessage(), "Null: value");
	}

	@Test
	void containsReturnsFalseWhenPassedValueHasCollisionWithJavaHashCode() {
		filter.add("Aa");
		assertFalse(filter.contains("BB"));
	}

	@Test
	void containsReturnsFalseWhenPassedValueNotInSet() {
		assertFalse(filter.contains("b"));
		assertFalse(filter.contains("c"));
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

	@TestFactory
	Stream<DynamicTest> wordListTests() throws URISyntaxException, IOException {
		return Files.lines(Paths.get(getClass().getResource("/wordlist.txt").toURI()))
				.limit(100) // testing the full library takes hours so there is an implementation problem somewhere.
				.map(word -> dynamicTest("contains returns true when passed " + word, () -> {
					filter.add(word);
					assertTrue(filter.contains(word));
				}));
	}
}
