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





public class FirstWbGui extends JFrame {

	// get rid of a warning about serialization.
	private static final long serialVersionUID = 19837502L;
	
	private JPanel contentPane;
	protected JTextField tfPathToImpress;
	protected JTextField txtOptions;
	protected JTextField txtShowPath;
	protected JLabel lblStatusLine;
	//protected JList listShows = new JList();
    protected DefaultListModel<String> showList = new DefaultListModel<>();  
    //l1.addElement("Item1");  
    //l1.addElement("Item2");  
    //l1.addElement("Item3");  
    //l1.addElement("Item4");  
    protected JList<String> listShows = new JList<>(showList);  

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
		
		System.out.println("FirstWbGui constructor reached");  
		setResizable(false);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("FirstWbGui Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Path to Impress");
		lblNewLabel.setBounds(15, 31, 138, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		lblShowPaths.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		
		
		listShows.setBounds(15, 287, 690, 303);
		listShows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(listShows);
		
		JCheckBox ckbxBeepOnEnd = new JCheckBox("Beep on Show End");
		ckbxBeepOnEnd.setBounds(15, 657, 165, 38);
		ckbxBeepOnEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(ckbxBeepOnEnd);
		
		JButton btnRemoveAll = new JButton("Remove All Shows");
		btnRemoveAll.setBounds(365, 613, 165, 38);
		btnRemoveAll.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnRemoveAll);
		
		JButton btnRemoveSelected = new JButton("Remove Selected");
		btnRemoveSelected.setBounds(540, 613, 165, 38);
		btnRemoveSelected.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnRemoveSelected);
		
		JButton btnStartShows = new JButton("Start Shows");
		btnStartShows.setBounds(365, 657, 165, 38);
		btnStartShows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnStartShows);
		
		JButton btnStopShows = new JButton("Stop Shows");
		btnStopShows.setBounds(540, 657, 165, 38);
		btnStopShows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnStopShows);
		
		JLabel lblListOfShows = new JLabel("List of Shows");
		lblListOfShows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListOfShows.setBounds(15, 253, 125, 24);
		contentPane.add(lblListOfShows);
		
		lblStatusLine = new JLabel("status");
		lblStatusLine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatusLine.setBounds(10, 705, 695, 29);
		contentPane.add(lblStatusLine);
		
		JButton btnMoveTop = new JButton("Top");
		btnMoveTop.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMoveTop.setBounds(116, 613, 64, 38);
		contentPane.add(btnMoveTop);
		
		JButton btnMoveUp = new JButton("Up");
		btnMoveUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMoveUp.setBounds(191, 613, 64, 38);
		contentPane.add(btnMoveUp);
		
		JButton btnMoveDown = new JButton("Down");
		btnMoveDown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMoveDown.setBounds(264, 613, 79, 38);
		contentPane.add(btnMoveDown);
	}
}
