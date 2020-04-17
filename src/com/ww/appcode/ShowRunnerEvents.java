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
	
	public ShowRunnerEvents() {

		System.out.println("ShowRunnerEvents constructor reached");       

	}

}
