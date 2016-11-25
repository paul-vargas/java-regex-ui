package org.paulvargas.tools.regex;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public abstract class DocumentListenerAdapter implements DocumentListener {

	private static final Logger LOG = Logger.getLogger(DocumentListenerAdapter.class.getName());

	private String getText(Document document) {
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
