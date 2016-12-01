/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.paulvargas.tools.regex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import tchrist.PatternUtils;

/**
 *
 * @author pvargasbext
 */
public class MainFrame extends javax.swing.JFrame {

	private static final Logger LOG = Logger.getLogger(MainFrame.class.getName());
	
  private DefaultTableModel groupModel;
  private DefaultTableModel splitModel;
  
  private int flags = 0;
  private Pattern pattern = Pattern.compile("", flags);
	
	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		initTableModels();
		initComponents();
		initFlags();
        initDocumentListeners();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new ButtonGroup();
        JPanel regexPanel = new JPanel();
        JLabel regexLabel = new JLabel();
        regexTextField = new JTextField();
        JPanel mainPanel = new JPanel();
        flagsPanel = new JPanel();
        JSplitPane splitPane = new JSplitPane();
        JScrollPane inputScrollPane = new JScrollPane();
        inputTextArea = new JTextArea();
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel groupsPanel = new JPanel();
        JScrollPane groupsScrollPane = new JScrollPane();
        groupsTable = new JTable();
        JPanel splitPanel = new JPanel();
        JScrollPane splitScrollPane = new JScrollPane();
        splitTable = new JTable();
        JLabel limitLabel = new JLabel();
        limitSpinner = new JSpinner();
        JPanel replacePanel = new JPanel();
        JLabel replacementLabel = new JLabel();
        replacementTextField = new JTextField();
        replaceFirstRadioButton = new JRadioButton();
        replaceAllRadioButton = new JRadioButton();
        unescapeJavaCheckBox = new JCheckBox();
        JScrollPane replaceResultScrollPane = new JScrollPane();
        resultTextArea = new JTextArea();
        JPanel snippetPanel = new JPanel();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java REGEX");
        addPropertyChangeListener(formListener);

        regexLabel.setText("Regex: ");

