package com.david.ds.hashing;

/*
 * @(#)$Id$
 *
 * Copyright 2006-2008 Makoto YUI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Makoto YUI - initial implementation
 */
//package xbird.util.hashes;


/**
 *
 * <DIV lang="en"></DIV>
 * <DIV lang="ja"></DIV>
 *
 * @author Makoto YUI (yuin405+xbird@gmail.com)
 * @link http://www.isthe.com/chongo/tech/comp/fnv/index.html
 */

public class FNV {
	private static final int FNV_32_INIT = 0x811c9dc5;
	private static final int FNV_32_PRIME = 0x01000193;

	public static int hash32(final byte[] k) {
		int rv = FNV_32_INIT;
		final int len = k.length;
		for (int i = 0; i < len; i++) {
			rv ^= k[i];
			rv *= FNV_32_PRIME;
		}
		return rv;
	}

	public static int hash32(final String k) {
		int rv = FNV_32_INIT;
		final int len = k.length();
		for (int i = 0; i < len; i++) {
			rv ^= k.charAt(i);
			rv *= FNV_32_PRIME;
		}
		return rv;
	}

}