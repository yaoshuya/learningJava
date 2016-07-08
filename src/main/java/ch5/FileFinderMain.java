package ch5;

   

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Utils.SpringUtils;

public class FileFinderMain {

    private JTextField keyword;
    /** Used to open/edit/print files. */ 
    private Desktop desktop;
	private JPanel gui;
	private JTable table;
	private JButton search;
    private FileTableModel fileTableModel;
    private ListSelectionListener listSelectionListener;
    private CliHandler myhandler = null;
    
    public void setCliHandler(CliHandler cli){
    	myhandler = cli;
    }
    
	public static void main(String[] args) throws IOException {
		FileIndexTask myFileIndex = SpringUtils.getBean("myFileIndex",FileIndexTask.class);
		myFileIndex.run();
	     
		SwingUtilities.invokeLater(new Runnable(){ 
			@Override
			public void run() { 
				CliHandler clihandler = (CliHandler) SpringUtils
						.getBean("myCliHandler");
				 FileFinderMain fs = new FileFinderMain();
				 fs.setCliHandler(clihandler);
				 fs.createAndShowGUI();
			} 
		});
	}
	
	private  void createAndShowGUI() {
	    //Create and set up the window.
        JFrame frame = new JFrame("FileSearch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane( addComponentsToPane() );
         //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
	
	  public  Container addComponentsToPane() {
            desktop = Desktop.getDesktop();
            gui = new JPanel(new BorderLayout(3, 3));
            gui.setBorder(new EmptyBorder(5, 200, 200, 5));
            
            keyword = new JTextField(40); 
            gui.add(keyword,BorderLayout.PAGE_START);
            
            search = new JButton("Search");
            gui.add(search,BorderLayout.EAST);
            search.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                	//search the file and send data to table
                	setTableData(myhandler.filterKeyword(keyword.getText()));
                }
            });
            
            listSelectionListener = new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    int row = table.getSelectionModel().getLeadSelectionIndex();
                    openFile(((FileTableModel) table.getModel()).getFile(row));
                }
            };
            
            table = new JTable();
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setAutoCreateRowSorter(true);
            table.setShowVerticalLines(false);
            
            JScrollPane tableScroll = new JScrollPane(table); 
            tableScroll.setSize(240, 240);
            gui.add(tableScroll,BorderLayout.CENTER);
 
            return gui;
	    }
	  
	  protected void openFile(Tuple file) { 
		  try {
			desktop.open(new File(file.getRight()));
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}

	private void setTableData(final Tuple[] files) {
	        SwingUtilities.invokeLater(new Runnable() { 

				public void run() {
	                if (fileTableModel == null) {
	                    fileTableModel = new FileTableModel();
	                    table.setModel(fileTableModel);
	                }
	                table.getSelectionModel().removeListSelectionListener(listSelectionListener);
	                fileTableModel.setFiles(files);
	                table.getSelectionModel().addListSelectionListener(listSelectionListener); 
	            }
	    });
	   }
}
