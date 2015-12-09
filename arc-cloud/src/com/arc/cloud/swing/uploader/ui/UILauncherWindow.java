package com.arc.cloud.swing.uploader.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.arc.cloud.dao.hib2.hib.codegen.Organization;
import com.arc.cloud.dao.hib2.hib.codegen.Projecttaxonomy;
import com.arc.cloud.dao.util.UIDBUtil;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Panel;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Window.Type;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Label;
import java.awt.Button;
import java.awt.SystemColor;

public class UILauncherWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private JInternalFrame internalFrameDocument;
	JInternalFrame internalFrameProject = new JInternalFrame("Project & Taxonomy Upload");
	private JTable table;
	private JTable table2;
	private JTextField textField_1;
	private JTable table_1;
	private JPasswordField textField_2;
	private JTextField textField_3;
	private JPasswordField textField_4;

	// ProjectJInternalFrame internalFrame2 = new ProjectJInternalFrame() ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UILauncherWindow frame = new UILauncherWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UILauncherWindow() {
		internalFrameProject.setVisible(false);

		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 902, 24);
		contentPane.add(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmValidate = new JMenuItem("Validate & Upload");
		mntmValidate.setEnabled(false);
		mntmValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				internalFrameProject.setVisible(false);
				internalFrameDocument.setBounds(10, 11, 862, 367);
				internalFrameDocument.setVisible(true);
			}
		});
		mnFile.add(mntmValidate);

		JMenuItem mntmProjectAndTaxonomy = new JMenuItem("Project and Taxonomy");
		mntmProjectAndTaxonomy.setEnabled(false);
		mntmProjectAndTaxonomy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrameDocument.setVisible(false);
				internalFrameProject.setBounds(10, 11, 862, 367);
				internalFrameProject.setVisible(true);

			}
		});
		mnFile.add(mntmProjectAndTaxonomy);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);

		JMenuItem mntmExit_1 = new JMenuItem("Exit");
		mnHelp.add(mntmExit_1);
		JDesktopPane desktopPane = new JDesktopPane();
		//
		// JDesktopPane desktopPane = new MyDesktopPane();

		desktopPane = new MyDesktopPane();
		desktopPane.setBounds(10, 23, 882, 389);
		contentPane.add(desktopPane);

		internalFrameDocument = new JInternalFrame("Bulk Content - Validate & Upload");
		//
		// internalFrame.setBounds(10, 11, 862, 367);
		desktopPane.add(internalFrameDocument);
		internalFrameDocument.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Validate", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 0, 671, 120);
		internalFrameDocument.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Select Excel sheet contains file uplod information", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(10, 22, 654, 84);
		panel.add(panel_1);

		JButton button = new JButton("Select File");
		button.setBounds(10, 24, 149, 23);
		panel_1.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(internalFrameProject);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					// This is where a real application would open the file.
					textField.setText(file.getAbsolutePath());
				}

			}
		}
				);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(170, 25, 458, 20);
		panel_1.add(textField);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Loaded Data", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Loaded Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 131, 661, 195);
		internalFrameDocument.getContentPane().add(panel_2);


		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 640, 159);
		panel_2.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setColumnSelectionAllowed(true);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(681, 11, 155, 315);
		internalFrameDocument.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JButton button_1 = new JButton("Load File");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// hard coded path 
				textField.setText("C:\\temp\\JXL-Upload.xls");
				// hard coded path 
				String fileName = textField.getText();

				System.out.println("UILauncherWindow.UILauncherWindow().new ActionListener() {...}.actionPerformed()" + fileName);
				DefaultTableModel pmodel = new DefaultTableModel();
				
				table.setModel(pmodel);
				
				pmodel.addColumn("id");
				pmodel.addColumn("Document Obj ID");
				pmodel.addColumn("Project");
				pmodel.addColumn("Taxonomy 1 ");
				pmodel.addColumn("Taxonomy 2");
				pmodel.addColumn("Document Name");
				pmodel.addColumn("Document TItle");
				pmodel.addColumn("Create Date");
				pmodel.addColumn("Keywords");
				pmodel.addColumn("Metadata");
				pmodel.addColumn("Organization");

				
				ProjectTaxVO2 vo = new ProjectTaxVO2();
				vo.setId(10);
				try{
					UIDBUtil.populateModelUpload(pmodel, new File(fileName));
				}catch(Exception e){
					e.printStackTrace();
				}
				
				
			
			}
		});
		button_1.setBounds(38, 36, 107, 23);
		panel_3.add(button_1);


		JButton btnUpload = new JButton("Validate & Upload");
		btnUpload.setBounds(38, 281, 107, 23);
		panel_3.add(btnUpload);
		
		
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Validate and load");
			}
		}
				
				
				);

		desktopPane.add(internalFrameProject);
		internalFrameProject.getContentPane().setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Select FIle", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 11, 641, 60);
		internalFrameProject.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JButton btnNewButton = new JButton("Select File");
		btnNewButton.setBounds(10, 26, 89, 23);
		panel_4.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(internalFrameProject);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					// This is where a real application would open the file.
					textField_1.setText(file.getAbsolutePath());
				}

			}
		});
		textField_1 = new JTextField();
		textField_1.setBounds(109, 27, 495, 20);
		panel_4.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 82, 641, 244);
		internalFrameProject.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 621, 222);
		panel_5.add(scrollPane_1);
		scrollPane.setBounds(10, 25, 640, 159);
		panel_2.add(scrollPane);
		
		
		//table_1 = new JTable(rowData2,columnNames2);
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
	
		table_1.setColumnSelectionAllowed(false);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(661, 11, 175, 315);
		internalFrameProject.getContentPane().add(panel_6);
		panel_6.setLayout(null);

		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(54, 28, 83, 23);
		panel_6.add(btnLoad);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// hard coded path 
				textField_1.setText("C:\\temp\\JExcelExample.xls");
				// hard coded path 
				String fileName = textField_1.getText();

				System.out.println("UILauncherWindow.UILauncherWindow().new ActionListener() {...}.actionPerformed()" + fileName);
				DefaultTableModel pmodel = new DefaultTableModel();
				
				table_1.setModel(pmodel);
				pmodel.addColumn("id");
				pmodel.addColumn("Organization");
				pmodel.addColumn("Project Name");
				pmodel.addColumn("Project Desc");
				pmodel.addColumn("Taxonomy level1");
				pmodel.addColumn("Taxonomy level2");
				ProjectTaxVO2 vo = new ProjectTaxVO2();
				vo.setId(10);
				try{
					UIDBUtil.populateModel(pmodel, new File(fileName));
				}catch(Exception e){
					e.printStackTrace();
				}
				
				
			
			}
		});


		JButton btnUpload_1 = new JButton("Validate & Upload");
		btnUpload_1.setBounds(54, 270, 83, 23);
		panel_6.add(btnUpload_1);
		
		btnUpload_1.addActionListener(new ActionListener() {
			Thread thread = null;
			public void actionPerformed(ActionEvent arg0) {
			
				 thread = new Thread(new ValidateUploadThread(table_1));
				 thread.start();
				
			}
		});
		JInternalFrame loginInternalFrame = new JInternalFrame("Login ..");
		loginInternalFrame.getContentPane().setBackground(SystemColor.activeCaption);
		loginInternalFrame.setBounds(101, 71, 608, 254);
		desktopPane.add(loginInternalFrame);
		loginInternalFrame.getContentPane().setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBackground(new Color(0, 153, 204));
		panel_7.setBounds(10, 32, 572, 157);
		loginInternalFrame.getContentPane().add(panel_7);
		panel_7.setLayout(null);

		JLabel lblPleaseEnterOrganization = new JLabel("Please enter organization Code");
		lblPleaseEnterOrganization.setBounds(10, 33, 204, 14);
		panel_7.add(lblPleaseEnterOrganization);

		JLabel lblPleaseEnterUser = new JLabel("Please enter User Name");
		lblPleaseEnterUser.setBounds(10, 65, 144, 14);
		panel_7.add(lblPleaseEnterUser);

		JLabel lblPleaseEnterPassword = new JLabel("Please enter Password");
		lblPleaseEnterPassword.setBounds(10, 90, 144, 14);
		panel_7.add(lblPleaseEnterPassword);

		textField_2 = new JPasswordField();
		textField_2.setBounds(224, 33, 92, 20);
		panel_7.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(224, 65, 197, 20);
		panel_7.add(textField_3);

		textField_4 = new JPasswordField();
		textField_4.setColumns(10);
		textField_4.setBounds(224, 90, 197, 20);
		panel_7.add(textField_4);

		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1.setBounds(96, 115, 89, 23);
		panel_7.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_2.getText().trim().length() == 0) {
					textField_2.setBackground(new Color(125, 0, 0));

				}
				if (textField_3.getText().trim().length() == 0) {
					textField_3.setBackground(new Color(125, 0, 0));
				}
				if (textField_4.getText().trim().length() == 0) {
					textField_4.setBackground(new Color(125, 0, 0));
				}

				if ((textField_2.getText().trim().length() > 0) && (textField_3.getText().trim().length() > 0)
						&& (textField_4.getText().trim().length() > 0)) {
					boolean isvalidUser = false; //UIDBUtil.login(/*textField_2.getText(),*/ textField_3.getText(),textField_4.getText());
					if (isvalidUser) {
						mntmValidate.setEnabled(true);
						mntmProjectAndTaxonomy.setEnabled(true);
						internalFrameProject.setVisible(true);
						loginInternalFrame.setVisible(false);
						internalFrameProject.setBounds(10, 11, 862, 367);
						internalFrameDocument.setVisible(false);

					} else {
						JOptionPane.showMessageDialog(loginInternalFrame, "Login Failed .. Please try again ");
						textField_4.setBackground(Color.WHITE);
						textField_3.setBackground(Color.WHITE);
						textField_2.setBackground(Color.WHITE);
					}
				}

			}
		});
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(SystemColor.text);
		btnCancel.setBackground(new Color(0, 153, 204));
		btnCancel.setBounds(293, 115, 89, 23);
		panel_7.add(btnCancel);
		loginInternalFrame.setVisible(true);
		internalFrameProject.setVisible(true);
		internalFrameDocument.setVisible(false);
		// HC vales

		textField_2.setText("ACC");
		textField_3.setText("phelan1");
		textField_4.setText("porttitor");

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});

	}

	class MyDesktopPane extends JDesktopPane {
		Image img;

		public MyDesktopPane() {
			try {
				img = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Arc0.jpg"), "Arc0.jpg"));
			} catch (Exception e) {

				e.printStackTrace();
			} // do nothing
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (img != null)
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			else
				g.drawString("Image not found", 50, 50);
		}
	}
	

	
	
		  



}
 class StatusColumnCellRenderer extends DefaultTableCellRenderer {
	  @Override
	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
	    //Cells are by default rendered as a JLabel.
	    JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
	    l.setBackground(Color.GREEN.brighter());
	    //Get the status for the current row.
	  System.out.println("UILauncherWindow.StatusColumnCellRenderer.getTableCellRendererComponent()" + row + "\t"+col +value);
	    if(value!=null){
	    	if(value.toString().startsWith("Upload Not Successful")){
	    		l.setBackground(Color.RED.brighter());
	    	}else{
	    		l.setBackground(Color.GREEN.brighter());
	    	}
	    }
	  //Return the JLabel which renders the cell.
	  return l;

	}
}

