package com.david.ds.filters;

import java.util.BitSet;
import com.david.ds.hashing.FNV;
import com.google.common.hash.Hashing;

public class BloomFilter {

	private BitSet bitSet;

	public BloomFilter() {
		bitSet = new BitSet(32);
	}

	public void insert(String item) {
		bitSet.set( hash1(item), true );
		bitSet.set( hash2(item), true );
	}

	public boolean isPresent(String item) {
		if (bitSet.get( hash1( item )) == true &&
				bitSet.get( hash2( item )) == true)
			 return true;
		else return false;
	}

	private int hash1(String item) {
		return (int) ((FNV.hash32(item.getBytes()) & 0x7fffff) % 32) - 1;
	}

	private int hash2(String item) {
		return (int) ((Hashing.murmur3_32().hashBytes(item.getBytes()).asInt() & 0x7fffff) % 32) - 1;
	}
}