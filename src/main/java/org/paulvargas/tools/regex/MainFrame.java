/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.paulvargas.tools.regex;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarculaLaf;

import tchrist.PatternUtils;

/**
 *
 * @author pvargasbext
 */
public class MainFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

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
		this.setIconImages(Utils.getIcons());
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
        addExplainButton = new JButton();
        jScrollPane1 = new JScrollPane();
        snippetTextArea = new JTextArea();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java REGEX");
        addPropertyChangeListener(formListener);

        regexLabel.setText("Regex: ");

        regexTextField.setFont(new Font("Monospaced", 1, 12)); // NOI18N

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
        inputTextArea.setFont(new Font("Monospaced", 0, 12)); // NOI18N
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
                .addComponent(groupsScrollPane, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
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
                .addComponent(splitScrollPane, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("Split", splitPanel);

        replacementLabel.setText("Replacement: ");

        replacementTextField.setFont(new Font("Monospaced", 0, 12)); // NOI18N

        buttonGroup.add(replaceFirstRadioButton);
        replaceFirstRadioButton.setText("Replace First");
        replaceFirstRadioButton.addItemListener(formListener);

        buttonGroup.add(replaceAllRadioButton);
        replaceAllRadioButton.setSelected(true);
        replaceAllRadioButton.setText("Replace All");
        replaceAllRadioButton.addItemListener(formListener);

        unescapeJavaCheckBox.setText("Unescapes Java");
        unescapeJavaCheckBox.addItemListener(formListener);

        resultTextArea.setColumns(20);
        resultTextArea.setFont(new Font("Monospaced", 0, 12)); // NOI18N
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

        addExplainButton.setText("Add Explain");
        addExplainButton.addActionListener(formListener);

        snippetTextArea.setColumns(20);
        snippetTextArea.setFont(new Font("Monospaced", 0, 12)); // NOI18N
        snippetTextArea.setRows(5);
        jScrollPane1.setViewportView(snippetTextArea);

        GroupLayout snippetPanelLayout = new GroupLayout(snippetPanel);
        snippetPanel.setLayout(snippetPanelLayout);
        snippetPanelLayout.setHorizontalGroup(snippetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(snippetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(snippetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(snippetPanelLayout.createSequentialGroup()
                        .addComponent(addExplainButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                .addContainerGap())
        );
        snippetPanelLayout.setVerticalGroup(snippetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(snippetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addExplainButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("Snippet", snippetPanel);

        splitPane.setRightComponent(tabbedPane);

        mainPanel.add(splitPane, BorderLayout.CENTER);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setSize(new Dimension(483, 575));
        setLocationRelativeTo(null);
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements ActionListener, ItemListener, PropertyChangeListener, ChangeListener {
        FormListener() {}
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == addExplainButton) {
                MainFrame.this.addExplainButtonActionPerformed(evt);
            }
        }

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
		if (LOG.isLoggable(Level.CONFIG)) {
			LOG.config("PropertyChangeEvent - " + evt); //$NON-NLS-1$
		}
		String propertyName = evt.getPropertyName();
		switch (propertyName) {
			case "regex":
			case "flags":
				compileRegex((String) evt.getNewValue());
				break;
			case "input":
				updateGroups();
				updateSplit();
				updateReplace();
				updateSnippet();
				break;
			case "pattern":
				updateGroups();
				updateSplit();
				updateReplace();
				updateSnippet();
				break;
			case "limit":
				updateSplit((Integer) limitSpinner.getValue());
				updateSnippet();
				break;
			case "replacement":
				updateReplace((String) evt.getNewValue());
				break;
			case "replaceFirst":
			case "replaceAll":
			case "unescapeJava":
				updateReplace();
				break;
			case "snippet":
                updateSnippet();
				break;
			case "explain":
                addExplain();
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
        firePropertyChange("replaceFirst", null, null);
    }//GEN-LAST:event_replaceFirstRadioButtonItemStateChanged

    private void replaceAllRadioButtonItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_replaceAllRadioButtonItemStateChanged
        firePropertyChange("replaceAll", null, null);
    }//GEN-LAST:event_replaceAllRadioButtonItemStateChanged

    private void unescapeJavaCheckBoxItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_unescapeJavaCheckBoxItemStateChanged
        firePropertyChange("unescapeJava", null, null);
    }//GEN-LAST:event_unescapeJavaCheckBoxItemStateChanged

    private void addExplainButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_addExplainButtonActionPerformed
        firePropertyChange("explain", null, null);
    }//GEN-LAST:event_addExplainButtonActionPerformed

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
							flags |= Utils.getValue(src.getText());
							break;
						default:
							flags &= ~Utils.getValue(src.getText());
							break;
					}
					firePropertyChange("flags", null, regexTextField.getText());
				});
				flagsPanel.add(checkBox);
			}
		}
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
			regexTextField.setForeground(UIManager.getColor("TextField.foreground"));
