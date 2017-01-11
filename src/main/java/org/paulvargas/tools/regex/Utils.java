package org.paulvargas.tools.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Utils {

	private static final Logger LOG = Logger.getLogger(Utils.class.getName());

	private Utils() {
	}

	public static String toString(final URL url, final Charset charset) throws IOException {
		if (LOG.isLoggable(Level.CONFIG)) {
			LOG.log(Level.CONFIG, "Reading url={0}, charset={1}", new Object[] { url, charset });
		}
		try (InputStream is = url.openStream();
				InputStreamReader isr = new InputStreamReader(is, charset);
				BufferedReader reader = new BufferedReader(isr)) {
			return reader.lines().collect(Collectors.joining(System.lineSeparator()));
		}
	}

	public static int getValue(final Field field) {
		try {
			return field.getInt(null);
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			LOG.log(Level.SEVERE, "Error getting the value.", e);
		}
		return 0;
	}

	public static int getValue(String fieldName) {
		try {
			return Pattern.class.getField(fieldName).getInt(null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
			LOG.log(Level.SEVERE, null, ex);
		}
		return 0;
	}

	public static String getStringFlags(final int flags) {
		final List<String> list = new ArrayList<>();
		for (final Field field : Pattern.class.getDeclaredFields()) {
			final int modifiers = field.getModifiers();
			if (Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers)) {
				if ((flags & getValue(field)) != 0) {
					list.add("Pattern." + field.getName());
				}
			}
		}
		return String.join(" | ", list);
	}

	public static String abbreviate(String str, int maxWidth) {
		if (str == null) {
			return null;
		}
		if (str.length() <= maxWidth) {
			return str;
		}
		return str.substring(0, maxWidth - 3) + "...";
	}

}
