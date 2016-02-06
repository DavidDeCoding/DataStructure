package com.david.ds.filters;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class BloomFilterSpec {

	BloomFilter filter;

	@Before
	public void before() throws Exception {
		filter = new BloomFilter();
		filter.insert("David");
		filter.insert("Paroma");
	}

	@Test
	public void insertAndIsPresent() {
		assertEquals(filter.isPresent("David"), true);
		assertEquals(filter.isPresent("Paroma"), true);
		assertEquals(filter.isPresent("De"), false);
	}
}