        GroupLayout regexPanelLayout = new GroupLayout(regexPanel);
        regexPanel.setLayout(regexPanelLayout);
        regexPanelLayout.setHorizontalGroup(regexPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(regexPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regexLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regexTextField, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        regexPanelLayout.setVerticalGroup(regexPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(regexPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(regexPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(regexLabel)
                    .addComponent(regexTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(regexPanel, BorderLayout.PAGE_START);

        mainPanel.setLayout(new BorderLayout());

        flagsPanel.setBorder(BorderFactory.createTitledBorder("Flags"));
        mainPanel.add(flagsPanel, BorderLayout.PAGE_START);

        splitPane.setBorder(null);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setResizeWeight(0.33);

        inputScrollPane.setBorder(BorderFactory.createTitledBorder("Input"));

        inputTextArea.setColumns(20);
        inputScrollPane.setViewportView(inputTextArea);

        splitPane.setLeftComponent(inputScrollPane);

        groupsTable.setModel(groupModel);
        groupsTable.setCellSelectionEnabled(true);
        groupsScrollPane.setViewportView(groupsTable);

        GroupLayout groupsPanelLayout = new GroupLayout(groupsPanel);
        groupsPanel.setLayout(groupsPanelLayout);
        groupsPanelLayout.setHorizontalGroup(groupsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(groupsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupsScrollPane, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );
        groupsPanelLayout.setVerticalGroup(groupsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(groupsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupsScrollPane, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("Matched Subsequences", groupsPanel);

        splitTable.setModel(splitModel);
        splitTable.setCellSelectionEnabled(true);
        splitScrollPane.setViewportView(splitTable);

        limitLabel.setText("Limit: ");

        limitSpinner.setModel(new SpinnerNumberModel(0, -1, 2147483647, 1));
        limitSpinner.addChangeListener(formListener);

        GroupLayout splitPanelLayout = new GroupLayout(splitPanel);
        splitPanel.setLayout(splitPanelLayout);
        splitPanelLayout.setHorizontalGroup(splitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(splitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(splitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(splitScrollPane, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addGroup(splitPanelLayout.createSequentialGroup()
                        .addComponent(limitLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limitSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        splitPanelLayout.setVerticalGroup(splitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, splitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(splitPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(limitLabel)
                    .addComponent(limitSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splitScrollPane, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("Split", splitPanel);

        replacementLabel.setText("Replacement: ");

        buttonGroup.add(replaceFirstRadioButton);
        replaceFirstRadioButton.setText("Replace First");
        replaceFirstRadioButton.addItemListener(formListener);

        buttonGroup.add(replaceAllRadioButton);
        replaceAllRadioButton.setText("Replace All");
        replaceAllRadioButton.addItemListener(formListener);

        unescapeJavaCheckBox.setText("Unescapes Java");
        unescapeJavaCheckBox.addItemListener(formListener);

        resultTextArea.setColumns(20);
        resultTextArea.setRows(5);
        replaceResultScrollPane.setViewportView(resultTextArea);

        GroupLayout replacePanelLayout = new GroupLayout(replacePanel);
        replacePanel.setLayout(replacePanelLayout);
        replacePanelLayout.setHorizontalGroup(replacePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(replacePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(replacePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(replaceResultScrollPane)
                    .addGroup(replacePanelLayout.createSequentialGroup()
                        .addComponent(replacementLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(replacementTextField))
                    .addGroup(replacePanelLayout.createSequentialGroup()
                        .addComponent(replaceFirstRadioButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(replaceAllRadioButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unescapeJavaCheckBox)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        replacePanelLayout.setVerticalGroup(replacePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(replacePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(replacePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(replacementLabel)
                    .addComponent(replacementTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(replacePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(replaceFirstRadioButton)
                    .addComponent(replaceAllRadioButton)
                    .addComponent(unescapeJavaCheckBox))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(replaceResultScrollPane)
                .addContainerGap())
        );

        tabbedPane.addTab("Replace", replacePanel);

        GroupLayout snippetPanelLayout = new GroupLayout(snippetPanel);
        snippetPanel.setLayout(snippetPanelLayout);
        snippetPanelLayout.setHorizontalGroup(snippetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
        snippetPanelLayout.setVerticalGroup(snippetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Snippet", snippetPanel);

        splitPane.setRightComponent(tabbedPane);

        mainPanel.add(splitPane, BorderLayout.CENTER);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setSize(new Dimension(483, 575));
        setLocationRelativeTo(null);
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements ItemListener, PropertyChangeListener, ChangeListener {
        FormListener() {}
        public void itemStateChanged(ItemEvent evt) {
            if (evt.getSource() == replaceFirstRadioButton) {
                MainFrame.this.replaceFirstRadioButtonItemStateChanged(evt);
            }
            else if (evt.getSource() == replaceAllRadioButton) {
                MainFrame.this.replaceAllRadioButtonItemStateChanged(evt);
            }
            else if (evt.getSource() == unescapeJavaCheckBox) {
                MainFrame.this.unescapeJavaCheckBoxItemStateChanged(evt);
            }
        }

        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getSource() == MainFrame.this) {
                MainFrame.this.formPropertyChange(evt);
            }
        }

        public void stateChanged(ChangeEvent evt) {
            if (evt.getSource() == limitSpinner) {
                MainFrame.this.limitSpinnerStateChanged(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void formPropertyChange(PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        System.out.println(evt);
		String propertyName = evt.getPropertyName();
		switch (propertyName) {
			case "regex":
			case "flags":
				compileRegex((String) evt.getNewValue());
				break;
			case "input":
				updateGroups();
				updateSplit();
				break;
			case "pattern":
				updateGroups();
				updateSplit();
				updateReplace();
				break;
			case "limit":
				updateSplit((Integer) limitSpinner.getValue());
				break;
			case "replacement":
				updateReplace();
				break;
			case "":
				break;
			default:
		}
    }//GEN-LAST:event_formPropertyChange

    private void limitSpinnerStateChanged(ChangeEvent evt) {//GEN-FIRST:event_limitSpinnerStateChanged
		firePropertyChange("limit", null, limitSpinner.getValue());
    }//GEN-LAST:event_limitSpinnerStateChanged

    private void replaceFirstRadioButtonItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_replaceFirstRadioButtonItemStateChanged
        firePropertyChange("replacement", null, null);
    }//GEN-LAST:event_replaceFirstRadioButtonItemStateChanged

    private void replaceAllRadioButtonItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_replaceAllRadioButtonItemStateChanged
        firePropertyChange("replacement", null, null);
    }//GEN-LAST:event_replaceAllRadioButtonItemStateChanged

    private void unescapeJavaCheckBoxItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_unescapeJavaCheckBoxItemStateChanged
        firePropertyChange("replacement", null, null);
    }//GEN-LAST:event_unescapeJavaCheckBoxItemStateChanged

	private void initTableModels() {
		groupModel = new DefaultTableModel();
		groupModel.addColumn("n");
		groupModel.addColumn("start");
		groupModel.addColumn("end");
		groupModel.addColumn("group");
		splitModel = new DefaultTableModel();
		splitModel.addColumn("index");
		splitModel.addColumn("value");
	}
	
	private void initFlags() {
		flagsPanel.setLayout(new WrapLayout(FlowLayout.LEFT));
		for (Field field : Pattern.class.getDeclaredFields()) {
			int modifiers = field.getModifiers();
			if (Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers)) {
				JCheckBox checkBox = new JCheckBox(field.getName());
				checkBox.addItemListener((ItemEvent evt) -> {
					JCheckBox src = (JCheckBox) evt.getSource();
					switch(evt.getStateChange()) {
						case ItemEvent.SELECTED:
							flags |= getValue(src.getText());
							break;
						default:
							flags &= ~getValue(src.getText());
							break;
					}
					firePropertyChange("flags", null, regexTextField.getText());
				});
				flagsPanel.add(checkBox);
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
    
    private void initDocumentListeners() {
        regexTextField.getDocument().addDocumentListener(new DocumentListenerAdapter() {
            @Override
            public void update(String text) {
				firePropertyChange("regex", null, text);
            }
        });
        inputTextArea.getDocument().addDocumentListener(new DocumentListenerAdapter() {
            @Override
            public void update(String text) {
                firePropertyChange("input", null, text);
            }
        });
        replacementTextField.getDocument().addDocumentListener(new DocumentListenerAdapter() {
            @Override
            public void update(String text) {
                firePropertyChange("replacement", null, text);
            }
        });
    }
    
    private void compileRegex(String regex) {
        try {
            pattern = Pattern.compile(regex, flags);
			firePropertyChange("pattern", null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	private void updateGroups() {
		if (pattern != null) {
			groupModel.setRowCount(0);
			Matcher matcher = pattern.matcher(inputTextArea.getText());
			for (int n = 1; matcher.find(); n++) {
				String group = matcher.group();
				groupModel.addRow(new Object[]{
					Integer.valueOf(n),
					Integer.valueOf(matcher.start()),
					Integer.valueOf(matcher.end()), group.isEmpty() ? "<empty>" : group == null ? "<null>" : group});
			}
		}
	}

	private void updateSplit() {
		updateSplit((Integer) limitSpinner.getValue());
	}

	private void updateSplit(int limit) {
		splitModel.setRowCount(0);
		String[] array = pattern.split(inputTextArea.getText(), limit);
		for (int index = 0; index < array.length; index++) {
			List<String> rowData = new ArrayList<>(4);
			rowData.add(String.valueOf(index));
			String value = array[index];
			if (value == null) {
				rowData.add("<null>");
			} else if (value.isEmpty()) {
				rowData.add("<empty>");
			} else {
				rowData.add(value);
			}
			splitModel.addRow(rowData.toArray());
		}
		//resizeColumnWidth(splitTable);
	}

	private void updateReplace() {
		String replacement = replacementTextField.getText();
		if (unescapeJavaCheckBox.isSelected()) {
			replacement = PatternUtils.unescape_perl_string(replacement);
		}
		String input = inputTextArea.getText();
		if ((replacement != null) && (input != null)) {
			try {
				if (replaceFirstRadioButton.isSelected()) {
					resultTextArea.setText(pattern.matcher(input).replaceFirst(replacement));
				} else if (replaceAllRadioButton.isSelected()) {
					resultTextArea.setText(pattern.matcher(input).replaceAll(replacement));
				}
				replacementTextField.setForeground(Color.BLACK);
				replacementTextField.setBackground(Color.WHITE);
			} catch (Exception e) {
				LOG.log(Level.SEVERE, "There was an error.", e);
				replacementTextField.setForeground(Color.RED);
				replacementTextField.setBackground(new Color(255, 230, 230));
			}
		} else {
			resultTextArea.setText("");
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonGroup buttonGroup;
    private JPanel flagsPanel;
    private JTable groupsTable;
    private JTextArea inputTextArea;
    private JSpinner limitSpinner;
    private JTextField regexTextField;
    private JRadioButton replaceAllRadioButton;
    private JRadioButton replaceFirstRadioButton;
    private JTextField replacementTextField;
    private JTextArea resultTextArea;
    private JTable splitTable;
    private JCheckBox unescapeJavaCheckBox;
    // End of variables declaration//GEN-END:variables


}