class ValidateUploadThread implements Runnable{
	
	public ValidateUploadThread() {
		// TODO Auto-generated constructor stub
	}
	
	ValidateUploadThread(JTable table){
		this.table2 = table;
	}
	JTable table2 ;

	public void run() {

		JTable table_1 = this.table2;
		DefaultTableModel pModal= (DefaultTableModel)table_1.getModel();
		pModal.addColumn("Validate Result");
		
		table_1.getColumnModel().getColumn(6).setCellRenderer(new StatusColumnCellRenderer());
		// Start validating 
		int noOfRows = table_1.getRowCount();
		for(int i=0;i<noOfRows;i++){
			// processing per row
			Object dataId = table_1.getModel().getValueAt(i, 0);
			Object dataOrg = table_1.getModel().getValueAt(i, 1);
			Object dataProjectName = table_1.getModel().getValueAt(i, 2);
			Object dataProjDesc = table_1.getModel().getValueAt(i, 3);
			Object dataTax1 = table_1.getModel().getValueAt(i, 4);
			Object dataTax2 = table_1.getModel().getValueAt(i, 5);
			//Object dataId = table_1.getModel().getValueAt(i, 0);
			
			Projecttaxonomy taxonomyObj = new Projecttaxonomy();
			Organization org = new Organization();
			org.setId(10);
			org.setOrgname(dataOrg.toString());
			taxonomyObj.setOrganization(org);
			taxonomyObj.setProjectname(dataProjectName.toString());
			taxonomyObj.setProjectdesc(null);
			taxonomyObj.setTaxonomylevel1(dataTax1.toString());
			
			taxonomyObj.setTaxonomylevel2(dataTax2.toString());
			try{
				UIDBUtil.addProjectTaxonomy(taxonomyObj);	
				 table_1.getModel().setValueAt(new String("Upload  Successful") , i, 6);
				 table_1.changeSelection(i, 6, false, false);
			}catch(Exception ex){
				Throwable cause = ex.getCause();
		        if (cause instanceof SQLException) {
		        	String msg = cause.getMessage();
		            System.out.println(msg);
		            table_1.getModel().setValueAt(new String("Upload Not Successful") + msg, i, 6);
		            table_1.changeSelection(i, 6, false, false);
		        }
			}
		}
		
	}
	
