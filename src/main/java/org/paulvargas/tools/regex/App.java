package org.paulvargas.tools.regex;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
		Field[] fields = Pattern.class.getDeclaredFields();
		for (Field field : fields) {
			int modifiers = field.getModifiers();
			if (Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers)) 
			System.out.println(field.getName());
		}
		
    }
}
