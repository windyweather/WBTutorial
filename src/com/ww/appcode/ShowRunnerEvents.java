/**
 * 
 */
package com.ww.appcode;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;

/*
import javax.swing.DefaultListModel;
import java.io.StringReader;
import java.io.StringWriter;
*/
import java.io.File;


import com.ww.views.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException; 

import java.util.*;

import javax.swing.JFileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;


import com.ww.views.HelpDialog;
 
/**
 * @author Darrell
 *
 */
public class ShowRunnerEvents  extends FirstWbGui implements ActionListener{
	
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

	private boolean isOsWindows()
	{
		String osName = System.getProperty ("os.name");
		if ( osName.contains("Windows") ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isOsLinux()
	{
		String osName = System.getProperty ("os.name");
		if ( osName.contains("Linux") ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//
	// Class Constructor
	//
	public ShowRunnerEvents() {
		
		System.out.println("ShowRunnerEvents constructor reached");
		
		
	    String s = 
	    	      "name: " + System.getProperty ("os.name");
	    	    s += ", version: " + System.getProperty ("os.version");
	    	    s += ", arch: " + System.getProperty ("os.arch");
	    	    System.out.println ("OS=" + s);
		
		// Set up some default values depending on the OS we find

		if ( isOsWindows() ) {
			tfPathToImpress.setText("C:\\Program Files\\LibreOffice\\program\\soffice.exe");
			txtOptions.setText("--impress --show");
		}
		else if ( isOsLinux() ) {
			tfPathToImpress.setText("soimpress");
			txtOptions.setText("--show");
		}

		setStatus("ShowRunner Started");

		// test our access to the show list
		/**
		System.out.println( "showList size "+ showList.getSize() );
		showList.removeAllElements();
		System.out.println( "showList size "+ showList.getSize() );

		showList.addElement("Second Show");
		showList.addElement("Third Show");
		showList.addElement("Fourth Show");
		
		System.out.println( "showList size "+ showList.size() );
		
		System.out.println( "showList capacity "+ showList.capacity() );
		
		// add some new stuff to the list

        showList.removeAllElements();
		System.out.println( "showList removed "+ showList.size() );
		System.out.println( "showList add stuff "+ showList.size() );
		showList.addElement("USA");
		showList.addElement("India");
		showList.addElement("Vietnam");
		showList.addElement("Canada");
		showList.addElement("Denmark");
		showList.addElement("France");
		showList.addElement("Great Britain");
		showList.addElement("Japan");
		showList.addElement("USA");
		showList.addElement("India");
		showList.addElement("Vietnam");
		showList.addElement("Canada");
		showList.addElement("Denmark");
		showList.addElement("France");
		showList.addElement("Great Britain");
		showList.addElement("Japan");
		showList.addElement("USA");
		showList.addElement("India");
		showList.addElement("Vietnam");
		showList.addElement("Canada");
		showList.addElement("Denmark");
		showList.addElement("France");
		showList.addElement("Great Britain");
		showList.addElement("Japan");
		showList.addElement("USA");
		showList.addElement("India");
		showList.addElement("Vietnam");
		showList.addElement("Canada");
		showList.addElement("Denmark");
		showList.addElement("France");
		showList.addElement("Great Britain");
		showList.addElement("Japan");
		showList.addElement("First Show what happens with very very very very long strings in the list what if there were a very long path here in the list");

		System.out.println( "showList stuff added size "+ showList.size() );
		System.out.println( "showList capacity "+ showList.capacity() );
		showList.removeAllElements(); // leave the list empty
		System.out.println( "showList empty list size "+ showList.size() );
		 **/
		
		
		String userDir = System.getProperty("user.home");
		System.out.println("user.home "+ userDir);

		// Restore the defaults to the gui
		restoreDefaultsFile(); 
		
	}
	
	//
	// use the java System.Properties class for ini files
	// and write them in XML format.
	// Both the default file and the show files are stored in this way.
	//
	
	private String propertyFilePathPrefix()
	{
		return System.getProperty("user.home")+File.separator+".windyweather";
	}
	
	private String defaultsFilePath()
	{
		return propertyFilePathPrefix() + File.separator+"ImpressShowRunnerDefaults.xml";
	}
	
	
	//
	// Restore the Defaults File from XML
	//
	private void restoreDefaultsFile()
	{
		String defaultsFile = defaultsFilePath();
        Properties defProps = new Properties(); 
        //FileOutputStream out = new FileOutputStream(defaultsFile); 
		FileInputStream in;
		try {
			in = new FileInputStream(defaultsFile); 
	        // load the properties from specified xml 
	        defProps.loadFromXML(in); 
	        in.close();
        }
        catch(IOException ex){
            System.out.println("Defaults not found " + defaultsFile);
            return;
        }
        
        String sImpressPath = defProps.getProperty("ImpressPath");
        String sImpressOptions = defProps.getProperty("ImpressOptions");
        String sShowPath = defProps.getProperty("ShowPath");
        
        if ( 0 != sImpressPath.length() ) {
        	tfPathToImpress.setText(sImpressPath);
        }
        if ( 0 != sImpressOptions.length() ) {
        	txtOptions.setText(sImpressOptions);
        }
        if ( 0 != sShowPath.length() ) {
        	txtShowPath.setText( sShowPath );
        }
        

        System.out.println("restoreDefaultsFile "+defaultsFile);
        defProps.list(System.out); 
	}
	
	//
	// store the gui to the defaults file
	//
	private void saveDefaultsFile()
	{
		String defaultsDir = propertyFilePathPrefix();
		
	    File directory = new File(defaultsDir);
	    if (! directory.exists()){
	    	System.out.println("saveDefaultsFile Creating defaults dir " + defaultsDir);
	        directory.mkdir();
	    	System.out.println("saveDefaultsFile Created defaults dir  " + defaultsDir);  
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }
		String defaultsFile = defaultsFilePath();
        Properties defProps = new Properties(); 
        FileOutputStream out;
		try {
			out = new FileOutputStream(defaultsFile);
        }
        catch(IOException ex){
            System.out.println("saveDefaultsFile open failure " + defaultsFile);
            return;
        }

        defProps.put("ImpressPath", tfPathToImpress.getText() ); 
        defProps.put("ImpressOptions", txtOptions.getText() ); 
        defProps.put("ShowPath", txtShowPath.getText() ); 
        
		try {
	        // store the properties into specified xml 
	        defProps.storeToXML(out, null);
	        out.close();
	        System.out.println("saveDefaultsFile");
	        defProps.list(System.out); 
        }
        catch(IOException ex){
            System.out.println("saveDefaultsFile write fail " + defaultsFile);
            return;
        }
	}
	
	// catch the window closing event
	// passed here with a nightmare, but hey, that's Java and AWT/Swing for you.
	@Override
	public void windowClosingEvent(WindowEvent e) {
		
		System.out.println( "windowClosing - save your stuff here" );
		// write the defaults file
		saveDefaultsFile();
		
		// not necessary, we are closing, not closed
		// the framework will exit for us. No need to hammer
		// things down here.
	    //System.exit(0);
	 
	}
	
	
	
	
/**
 * Event methods. Called by the dispatcher below.
 */
	//
	// get a reasonable path from possibly an empty string
	// Assume we are passed a path to a file, or an empty string
	// something bogus
	//
	String getReasonablePath( String startPath )
	{
		File defDir;
		// protect ourselves against bad stuff if we can
		try {
			String path = txtShowPath.getText();
			if ( path.isEmpty() )
			{	// if the field is empty, then just use home path and
				// do not look for it's parent
				path = System.getProperty("user.home");
				defDir = new File(path);
			}
			else
			{
				// find parent folder assuming that the path points to a show.
				defDir = new File(path);
				defDir = new File (defDir.getParent() );
			}
			// if that does not exist, then the home folder is a guess
			if ( !defDir.exists() )
			{
				defDir = new File(System.getProperty("user.home"));
			}
			// return the path to the place we found
			return defDir.getAbsolutePath();
		}
		catch (Exception e) {
			//setStatus("Can't find a folder to start with");
			//System.out.println("browseForShowToAdd - Exception");
			// if this is not a valid directory, then we are in serious trouble here
			return System.getProperty("user.home");
		 }
	}
	//
	// If the default for the LibreOffice Impress program path is not correct, then
	// allow the user to browse for the executable file. Of course, she can just type
	// it in if that's easier. It will be saved/restored with the defaults when the program
	// exits
	//
	protected void browseForImpressProgram()
	{
		JFileChooser fileChooser = new JFileChooser();
		
		String path = getReasonablePath( tfPathToImpress.getText() );
		File defDir = new File(path);
		// point fileChooser at a carefully chosen default
		fileChooser.setCurrentDirectory(defDir);
		// we don't need defaults for the file type on Linux or do we?
		if ( isOsWindows() ) {
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Executable", "exe"));
		}
		else {
			fileChooser.setFileFilter(null); // allow all files on Linux I think
		}
		fileChooser.setAcceptAllFileFilterUsed(!isOsWindows());
		fileChooser.setMultiSelectionEnabled(false);
				
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    if ( selectedFile.canExecute() ) {
		    	tfPathToImpress.setText(selectedFile.getAbsolutePath());
			    System.out.println("Impress Program file: " + selectedFile.getAbsolutePath());
		    }
		    else {
		    	setStatus("Choose the Impress program");
		    	System.out.println("Impress Program file: " + selectedFile.getAbsolutePath());
		    }
		}
		else {
			setStatus("");
		}
	}
	
	//
	// Browse for a .xml file that contains the list of shows to play.
	//
	protected void browseForShowToAdd()
	{
		JFileChooser fileChooser = new JFileChooser();
		File defDir;
		
		// start with a possibly empty path to a show we looked at.
		String path = getReasonablePath(txtShowPath.getText());
		// point fileChooser at a carefully chosen default
		defDir = new File(path);
		fileChooser.setCurrentDirectory(defDir);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Impress Slides", "odp"));
		fileChooser.setAcceptAllFileFilterUsed(true);
		fileChooser.setMultiSelectionEnabled(false);
				
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
	    	txtShowPath.setText(selectedFile.getAbsolutePath());
		    System.out.println("Show File Path: " + selectedFile.getAbsolutePath());
		    setStatus("Path to show set");
		    }
		else {
			setStatus(""); // clear status line on cancel without change
		}
	}
	
	protected void addShowToList()
	{
		String showPath = txtShowPath.getText();
		showList.addElement(showPath);		
	}
	
	protected void saveShowList()
	{
		
	}
	
	
	protected void openShowList()
	{
		
	}
	
	protected void moveShowToTop()
	{
		int selIndex = listShows.getSelectedIndex();
		if ( selIndex == -1 ) {
			setStatus("Select a show first");
			return;
		}
		// rip it out and put it back at top
		String showPath = showList.remove(selIndex);
		showList.add( 0,  showPath );
		listShows.setSelectedIndex(0);
		setStatus("Show moved to top");
	}
	
	protected void moveShowUp()
	{
		int selIndex = listShows.getSelectedIndex();
		if ( selIndex == -1 ) {
			setStatus("Select a show first");
			return;
		}
		if ( selIndex == 0 ) {
			setStatus("Show is at the top");
			return;
		}
		// rip it out and put it back one at lower index
		String showPath = showList.remove(selIndex);
		showList.add( selIndex-1,  showPath );
		listShows.setSelectedIndex(selIndex-1);
		setStatus("Show moved up");

	}
	
	protected void moveShowDown()
	{
		int selIndex = listShows.getSelectedIndex();
		if ( selIndex == -1 ) {
			setStatus("Select a show first");
			return;
		}
		int count = showList.size();
		if ( selIndex == (count-1) ) {
			setStatus("Show is at the bottom");
			return;
		}
		// rip it out and put it back at higher index
		String showPath = showList.remove(selIndex);
		showList.add( selIndex+1,  showPath );
		listShows.setSelectedIndex(selIndex+1);
		setStatus("Show moved down");

	}
	
	protected void removeSelectedShow()
	{
		int selIndex = listShows.getSelectedIndex();
		if ( selIndex == -1 ) {
			setStatus("Select a show first");
			return;
		}

		// rip it out
		String showPath = showList.remove(selIndex);
		setStatus("Show removed");

	}
	
	protected void removeAllShows()
	{
		//listShows.removeAll();
		showList.clear();
		setStatus("All shows removed");
	}
	
	
	protected void startShows()
	{
		
	}
	
	protected void stopShows()
	{
		
		
	}
	
	
	protected void showHelpDialog()
	{
		 System.out.println( "ShowRunnerEvents::showHelpDialog" );
		HelpDialog dlg = new HelpDialog( new JFrame(), "no title here", true);
		dlg.setVisible(true);
	}
	
	
	
	
	/**
	* Catch all the events here in the child class
	* use the same actionPerformed listener for every action
	* Qt has it's problems, but at least you don't have to write
	* a command dispatcher. Here in Java, it looks like the easiest way
	* to deal with events from a GUI is to use setActionCommand("string") and
	* then to dispatch those commands here.
	* 
	* In Qt, the dispatcher is built into the framework, so you don't need to build
	* a dispatcher based on text string. Oh Well. Deployment in Qt is a nightmare,
	* which is why I'm here, and this is much less of a problem than the Qt Deployment
	* issue.
	* 
	* Note we are using the meaningful Gui Object name, like btnAddShow or
	* mntmHelpDialog as the "command string", just to keep things consistent
	* and easy. And of course, we have moved all event processing to the child class.
	* Separation of Form and Function into different classes.
	**/
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println( "ShowRunnerEvents::actionPerformed" );
		// get the command string we set in the dialog
	    String actionCommand = e.getActionCommand();

	    //System.out.println( "ShowRunnerEvents::actionPerformed "+actionCommand );
	    // build a dispatcher on those command strings, which are the names
	    // of the gui items to keep it simple.
	    // don't do code here, but call another method to actually do the work
	    // to keep the dispatcher more readable.
	    System.out.println( "ShowRunnerEvents::actionPerformed "+actionCommand );
	    switch (actionCommand) {
	    case "btnBrowseForImpress":
	    	browseForImpressProgram();
    	break;
        case "btnBrowseForShow": 
        	browseForShowToAdd();
        break;
        case "btnAddShow": 
        	addShowToList();
        break;
        case "btnRemoveAll": {
        	removeAllShows();
        	break;
        }
        case "btnRemoveSelected": {
        	removeSelectedShow();
        	break;
        }
        case "btnStartShows": {
        	break;
        }
        case "btnStopShows": {
        	break;
        }
        case "btnMoveTop": {
        	moveShowToTop();
        	break;
        }
        case "btnMoveUp": {
        	moveShowUp();
        	break;
        }
        case "btnMoveDown": {
        	moveShowDown();
        	break;
        }
        case "mntmOpenShowList": {
        	openShowList();
        	break;
        }
        case "mntmSaveShowList": {
        	saveShowList();
        	break;
        }
        case "mntmQuit": {
        	// do as little as possible
        	// allow the framework to do it all
        	dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        	
        }
        case "mntmHelpDialog": {
        	showHelpDialog();
        }
        default:
        {
    	    //System.out.println( "ShowRunnerEvents::Woops "+actionCommand );
        	break;
        }
	    }
	}
}
/**
 * mntmOpenShowList
 * mntmSaveShowList
 * mntmQuit
 * mntmHelpDialog
 * mntmAboutDialog
 * btnBrowseForImpress
 * btnBrowseForShow
 * btnAddShow
 * btnRemoveAll
 * btnRemoveSelected
 * btnStartShows
 * btnStopShows
 * btnMoveTop
 * btnMoveUp
 * btnMoveDown
 */

