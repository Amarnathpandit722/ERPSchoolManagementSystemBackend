package com.management.school.security.helper;

public class GenerateSubjectName {
	

	public static String generate() {
        final StringBuilder name = new StringBuilder("Sub-");
        for (int i = 0; i < 5; i++) {
            name.append((int) (Math.random() * 10));
        }
        return name.toString();
    }

}
