/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.paulvargas.tools.regex;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pvargasbext
 */
public class MainFrame extends javax.swing.JFrame {

  private final DefaultTableModel groupModel;
  private final DefaultTableModel splitModel;
	
	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		this.splitModel = new DefaultTableModel();
		this.groupModel = new DefaultTableModel();
		initComponents();
		initFlags();
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
        regexPanel = new JPanel();
        regexLabel = new JLabel();
        regexTextField = new JTextField();
        mainPanel = new JPanel();
        flagsPanel = new JPanel();
        splitPane = new JSplitPane();
        inputScrollPane = new JScrollPane();
        inputTextArea = new JTextArea();
        tabbedPane = new JTabbedPane();
        groupsPanel = new JPanel();
        groupsScrollPane = new JScrollPane();
        groupsTable = new JTable();
        splitPanel = new JPanel();
        replacePanel = new JPanel();
        snippetPanel = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java REGEX");

        regexLabel.setText("Regex: ");

        GroupLayout regexPanelLayout = new GroupLayout(regexPanel);
        regexPanel.setLayout(regexPanelLayout);
        regexPanelLayout.setHorizontalGroup(regexPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(regexPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regexLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regexTextField, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
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

        groupsPanel.setLayout(new GridLayout());

        groupsTable.setModel(groupModel);
        groupsScrollPane.setViewportView(groupsTable);

        groupsPanel.add(groupsScrollPane);

        tabbedPane.addTab("Matched Subsequences", groupsPanel);

        GroupLayout splitPanelLayout = new GroupLayout(splitPanel);
        splitPanel.setLayout(splitPanelLayout);
        splitPanelLayout.setHorizontalGroup(splitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        splitPanelLayout.setVerticalGroup(splitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Split", splitPanel);

        GroupLayout replacePanelLayout = new GroupLayout(replacePanel);
        replacePanel.setLayout(replacePanelLayout);
        replacePanelLayout.setHorizontalGroup(replacePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        replacePanelLayout.setVerticalGroup(replacePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Replace", replacePanel);

        GroupLayout snippetPanelLayout = new GroupLayout(snippetPanel);
        snippetPanel.setLayout(snippetPanelLayout);
        snippetPanelLayout.setHorizontalGroup(snippetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        snippetPanelLayout.setVerticalGroup(snippetPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Snippet", snippetPanel);

        splitPane.setRightComponent(tabbedPane);

        mainPanel.add(splitPane, BorderLayout.CENTER);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setSize(new Dimension(581, 481));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

	private void initFlags() {
		flagsPanel.setLayout(new WrapLayout(FlowLayout.LEFT));
		for (Field field : Pattern.class.getDeclaredFields()) {
			int modifiers = field.getModifiers();
			if (Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers)) {
				JCheckBox checkBox = new JCheckBox(field.getName());
				flagsPanel.add(checkBox);
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
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
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
    private JPanel groupsPanel;
    private JScrollPane groupsScrollPane;
    private JTable groupsTable;
    private JScrollPane inputScrollPane;
    private JTextArea inputTextArea;
    private JPanel mainPanel;
    private JLabel regexLabel;
    private JPanel regexPanel;
    private JTextField regexTextField;
    private JPanel replacePanel;
    private JPanel snippetPanel;
    private JSplitPane splitPane;
    private JPanel splitPanel;
    private JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables


}
