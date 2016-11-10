package org.paulvargas.tools.regex;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		for (Field field : Pattern.class.getDeclaredFields()) {
			int modifiers = field.getModifiers();
			if (Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers)) {
				System.out.println(field.getName());
				System.out.println(getValue(field.getName()));
			}
		}
	}
	
	private static final int getValue(String fieldName) {
		try {
			return Pattern.class.getField(fieldName).getInt(null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
		return 0;
	}
}
