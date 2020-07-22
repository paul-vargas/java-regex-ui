package org.paulvargas.tools.regex;

import java.awt.Color;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

import javax.swing.JColorChooser;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;

public class PrintUIFeatures {

	public static void main(String[] args) {
		
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			System.out.println(info.getName());
		}		
		
		try {
			UIManager.setLookAndFeel( new FlatDarkLaf() );
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Map<String, Object> map2 = new TreeMap<>();
		UIDefaults map = UIManager.getDefaults();
		for(Map.Entry<Object, Object> entry : map.entrySet()) {
			Object k = entry.getKey();
			Object v = entry.getValue();
			map2.put(k.toString(), v);
		}
		
		
		for(Map.Entry<String, Object> entry : map2.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof Color) {
				if (key.startsWith("Actions.") || key.startsWith("TextField.") || !key.contains(".")) {
					System.out.printf("%52s", key);
					System.out.printf(" %s%n", (value == null ? "<null>" : value.toString() + " (" + value.getClass() + ")"));
					JColorChooser.showDialog(null, (String)key, (Color)value);
					
				}
			}
		}
		
		
	}
	
}
