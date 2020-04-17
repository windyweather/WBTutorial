/**
 * 
 */
package com.ww.appcode;

import java.awt.EventQueue;

import com.ww.views.*;


/**
 * @author Darrell
 *
 */
public class ShowRunnerEvents extends FirstWbGui {
	
	// get rid of a warning about serialization.
	private static final long serialVersionUID = 19837503L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowRunnerEvents frame = new ShowRunnerEvents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//
	// Put some text in the status line to say what's up
	//
	public void setStatus( String sts ) {
		
		lblStatusLine.setText( sts );
	}

	
	public ShowRunnerEvents() {
		
		System.out.println("ShowRunnerEvents constructor reached");
		
		
	    String s = 
	    	      "name: " + System.getProperty ("os.name");
	    	    s += ", version: " + System.getProperty ("os.version");
	    	    s += ", arch: " + System.getProperty ("os.arch");
	    	    System.out.println ("OS=" + s);
		
		// Set up some default values depending on the OS we find
		String osName = System.getProperty ("os.name");
		if ( osName.contains("Windows") ) {
			tfPathToImpress.setText("C:\\Program Files\\LibreOffice\\program\\soffice.exe");
			txtOptions.setText("--impress --show");
		}
		else if (osName.contains("Linux")) {
			tfPathToImpress.setText("soimpress");
			txtOptions.setText("--show");
		}

		setStatus("ShowRunner Started");


		System.out.println( "showList size "+ showList.size() );
		showList.clear();
		System.out.println( "showList size "+ showList.size() );
		showList.setSize(4);
		System.out.println( "showList size "+ showList.size() );
		// just some junk to test the show list
		showList.addElement("First Show what happens with very very very very long strings in the list what if there were a very long path here in the list");
		showList.addElement("Second Show");
		showList.addElement("Third Show");
		showList.addElement("Fourth Show");
		
		System.out.println( "showList size "+ showList.size() );
		
		System.out.println( "showList capacity "+ showList.capacity() );

		
	}
	

}
