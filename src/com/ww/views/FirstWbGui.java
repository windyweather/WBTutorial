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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class FirstWbGui extends JFrame implements ActionListener

{

	// get rid of a warning about serialization.
	private static final long serialVersionUID = 19837502L;
	
	private JPanel contentPane;
	protected JTextField tfPathToImpress;
	protected JTextField txtOptions;
	protected JTextField txtShowPath;
	protected JLabel lblStatusLine;
	// Create the showList and listShows up here so we have some more control
	// and can access these from the child class more easily
	// very nice that this change does not mess up parsing by window builder
	protected DefaultListModel<String>showList = new DefaultListModel<String>();
	protected JList<String> listShows = new JList<String>(showList);
	

	
	// we will overload this in the child class
	// use the same one for every action
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
	    System.out.println( "FirstWbGui::actionPerformed "+actionCommand );
	}
	
	// catch window closing with our own method
	// this is overridden in the child to save stuff before exit
	public void windowClosingEvent(WindowEvent e) {
		System.out.println( "FirstWbGui windowClosing" );
	}

	// The launch point is in the child class so just
	// comment it out here.
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// Find ourselves in the great beyond
				FirstWbGui win = (FirstWbGui)e.getWindow();
				win.windowClosingEvent(e); // call us, which will call our child too
			}
		});
		//addWindowListener(this);
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
		mntmOpenShowList.setActionCommand("mntmOpenShowList");
		mntmOpenShowList.addActionListener(this);
		mntmOpenShowList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnFile.add(mntmOpenShowList);
		
		JMenuItem mntmSaveShowList = new JMenuItem("Save Show List...");
		mntmSaveShowList.setActionCommand("mntmSaveShowList");
		mntmSaveShowList.addActionListener(this);
		mntmSaveShowList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnFile.add(mntmSaveShowList);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.setActionCommand("mntmQuit");
		mntmQuit.addActionListener(this);
		mntmQuit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnFile.add(mntmQuit);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpDialog = new JMenuItem("Help...");
		mntmHelpDialog.setActionCommand("mntmHelpDialog");
		mntmHelpDialog.addActionListener(this);
		mntmHelpDialog.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnHelp.add(mntmHelpDialog);
		
		JMenuItem mntmAboutDialog = new JMenuItem("About...");
		mntmAboutDialog.setActionCommand("mntmAboutDialog");
		mntmAboutDialog.addActionListener(this);
		mntmAboutDialog.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnHelp.add(mntmAboutDialog);
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
		btnBrowseForImpress.setActionCommand("btnBrowseForImpress");
		btnBrowseForImpress.addActionListener(this);
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
		btnBrowseForShow.setActionCommand("btnBrowseForShow");
		btnBrowseForShow.addActionListener(this);
		btnBrowseForShow.setBounds(515, 205, 55, 38);
		btnBrowseForShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnBrowseForShow);
		
		JButton btnAddShow = new JButton("Add Show");
		btnAddShow.setActionCommand("btnAddShow");
		btnAddShow.addActionListener(this);
		btnAddShow.setBounds(580, 205, 125, 38);
		btnAddShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnAddShow);
		
		JCheckBox ckbxBeepOnEnd = new JCheckBox("Beep at End of Show");
		ckbxBeepOnEnd.setBounds(15, 546, 184, 29);
		ckbxBeepOnEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(ckbxBeepOnEnd);
		
		JButton btnRemoveAll = new JButton("Remove All");
		btnRemoveAll.setActionCommand("btnRemoveAll");
		btnRemoveAll.addActionListener(this);
		btnRemoveAll.setBounds(580, 253, 125, 38);
		btnRemoveAll.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnRemoveAll);
		
		JButton btnRemoveSelected = new JButton("Remove Selected");
		btnRemoveSelected.setActionCommand("btnRemoveSelected");
		btnRemoveSelected.addActionListener(this);
		btnRemoveSelected.setBounds(411, 254, 165, 38);
		btnRemoveSelected.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnRemoveSelected);
		
		JButton btnStartShows = new JButton("Start Shows");
		btnStartShows.setActionCommand("btnStartShows");
		btnStartShows.addActionListener(this);
		btnStartShows.setBounds(365, 537, 165, 38);
		btnStartShows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnStartShows);
		
		JButton btnStopShows = new JButton("Stop Shows");
		btnStopShows.setActionCommand("btnStopShows");
		btnStopShows.addActionListener(this);
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
		btnMoveTop.setActionCommand("btnMoveTop");
		btnMoveTop.addActionListener(this);
		btnMoveTop.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMoveTop.setBounds(169, 253, 64, 38);
		contentPane.add(btnMoveTop);
		
		JButton btnMoveUp = new JButton("Up");
		btnMoveUp.setActionCommand("btnMoveUp");
		btnMoveUp.addActionListener(this);
		btnMoveUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMoveUp.setBounds(243, 254, 64, 38);
		contentPane.add(btnMoveUp);
		
		JButton btnMoveDown = new JButton("Down");
		btnMoveDown.setActionCommand("btnMoveDown");
		btnMoveDown.addActionListener(this);
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

		scrollPane.setViewportView(listShows);
		listShows.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listShows.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}
}
