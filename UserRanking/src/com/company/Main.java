package com.company;

public class Main {

    public static void main(String[] args) {
	User a = new User();
	a.incProgress(-1);
	System.out.println(a.rank + " " + a.progress);
    }
}
