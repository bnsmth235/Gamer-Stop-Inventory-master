/*
 * Simple UI for documenting an inventory for a fake
 * game store that can be used as an employee or just a customer
 * stores the name, price, system etc
 * 
 * @author Ben and Adam Smith
 * @version 1.0
 * @Since January 19, 2018
 * 
 * 
 * C:\\Users\\Ben Smith\\Documents\\GitHub\\Gamer-Stop-Inventory-master\\Gamer Stop Inventory\\src\\Game_titles.txt           for home computer
 * C:\\Users\\Ben Smith\\Documents\\GitHub\\Gamer-Stop-Inventory-master\\Gamer Stop Inventory\\src\\User_pass.txt.txt
 * 
 * C:\\Users\\bs034696\\Documents\\GitHub\\Gamer-Stop-Inventory-master\\Gamer Stop Inventory\\src\\Game_titles.txt         for school computer
 */

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Inventory {
	
	public static Scanner in=new Scanner(System.in);
	public static String srch_in;
	public static String return_word_and_def;
	public static JFrame frame;
	public static String home="C:\\Users\\Ben Smith\\Documents\\GitHub\\Gamer-Stop-Inventory-master\\Gamer Stop Inventory\\src\\Game_titles.txt";
	public static String home_user_pass="C:\\Users\\Ben Smith\\Documents\\GitHub\\Gamer-Stop-Inventory-master\\Gamer Stop Inventory\\src\\User_pass.txt.txt";
	public static String school="C:\\\\Users\\\\bs034696\\\\Documents\\\\GitHub\\\\Gamer-Stop-Inventory-master\\\\Gamer Stop Inventory\\\\src\\\\Game_titles.txt";
	public static String title_data[][] = new String[1000][1000];
	public static String column[]={"Title","Platform", "Price for Sale","Condition","Cost"};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		frame=new JFrame("Gamer Stop Inventory"); //UI start 
		frame.setSize(1000, 500);
		frame.setLayout(null);	
		frame.setVisible(true);
		
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
					start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //goes to the start method
			}
		});
		e.addActionListener(new ActionListener(){ //if you press the employee button
			public void actionPerformed(ActionEvent e){
				employee();
			}
		});
	}
	
	public static void employee(){
		
		frame.setVisible(false);//gets rid of old window
				
		JFrame login_frame = new JFrame("Employee Login");
		login_frame.setSize(300, 300);	
		login_frame.setLayout(null); //new window setup
		login_frame.setVisible(true);
				
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
			    
		login_frame.add(pass); login_frame.add(l1); login_frame.add(l2); login_frame.add(b); 
		login_frame.add(user); login_frame.add(r);//add all components to frame
			    
		b.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
			    String username = user.getText();  //gets input from the frame and saves into variables
			    @SuppressWarnings("deprecation")
				String password = pass.getText();
			    
			    try {
					if(FileReader_user_pass(username, password)==true){ //if the inputted username and password are in the saved list
						JLabel welcome=new JLabel("Welcome "+username); //says welcome [username]
						welcome.setBounds(75,200,100,100);
						login_frame.add(welcome);
						login_frame.setVisible(false);
						e_search_frame();
					}else{
						//you need something here to make it say that you got the username/password wrong
						JLabel incorrect=new JLabel("Username or Password Incorrect");
						incorrect.setBounds(45,200,300,50);
						login_frame.add(incorrect);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();//idk why this is here, but it doesnt work without it
				}
			 }  
		});  
			    
		r.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				login_frame.setVisible(false);
			    		
			    JFrame register=new JFrame("Register New Employee");
			    register.setSize(350,350);
			    register.setLayout(null);
			    register.setVisible(true);
			    		
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
					    
				register.add(user); register.add(pass); register.add(reg_label); register.add(l2);
			    register.add(b); register.add(l1); register.add(l3); register.add(confirm);
			    		
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
			 }
		});
	}
	
	
	public static void start() throws IOException{
		JFrame c_frame=new JFrame("Customer Inventory Search");
		c_frame.setSize(1000, 500);
		c_frame.setLayout(null);
		c_frame.setVisible(true);
		
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
		search.setBounds(100, 220, 80, 30);//enter button basically
		
		JTextArea area=new JTextArea();
		area.setBounds(300,30,600,400);
		JScrollPane scroll=new JScrollPane(area);
		area.setEditable(false);
		
		c_frame.add(area); c_frame.add(scroll); c_frame.add(c_start); c_frame.add(consoles); c_frame.add(title_label); 
		c_frame.add(title); c_frame.add(search); //add all components to the frame
		
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
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
	
	@SuppressWarnings("rawtypes")
	public static void e_search_frame() throws IOException{
		JFrame e_frame=new JFrame("Employee Inventory Search");
		e_frame.setSize(500, 500);
		e_frame.setLayout(null);
		e_frame.setVisible(true);
		
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
		e_search.setBounds(100, 220, 80, 30);//enter button basically
		
		e_frame.add(e_start); e_frame.add(e_consoles); e_frame.add(e_title_label); 
		e_frame.add(e_title); e_frame.add(e_search); //add all components to the frame
		
		//add a while statement here so that they can search multiple times
		
		e_search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent b){
				
				
				String game_title=e_title.getText(); //puts searched title into the variable       
			    String data=(String) e_consoles.getItemAt(e_consoles.getSelectedIndex());  //gets which console they chose and saves it into an object
			    
			    try {
			    	String list[]=new String[1000];
			    	int maxIndx=-1;
			    	Scanner scan=new Scanner(new File(home));

			    	while(scan.hasNextLine()){
			    		String find_line=scan.nextLine();
			    		if(find_line.toLowerCase().contains(game_title.toLowerCase())){ //checks if the word (lower case) is in any words or 
			    			if(find_line.toLowerCase().contains(data.toLowerCase())){
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
				    			
				    			title_data[j][x]=split_read_data[a];
				    			x++;
				    		}
				    	}
			    	}
			    	scan.close();
			    	
			    } 
			    catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			    }
			}
		});
		e_inventory_search_frame();
	}
	
	public static void e_inventory_search_frame() {
		JFrame e_inventory_list=new JFrame("Searched Inventory");
		e_inventory_list.setSize(600, 400);
		e_inventory_list.setVisible(true);
		e_inventory_list.setLayout(null);
		e_inventory_list.setLocation(600, 0);
		
		JTable area=new JTable(title_data,column);
		area.setBounds(0,0,600,400);
		
		JScrollPane scroll=new JScrollPane(area);
		
		e_inventory_list.add(area);e_inventory_list.add(scroll);
	}
	
	public static void FileWriter(String word_and_def) throws IOException{
		
		FileWriter fw=new FileWriter(home, true); //writes new registered employees
		PrintWriter pw=new PrintWriter(fw, true);
		pw.println(word_and_def); //File Writing Method so I don't have to type this every time
		pw.close();
		fw.close();
		
	}
	
	public static boolean FileReader_user_pass(String user, String pass) throws IOException{
		Scanner scan=new Scanner(new File(home_user_pass)); //reads username and password lists
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
		Scanner scan=new Scanner(new File(home));

		while(scan.hasNextLine()){
			final String find_line=scan.nextLine();
			
			if(find_line.toLowerCase().contains(title.toLowerCase())){ //checks if the word (lower case) is in any words or 
				if(find_line.toLowerCase().contains(console.toLowerCase())){
					maxIndx++;
					list[maxIndx]=find_line;
				}//hello
		
			}
			System.out.println();
		}
		String games="";
		for(int j=0;j<=maxIndx;j++){
			System.out.println(list[j]);
			int splt_cost=list[j].lastIndexOf(", ");
			System.out.println(splt_cost);
			games=list[j].substring(0, splt_cost)+"\n"+games;
		}
		scan.close();
		return games;
	}

}

