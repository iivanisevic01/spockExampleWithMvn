package org.foo;

public class HelloWorld {
	
	public int testMe1(int blah) {
		if (blah > 1) {
			return 7;
		} else {
			return 9;
		}
	}

	protected int testMe2(String blah) {
		if (blah.equals("me")) {
			return 7;
		} else {
			return 9;
		}
	}

	private int testMe3(boolean blah) {
		if (blah) {
			return 7;
		} else {
			return 9;
		}
	}

	public static int testStatic(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 1) {
			return 1;
		} else {
			return 2;
		}
	}
}