//			regexTextField.setForeground(new Color(0, 0, 153));
//			regexTextField.setBackground(Color.WHITE);
			firePropertyChange("pattern", null, null);
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error compiling regex", e);
			regexTextField.setForeground(UIManager.getColor("Actions.Red"));
//			regexTextField.setForeground(Color.RED);
//			regexTextField.setBackground(new Color(255, 230, 230));
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
		updateReplace(replacementTextField.getText());
	}

	private void updateReplace(String replacement) {
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
				replacementTextField.setForeground(UIManager.getColor("TextField.foreground"));
//				replacementTextField.setForeground(Color.BLACK);
//				replacementTextField.setBackground(Color.WHITE);
			} catch (Exception e) {
				LOG.log(Level.SEVERE, "There was an error.", e);
				replacementTextField.setForeground(UIManager.getColor("Actions.Red"));
//				replacementTextField.setForeground(Color.RED);
//				replacementTextField.setBackground(new Color(255, 230, 230));
			}
		} else {
			resultTextArea.setText("");
		}
	}
	
	private void updateSnippet() {
		int maxWidth = 100;
		String replacement = replacementTextField.getText();
		String input = inputTextArea.getText();
		int splitLimit = (Integer) limitSpinner.getValue();

		StringWriter writer = new StringWriter();
		PrintWriter out = new PrintWriter(writer, true);
		out.print("You can try the following regular expression:\n\n\t");
		out.println(pattern.pattern());
		out.println("\nAdditionally, if you plan to use the regular expression very often, it is recommended to use a constant in order to avoid recompile it each time, e.g.:\n\n");

		out.printf("\tprivate static final Pattern REGEX_PATTERN = \n\t\t\tPattern.compile(\"%s\"%s);%n",
				new Object[] { escapeJava(pattern.pattern()), flags != 0 ? ", " + Utils.getStringFlags(flags) : "" });
		out.println();
		out.println("\tpublic static void main(String[] args) {");
		if ((input != null) && (!input.isEmpty())) {
			out.printf("\t\tString input = \"%s\";%n", new Object[] { escapeJava( input) });
			out.println();
			if (replaceFirstRadioButton.isSelected()) {
				out.println("\t\tSystem.out.println(");
				out.printf("\t\t\tinput.replaceFirst(\"%s\", \"%s\")%n",
						new Object[] { escapeJava(pattern.pattern()), escapeJava(replacement) });
				out.printf("\t\t);  // prints \"%s\"%n",
						new Object[] { pattern.matcher(input).replaceFirst(replacement) });
			}
			if (replaceAllRadioButton.isSelected()) {
				out.println("\t\tSystem.out.println(");
				out.printf("\t\t\tinput.replaceAll(\"%s\", \"%s\")%n",
						new Object[] { escapeJava(pattern.pattern()), escapeJava(replacement) });
				out.printf("\t\t);  // prints \"%s\"%n",
						new Object[] { pattern.matcher(input).replaceAll(replacement) });
			}
			out.println();
			out.println("\t\tSystem.out.println(java.util.Arrays.toString(");
			out.printf("\t\t\tREGEX_PATTERN.split(input, %d)%n", splitLimit);
			out.printf("\t\t)); // prints \"%s\"%n", new Object[]{Arrays.toString(pattern.split(input, splitLimit))});
			out.println();
			out.printf("\t\t//    \"%s\".split(\"%s\", %d) \u21D2 %s %n", escapeJava(input), escapeJava(pattern.pattern()), splitLimit, java.util.Arrays.stream(
				pattern.split(input, splitLimit)
		).map(e -> "\"" + e + "\"").collect(java.util.stream.Collectors.joining(", ", "[", "]")));

			out.println();
			out.println("\t\tSystem.out.println(");
			out.println("\t\t\tREGEX_PATTERN.matcher(input).matches()");
			out.printf("\t\t);  // prints \"%s\"%n",
					new Object[] { Boolean.valueOf(pattern.matcher(input).matches()) });

			out.println();
			out.println("\t\tMatcher matcher = REGEX_PATTERN.matcher(input);");
			out.println("\t\twhile (matcher.find()) {");
			out.println("\t\t\tSystem.out.println(matcher.group());");
			out.println("\t\t}");

			out.println();
			if (replaceFirstRadioButton.isSelected()) {
				out.println("\t\tSystem.out.println(");
				out.printf("\t\t\tREGEX_PATTERN.matcher(input).replaceFirst(\"%s\")%n",
						new Object[] { replacement.replace("\\", "\\\\").replace("\"", "\\\"") });
				out.printf("\t\t);  // prints \"%s\"%n",
						new Object[] { pattern.matcher(input).replaceFirst(replacement) });
			}
			if (replaceAllRadioButton.isSelected()) {
				out.println("\t\tSystem.out.println(");
				out.printf("\t\t\tREGEX_PATTERN.matcher(input).replaceAll(\"%s\")%n",
						new Object[] { replacement.replace("\\", "\\\\").replace("\"", "\\\"") });
				out.printf("\t\t);  // prints \"%s\"%n",
						new Object[] { pattern.matcher(input).replaceAll(replacement) });
			}
		}
		out.println("\t}");
		out.println();
		out.println("Output:");
		out.println();
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			out.printf("\t%s%n", new Object[] { matcher.group() });
		}
		snippetTextArea.setText(writer.toString());
	}

	private String escapeJava(final String input) {
		final StringBuilder builder = new StringBuilder(input.length());
		for (int i = 0; i < input.length(); i++) {
			final char c = input.charAt(i);
			switch (c) {
				// Java does not recognize \a or \v, apparently.
				case 0x07:
					builder.append("\\a");
					break;
				case '\b':
					builder.append("\\b");
					break;
				case '\f':
					builder.append("\\f");
					break;
				case '\n':
					builder.append("\\n");
					break;
				case '\r':
					builder.append("\\r");
					break;
				case '\t':
					builder.append("\\t");
					break;
				case 0x0b:
					builder.append("\\v");
					break;
				case '\\':
					builder.append("\\\\");
					break;
				case '\'':
					builder.append("\\\'");
					break;
				case '"':
					builder.append("\\\"");
					break;
				default:
					// Only ASCII characters between 0x20 (space) and 0x7e (tilde) are
					// printable.  Other byte values must be escaped.
					if (c >= 0x20 && c <= 0x7e) {
						builder.append(c);
					} else {
						builder.append("\\u");
						builder.append(String.format("%04x", (int) c));
					}
					break;
			}
		}
		return builder.toString();
	}
    
    private void addExplain() {
        Charset charset = StandardCharsets.ISO_8859_1;
        if (pattern != null) {
            try {
                String content = Utils.toString(new URL("http://rick.measham.id.au/paste/explain.pl?regex=" + URLEncoder.encode(pattern.pattern(), charset.name())), charset);
                String explain = content.replaceAll("(?s).*<pre>(.*?)</pre>.*", "$1");
                snippetTextArea.append(System.lineSeparator());
                snippetTextArea.append("Explanation of the regular expression:");
                snippetTextArea.append(System.lineSeparator());
                for (String line : explain.split("\r\n", -1)) {
                    snippetTextArea.append("\t");
                    snippetTextArea.append(line);
                    snippetTextArea.append(System.lineSeparator());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "There was an error getting the explanation: " + e.getMessage(), "Error", 0);
            }
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
		/*try {
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
		}*/
		//</editor-fold>
		
		try {
			JFrame.setDefaultLookAndFeelDecorated( true );
			JDialog.setDefaultLookAndFeelDecorated( true );
			UIManager.setLookAndFeel( new FlatDarculaLaf() );
			UIManager.put( "CheckBox.icon.style", "filled" );
		} catch (Exception e) {
			// TODO: handle exception
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addExplainButton;
    private ButtonGroup buttonGroup;
    private JPanel flagsPanel;
    private JTable groupsTable;
    private JTextArea inputTextArea;
    private JScrollPane jScrollPane1;
    private JSpinner limitSpinner;
    private JTextField regexTextField;
    private JRadioButton replaceAllRadioButton;
    private JRadioButton replaceFirstRadioButton;
    private JTextField replacementTextField;
    private JTextArea resultTextArea;
    private JTextArea snippetTextArea;
    private JTable splitTable;
    private JCheckBox unescapeJavaCheckBox;
    // End of variables declaration//GEN-END:variables


}
