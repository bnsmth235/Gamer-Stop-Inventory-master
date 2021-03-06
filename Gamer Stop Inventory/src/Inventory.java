/*
 * Simple UI for documenting an inventory for a fake
 * game store that can be used as an employee or just a customer
 * stores the name, price, system etc
 * 
 * @author Ben and Adam Smith
 * @version 1.0
 * @Since January 19, 2018
 * 
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class Inventory {
	
	public static String srch_in;
	public static String title_data[][] = new String[1000][1000];
	public static String column[]={"Title","Platform", "Price for Sale","Condition","Cost"};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("Gamer Stop Inventory");
		frame.setSize(950, 300);
		frame.setLocation(400, 300);
	
		File file=new File("src\\timpview.png");
		String filepath=file.getAbsolutePath();
		ImageIcon t_bird_icon=new ImageIcon(filepath);
		frame.setIconImage(t_bird_icon.getImage());
		
		frame.setLayout(null);	
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container b=frame.getContentPane();
		b.setBackground(Color.orange);
		
		JLabel title= new JLabel("Are you a customer or an Employee?");
		title.setBounds(333,25,666,75);
		
		JButton e=new JButton("Employee");	//two different buttons
		JButton c=new JButton("Customer");
		
		e.setBounds(225,125,100,50); //where each button is positioned
		c.setBounds(550,125,100,50);
		
		frame.add(title); frame.add(e); frame.add(c);//adding each of the components to the frame
		
		c.addActionListener(new ActionListener(){ //if you press the customer button...
			public void actionPerformed(ActionEvent e){
				frame.setVisible(false);
				try {
					customer();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				} //goes to the start method
			}
		});
		e.addActionListener(new ActionListener(){ //if you press the employee button
			public void actionPerformed(ActionEvent e){
				frame.setVisible(false);
				employee();
			}
		});
	}

	
	public static void employee(){
		//gets rid of old window
		
		JFrame login_frame = new JFrame("Employee Login");
		login_frame.setSize(300, 300);	
		login_frame.setLocation(700,300);
		login_frame.setLayout(null); //new window setup
		login_frame.setVisible(true);
		login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		File file=new File("src\\timpview.png");
		String filepath=file.getAbsolutePath();
		ImageIcon t_bird_icon=new ImageIcon(filepath);
		login_frame.setIconImage(t_bird_icon.getImage());
		
		Container c=login_frame.getContentPane();
		c.setBackground(Color.orange);
				
		final JPasswordField pass = new JPasswordField(); //Password field text entry
		pass.setBounds(100,75,100,30);   
			    
		final JTextField user = new JTextField();  
		user.setBounds(100,20, 100,30); //username entry
			    
		JLabel l1=new JLabel("Username:");    
		l1.setBounds(20,20, 80,30);   //just username title
			    
		JLabel l2=new JLabel("Password:");    
		l2.setBounds(20,75, 80,30);    //password title
			    
		JButton b = new JButton("Login");  
		b.setBounds(100,120, 90,30);   //login button 
			    
		JButton r=new JButton("Register");
		r.setBounds(100, 160, 90, 30);
		
		JButton back=new JButton("Back to Main");
		back.setBounds(86, 200, 115, 30);		
		
		JLabel incorrect=new JLabel("Username or Password Incorrect");
		incorrect.setBounds(48,38,200,50);
		incorrect.setVisible(false);
		login_frame.add(pass); login_frame.add(l1); login_frame.add(l2); login_frame.add(b); 
		login_frame.add(user); login_frame.add(r); login_frame.add(back); login_frame.add(incorrect);//add all components to frame
			    
		b.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
			    String username = user.getText();  //gets input from the frame and saves into variables
			    @SuppressWarnings("deprecation")
				String password = pass.getText();
			    if(username.equals("") || password.equals("")) {
			    	incorrect.setVisible(true);
			    }else {
			    	try {
			    		if(FileReader_user_pass(username, password)==true){ //if the inputted username and password are in the saved list
			    			JLabel welcome=new JLabel("Welcome "+username); //says welcome [username]
			    			welcome.setBounds(75,200,100,100);
			    			login_frame.add(welcome);
			    			login_frame.setVisible(false);
			    			e_search_frame();
			    		}else{
			    			//you need something here to make it say that you got the username/password wrong
			    			incorrect.setVisible(true);
			    		}
			    	} catch (IOException e1) {
			    		e1.printStackTrace();//idk why this is here, but it doesnt work without it
			    	}
			    }
			 }  
		});  
			    
		r.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				login_frame.setVisible(false);
			    		
			    JFrame register=new JFrame("Register New Employee");
			    register.setSize(300,350);
			    register.setLayout(null);
			    register.setVisible(true);
			    register.setLocation(700,300);
			    register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    File file=new File("src\\timpview.png");
				String filepath=file.getAbsolutePath();
				ImageIcon t_bird_icon=new ImageIcon(filepath);
				register.setIconImage(t_bird_icon.getImage());
				
			    Container c=register.getContentPane();
				c.setBackground(Color.orange);
			    		
			    JLabel reg_label=new JLabel("Welcome new employee!");
			    reg_label.setBounds(90,15,200,25);
						
				JPasswordField pass = new JPasswordField(); //Password field text entry
				pass.setBounds(130,100,100,30);   
					    
				JTextField user = new JTextField();  
				user.setBounds(130,50,100,30); //username entry
					    
				JPasswordField confirm= new JPasswordField(); //confirm Password field text entry
				confirm.setBounds(130,150,100,30);
					    
				JLabel l1=new JLabel("Username:");    
				l1.setBounds(57,50, 80,30);   //just username title
					    
				JLabel l2=new JLabel("Password:");    
				l2.setBounds(57,100, 80,30);    //password title
					    
				JLabel l3=new JLabel("Confirm Password:");    
				l3.setBounds(10,150,150,30); 
					    
				JButton b = new JButton("Login");  
				b.setBounds(130,220, 90,30);   //login button 
				
				JButton back= new JButton("Back to Login");
				back.setBounds(116, 260, 115, 30);
					    
				register.add(user); register.add(pass); register.add(reg_label); register.add(l2);
			    register.add(b); register.add(l1); register.add(l3); register.add(confirm); register.add(back);
			    		
			    b.addActionListener(new ActionListener(){
			    	public void actionPerformed(ActionEvent a){
			    		String password=user.getText();
			    		@SuppressWarnings("deprecation")
						String c_password=confirm.getText();
			    				
			    		if(password.equals(c_password)){
			    			employee();
			    		}
			    	}
			    });
			    
			    back.addActionListener(new ActionListener(){
			    	public void actionPerformed(ActionEvent b){
			    		register.setVisible(false);
			    		employee();
			    	}
			    });
			 }
		});
		back.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent b){
	    		login_frame.setVisible(false);
	    		try {
					main(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    });	
	}
	
	@SuppressWarnings("rawtypes")
	public static void e_search_frame() throws IOException{
		JFrame e_frame=new JFrame("Employee Inventory Search");
		e_frame.setSize(350, 400);
		e_frame.setLocation(400, 350);
		e_frame.setLayout(null);
		e_frame.setVisible(true);
		e_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		File file=new File("src\\timpview.png");
		String filepath=file.getAbsolutePath();
		ImageIcon t_bird_icon=new ImageIcon(filepath);
		e_frame.setIconImage(t_bird_icon.getImage());
		
		Container c=e_frame.getContentPane();
		c.setBackground(Color.orange);
		
		JFrame add_frame=new JFrame("Add Game Info");
		add_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel e_start=new JLabel("Search for a Title by Name or Console");//title at top of frame
		e_start.setBounds(50,15,666,75);
		
		String[] e_console={"Select Console","PS4","XBox One", "Switch"}; //list of consoles
		@SuppressWarnings("unchecked")
		JComboBox e_consoles=new JComboBox(e_console);
		e_consoles.setBounds(80, 90, 130, 30);
		
		JLabel e_title_label=new JLabel("Game Title:");//title
		e_title_label.setBounds(20, 150, 100, 30);
		
		JTextField e_title=new JTextField(); //search entry
		e_title.setBounds(100, 150, 180, 30);
		
		JButton e_search=new JButton("Search");
		e_search.setBounds(90, 220, 80, 30);//enter button basically
		
		JButton back=new JButton("Back to Main");
		
		JButton add=new JButton("Add");
		add.setBounds(170, 220, 70, 30);
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent add) {
				add_frame.setSize(1100, 160);
				add_frame.setLocation(400, 750);
				add_frame.setLayout(null);
				add_frame.setVisible(true);
				File file=new File("src\\timpview.png");
				String filepath=file.getAbsolutePath();
				ImageIcon t_bird_icon=new ImageIcon(filepath);
				add_frame.setIconImage(t_bird_icon.getImage());
				
				Container c=add_frame.getContentPane();
				c.setBackground(Color.orange);
				
				JTextField title=new JTextField();
				title.setBounds(60, 10, 150, 30);
				JLabel title_label=new JLabel("Title:");
				title_label.setBounds(20,10,50,30);
				
				JTextField console=new JTextField();
				console.setBounds(270, 10, 150, 30);
				JLabel console_label=new JLabel("Console:");
				console_label.setBounds(215,10,50,30);
				
				JTextField price=new JTextField();
				price.setBounds(490, 10,150, 30);
				JLabel price_label=new JLabel("Price:");
				price_label.setBounds(448,10,50,30);
				
				JTextField condition=new JTextField();
				condition.setBounds(710, 10, 150, 30);
				JLabel condition_label=new JLabel("Condition:");
				condition_label.setBounds(650,10,70,30);
				
				JTextField cost=new JTextField();
				cost.setBounds(930, 10, 150, 30);
				JLabel cost_label=new JLabel("Cost:");
				cost_label.setBounds(890,10,50,30);
				
				JButton enter=new JButton("Enter");
				enter.setBounds(420, 70, 80, 30);
				enter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent a) {
						String title1=title.getText();
						String console1=console.getText();
						String price1=price.getText();
						String condition1=condition.getText();
						String cost1=cost.getText();
						
						try {
							FileWriter(title1,console1,price1,condition1,cost1);
						} catch (IOException e) {
							e.printStackTrace();
						}
						add_frame.setVisible(false);
					}
				});
				
				JButton cancel=new JButton("Cancel");
				cancel.setBounds(520, 70, 80, 30);
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent b) {
						add_frame.setVisible(false);
					}
				});
				
				add_frame.add(title); add_frame.add(title_label);add_frame.add(console_label); add_frame.add(console); add_frame.add(price);
				add_frame.add(condition); add_frame.add(cost);add_frame.add(cost_label);add_frame.add(condition_label);add_frame.add(price_label);
				add_frame.add(enter); add_frame.add(cancel);
			}
		});
		
		e_frame.add(e_start); e_frame.add(e_consoles); e_frame.add(e_title_label); 
		e_frame.add(e_title); e_frame.add(e_search); e_frame.add(back); e_frame.add(add); //add all components to the frame
		
		JFrame e_inventory_list=new JFrame("Searched Inventory");
		e_inventory_list.setSize(750, 400);
		e_inventory_list.setLayout(null);
		e_inventory_list.setLocation(750, 350);
		e_inventory_list.setIconImage(t_bird_icon.getImage());
		e_inventory_list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container a=e_inventory_list.getContentPane();
		a.setBackground(Color.orange);
		
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Title"); model.addColumn("Console"); model.addColumn("Price for Sale");
		model.addColumn("Condition"); model.addColumn("Cost");
		
		String[] row_appender=new String[5];
		
		e_search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent b){
				
				if (model.getRowCount() > 0) {
				    for (int i = model.getRowCount() - 1; i > -1; i--) {
				        model.removeRow(i);
				    }
				}
				
				String game_title=e_title.getText(); //puts searched title into the variable       
			    String data=(String) e_consoles.getItemAt(e_consoles.getSelectedIndex());  //gets which console they chose and saves it into an object
			    
			    try {
			    	String list[]=new String[1000];
			    	int maxIndx=-1;
			    	File game_titles=new File("src\\Game_titles.txt");
					String game_titles_path=game_titles.getAbsolutePath();
			    	Scanner scan=new Scanner(new File(game_titles_path));

			    	while(scan.hasNextLine()){
			    		String find_line=scan.nextLine();
			    		if(find_line.toLowerCase().contains(game_title.toLowerCase())){ //checks if the word (lower case) is in any words or 
			    			if(data.equals("Select Console")){
								maxIndx++;
								list[maxIndx]=find_line;
							}else if(find_line.toLowerCase().contains(data.toLowerCase())){
			    				maxIndx++;
			    				list[maxIndx]=find_line;
			    			}
			    		}
			    	}
			    	for(int j=0;j<=maxIndx;j++){ //iterates through every line containing what was searched
			    		String split_read_data[]=list[j].split(", ");
			    		int x=0;
				    	for(int a=0;a<=split_read_data.length-1;a++){ //this takes the data from search_data and splits it into its individual parts: name, console, condition, price, cost
				    		if(a/5==0){   //if a is not 5...
				    			row_appender[x]=split_read_data[a];
				    			x++;
				    		}
				    	}
				    	model.addRow(row_appender);
			    	}
			    	scan.close();
			    	
			    } 
			    catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			    }
			}
		});
		JTable area=new JTable(model);
		JScrollPane scroll=new JScrollPane(area);
		scroll.setBounds(0,0,750,400);
		scroll.setViewportView(area);
		e_inventory_list.setVisible(true);
		e_inventory_list.add(scroll);
		
		back.setBounds(75, 300, 150, 30);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				try {
					e_frame.setVisible(false);
					add_frame.setVisible(false);
					e_inventory_list.setVisible(false);
					main(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void customer() throws IOException{
		JFrame c_frame=new JFrame("Customer Inventory Search");
		c_frame.setSize(1000, 500);
		c_frame.setLocation(400, 200);
		c_frame.setLayout(null);
		c_frame.setVisible(true);
		c_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		File file=new File("src\\timpview.png");
		String filepath=file.getAbsolutePath();
		ImageIcon t_bird_icon=new ImageIcon(filepath);
		c_frame.setIconImage(t_bird_icon.getImage());
		
		Container c=c_frame.getContentPane();
		c.setBackground(Color.orange);
		
		JLabel c_start=new JLabel("Search for a Title by Name or Console");//title at top of frame
		c_start.setBounds(50,15,666,75);
		
		String[] console={"Select Console","PS4","XBox One", "Switch"}; //list of consoles
		@SuppressWarnings({ "rawtypes", "unchecked" })// i dont know why this needs to be here but it do
		JComboBox consoles=new JComboBox(console);
		consoles.setBounds(80, 90, 125, 30);
		
		JLabel title_label=new JLabel("Game Title:");//title
		title_label.setBounds(20, 150, 100, 30);
		
		JTextField title=new JTextField(); //search entry
		title.setBounds(100, 150, 180, 30);
		
		JButton search=new JButton("Search");
		search.setBounds(75, 220, 80, 30);//enter button basically
		
		JTextArea area=new JTextArea();
		JScrollPane scroll=new JScrollPane(area);
		scroll.setBounds(300,30,600,400);
		scroll.setViewportView(area);
		area.setEditable(false);
		
		JButton back=new JButton("Back to Main");
		back.setBounds(155, 220, 120, 30);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b){
				c_frame.setVisible(false);
				try {
					main(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		c_frame.add(scroll); c_frame.add(c_start); c_frame.add(consoles); c_frame.add(title_label); 
		c_frame.add(title); c_frame.add(search); c_frame.add(back); //add all components to the frame
		
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				area.setText(null);
				String game_title=title.getText(); //puts searched title into the variable       
			    String data=(String) consoles.getItemAt(consoles.getSelectedIndex());  //gets which console they chose and saves it into an object
			   
			    try {
			    	area.append(FileReader_c_game_titles(game_title,data)+"\n"); //adds the part of the file that is what they searched for to the text area
			    	
			    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			    }
			}
		});

	}
	
	
	
	
	public static void FileWriter(String title, String console, String price, String condition, String cost) throws IOException{
		File game_titles=new File("src\\Game_titles.txt");
		String game_titles_path=game_titles.getAbsolutePath();
		FileWriter fw=new FileWriter(game_titles_path, true); //writes new registered employees
		PrintWriter pw=new PrintWriter(fw, true);
		if(price.contains("$")) {
			if(cost.contains("$")) {
				String format_cost=cost.substring(1, cost.length());
				String format_price=price.substring(1, price.length());
				pw.println(title+", "+console+", "+"$"+format_price+", "+condition+", "+"$"+format_cost); //File Writing Method so I don't have to type this every time
				pw.close();
				fw.close();
			}else if(price.contains("$")) {
				String format_price=price.substring(1, price.length());
				pw.println(title+", "+console+", "+"$"+format_price+", "+condition+", "+"$"+cost); //File Writing Method so I don't have to type this every time
				pw.close();
				fw.close();
			}else if(cost.contains("$")) {
				String format_cost=cost.substring(1, cost.length());
				pw.println(title+", "+console+", "+"$"+price+", "+condition+", "+"$"+format_cost); //File Writing Method so I don't have to type this every time
				pw.close();
				fw.close();
			}
		}else{
			pw.println(title+", "+console+", "+"$"+price+", "+condition+", "+"$"+cost); //File Writing Method so I don't have to type this every time
			pw.close();
			fw.close();
		}
	}
	/**
	 * 
	 * @param user
	 * @param pass
	 * @return
	 * @throws IOException
	 */
	public static boolean FileReader_user_pass(String user, String pass) throws IOException{
		File login_info=new File("src\\User_pass.txt.txt");
		String login_info_path=login_info.getAbsolutePath();
		
		Scanner scan=new Scanner(new File(login_info_path)); //reads username and password lists
		while(scan.hasNextLine()){
			final String find_line=scan.nextLine();
			if(find_line.toLowerCase().contains(user.toLowerCase())){//checks if the word (lower case) is in any words or 
				if(find_line.toLowerCase().contains(pass.toLowerCase())){
					scan.close();
					return true;
				}
			}
		}
		scan.close();
		return false;
	}
	
	public static String FileReader_c_game_titles(String title, String console) throws IOException{ //reads list of game titles
		String list[]=new String[1000];
		int maxIndx=-1;
		File game_titles=new File("src\\Game_titles.txt");
		String game_titles_path=game_titles.getAbsolutePath();
		Scanner scan=new Scanner(new File(game_titles_path));
		while(scan.hasNextLine()){
			final String find_line=scan.nextLine();
			
			if(find_line.toLowerCase().contains(title.toLowerCase())){ //checks if the word (lower case) is in any words or 
				if(console.equals("Select Console")){
					maxIndx++;
					list[maxIndx]=find_line;
				}else if(find_line.toLowerCase().contains(console.toLowerCase())){
					maxIndx++;
					list[maxIndx]=find_line;
				}
			}
		}
		String games="";
		for(int j=0;j<=maxIndx;j++){
			int splt_cost=list[j].lastIndexOf(", ");
			games=list[j].substring(0, splt_cost)+"\n"+games;
		}
		scan.close();
		return games;
	}

}

