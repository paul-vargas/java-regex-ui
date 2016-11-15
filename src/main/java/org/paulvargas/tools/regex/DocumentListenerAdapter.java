/*
 *  soapUI, copyright (C) 2004-2011 smartbear.com 
 *
 *  soapUI is free software; you can redistribute it and/or modify it under the 
 *  terms of version 2.1 of the GNU Lesser General Public License as published by 
 *  the Free Software Foundation.
 *
 *  soapUI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details at gnu.org.
 */
package org.paulvargas.tools.regex;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * Adapter for DocumentListener implementations
 *
 * @author Ole.Matzura
 */
public abstract class DocumentListenerAdapter implements DocumentListener {

	private static final Logger LOG = Logger.getLogger(DocumentListenerAdapter.class.getName());

	private static String getText(Document document) {
		String txt;
		try {
			txt = document.getText(0, document.getLength());
		} catch (BadLocationException e) {
			LOG.log(Level.SEVERE, "There was an error while getting the text.", e);
			txt = "";
		}
		return txt;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		update(getText(e.getDocument()));
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		update(getText(e.getDocument()));
	}

	@Override
	@SuppressWarnings("NoopMethodInAbstractClass")
	public void changedUpdate(DocumentEvent e) {
	}

	public abstract void update(String text);

}
