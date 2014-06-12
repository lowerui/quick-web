package com.quick.guava;

import java.util.List;

import com.google.common.base.Splitter;

public class SpliterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> list = Splitter.on(",").trimResults().omitEmptyStrings().splitToList("3,4,");
		System.out.println();
		for(int i=0;i<list.size();i++){
			System.out.println(i+list.get(i));
		}

	}

}