	class ValidateUploadThreadUpload implements Runnable{
		
		public ValidateUploadThreadUpload() {
			// TODO Auto-generated constructor stub
		}
		
		ValidateUploadThreadUpload(JTable table){
			this.table2 = table;
		}
		JTable table2 ;

		public void run() {

			JTable table_1 = this.table2;
			DefaultTableModel pModal= (DefaultTableModel)table_1.getModel();
			pModal.addColumn("Validate Result");
			table_1.getColumnModel().getColumn(6).setCellRenderer(new StatusColumnCellRenderer());
			// Start validating 
			int noOfRows = table_1.getRowCount();
			for(int i=0;i<noOfRows;i++){
				// processing per row
				Object dataId = table_1.getModel().getValueAt(i, 0);
				Object dataOrg = table_1.getModel().getValueAt(i, 1);
				Object dataProjectName = table_1.getModel().getValueAt(i, 2);
				Object dataProjDesc = table_1.getModel().getValueAt(i, 3);
				Object dataTax1 = table_1.getModel().getValueAt(i, 4);
				Object dataTax2 = table_1.getModel().getValueAt(i, 5);
				//Object dataId = table_1.getModel().getValueAt(i, 0);
				
				Projecttaxonomy taxonomyObj = new Projecttaxonomy();
				Organization org = new Organization();
				org.setId(10);
				org.setOrgname(dataOrg.toString());
				taxonomyObj.setOrganization(org);
				taxonomyObj.setProjectname(dataProjectName.toString());
				taxonomyObj.setProjectdesc(null);
				taxonomyObj.setTaxonomylevel1(dataTax1.toString());
				
				taxonomyObj.setTaxonomylevel2(dataTax2.toString());
				try{
					UIDBUtil.addProjectTaxonomy(taxonomyObj);	
					 table_1.getModel().setValueAt(new String("Upload  Successful") , i, 6);
					 table_1.changeSelection(i, 6, false, false);
				}catch(Exception ex){
					Throwable cause = ex.getCause();
			        if (cause instanceof SQLException) {
			        	String msg = cause.getMessage();
			            System.out.println(msg);
			            table_1.getModel().setValueAt(new String("Upload Not Successful") + msg, i, 6);
			            table_1.changeSelection(i, 6, false, false);
			        }
				}
			}
			
		}	
	}
}
