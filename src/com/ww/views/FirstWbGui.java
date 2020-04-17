package com.ww.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.SpringLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.ScrollPane;
import javax.swing.ListModel;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;





public class FirstWbGui extends JFrame {

	// get rid of a warning about serialization.
	private static final long serialVersionUID = 19837502L;
	
	private JPanel contentPane;
	protected JTextField tfPathToImpress;
	protected JTextField txtOptions;
	protected JTextField txtShowPath;
	protected JLabel lblStatusLine;

    protected DefaultListModel<String> showList = new DefaultListModel<>();  

	/**
	 * Launch the application.
	 */
/**	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWbGui frame = new FirstWbGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
**/

	/**
	 * Create the frame.
	 */
	public FirstWbGui() {
		setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		System.out.println("FirstWbGui constructor reached");  
		setResizable(false);
		setTitle("Impress Slide Show Runner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 718);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnFile);
		
		JMenuItem mntmOpenShowList = new JMenuItem("Open Show List...");
		mntmOpenShowList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnFile.add(mntmOpenShowList);
		
		JMenuItem mntmSaveShowList = new JMenuItem("Save Show List...");
		mntmSaveShowList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnFile.add(mntmSaveShowList);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnFile.add(mntmQuit);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpDialog = new JMenuItem("Help...");
		mntmHelpDialog.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnHelp.add(mntmHelpDialog);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About...");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnHelp.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Path to Impress");
		lblNewLabel.setBounds(15, 32, 138, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		tfPathToImpress = new JTextField();
		tfPathToImpress.setBounds(15, 79, 616, 38);
		tfPathToImpress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(tfPathToImpress);
		tfPathToImpress.setColumns(10);
		
		JButton btnBrowseForImpress = new JButton("...");
		btnBrowseForImpress.setBounds(641, 79, 64, 38);
		btnBrowseForImpress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnBrowseForImpress);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setBounds(15, 127, 72, 38);
		lblOptions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblOptions);
		
		txtOptions = new JTextField();
		txtOptions.setBounds(86, 127, 411, 38);
		txtOptions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtOptions);
		txtOptions.setColumns(10);
		
		JLabel lblShowPaths = new JLabel("Show to Add");
		lblShowPaths.setBounds(15, 175, 125, 24);
		lblShowPaths.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblShowPaths);
		
		txtShowPath = new JTextField();
		txtShowPath.setBounds(15, 205, 482, 38);
		txtShowPath.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtShowPath.setColumns(10);
		contentPane.add(txtShowPath);
		
		JButton btnBrowseForShow = new JButton("...");
		btnBrowseForShow.setBounds(515, 205, 55, 38);
		btnBrowseForShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnBrowseForShow);
		
		JButton btnAddShow = new JButton("Add Show");
		btnAddShow.setBounds(580, 205, 125, 38);
		btnAddShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnAddShow);
		
		JCheckBox ckbxBeepOnEnd = new JCheckBox("Beep at End of Show");
		ckbxBeepOnEnd.setBounds(15, 546, 184, 29);
		ckbxBeepOnEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(ckbxBeepOnEnd);
		
		JButton btnRemoveAll = new JButton("Remove All");
		btnRemoveAll.setBounds(580, 253, 125, 38);
		btnRemoveAll.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnRemoveAll);
		
		JButton btnRemoveSelected = new JButton("Remove Selected");
		btnRemoveSelected.setBounds(411, 254, 165, 38);
		btnRemoveSelected.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnRemoveSelected);
		
		JButton btnStartShows = new JButton("Start Shows");
		btnStartShows.setBounds(365, 537, 165, 38);
		btnStartShows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnStartShows);
		
		JButton btnStopShows = new JButton("Stop Shows");
		btnStopShows.setBounds(540, 537, 165, 38);
		btnStopShows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnStopShows);
		
		JLabel lblListOfShows = new JLabel("List of Shows");
		lblListOfShows.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblListOfShows.setBounds(15, 253, 125, 30);
		contentPane.add(lblListOfShows);
		
		lblStatusLine = new JLabel("status");
		lblStatusLine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatusLine.setBounds(15, 613, 695, 29);
		contentPane.add(lblStatusLine);
		
		JButton btnMoveTop = new JButton("Top");
		btnMoveTop.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMoveTop.setBounds(169, 253, 64, 38);
		contentPane.add(btnMoveTop);
		
		JButton btnMoveUp = new JButton("Up");
		btnMoveUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMoveUp.setBounds(243, 254, 64, 38);
		contentPane.add(btnMoveUp);
		
		JButton btnMoveDown = new JButton("Down");
		btnMoveDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMoveDown.setBounds(317, 254, 84, 38);
		contentPane.add(btnMoveDown);
		
		JSpinner spSecondsBetweenShows = new JSpinner();
		spSecondsBetweenShows.setModel(new SpinnerNumberModel(5, 0, 99, 1));
		spSecondsBetweenShows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spSecondsBetweenShows.setBounds(228, 583, 55, 20);
		contentPane.add(spSecondsBetweenShows);
		
		JLabel lblSecsBetweenShows = new JLabel("Seconds Between Shows");
		lblSecsBetweenShows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSecsBetweenShows.setBounds(15, 581, 203, 24);
		contentPane.add(lblSecsBetweenShows);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 320, 683, 196);
		contentPane.add(scrollPane);
		
		JList<String> listShows = new JList<String>(new AbstractListModel() {
			String[] values = new String[] {"First Item", "Second Item", "Very Very Very long item that causes some scroll bars to appear because that's what we need to see.", "A moderately long item 4", "A moderately long item 5", "A moderately long item 6", "A moderately long item 7", "A moderately long item 8", "A moderately long item 9", "A moderately long item 10", "A moderately long item 11", "A moderately long item 12", "A moderately long item 13"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listShows);
		listShows.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listShows.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}
}
