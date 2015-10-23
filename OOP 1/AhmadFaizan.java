import java.util.*;
import java.io.*;
public class AhmadFaizan
{



public static void main (String []args)throws IOException
{

File ifile = new File ("runwayscs115");
Scanner scan = new Scanner (ifile);
String season = scan.nextLine();
int [] counter = new int[7];
ArrayList<Designer> designers = new ArrayList<Designer>(); // used to store designer objects (used in place of arrays for extra credit)
ArrayList<Integer> seasons = new ArrayList<Integer>();
ArrayList<Integer> designersPerSeason = new ArrayList<Integer>();

while (!season.equals("ENDOFFILE"))
{	
	Scanner seascan = new Scanner(season);
	String ss = seascan.next();
	int seasNum = seascan.nextInt();
	//ss = seascan.nextLine();
	seasons.add(seasNum);
	
	
	season = scan.nextLine();
	Scanner scn = new Scanner(season);
	int number = scn.nextInt();
	designersPerSeason.add(number);
	 
	for (int i=0; i < number;i++) 
	{		
		Designer D = new Designer();
		
		D.setSeason(seasNum);
		
		String sline = scan.nextLine();
		Scanner sc = new Scanner(sline);

		String lname = sc.next();
		D.setLastName(lname);
		String fname = sc.next();
		D.setFirstName(fname);
		int ag = sc.nextInt();
		D.setAge(ag);
		double sa = sc.nextDouble();
		D.setSalary(sa);
		String st = sc.next();
		char c = st.charAt(0);
		D.setStatus(c);
		String ftv = sc.nextLine();
		D.setFavoritetv(ftv);
		
		designers.add(D);
	}

	season = scan.nextLine();			
}

boolean run = true;

while(run)
{
	System.out.print("what would U like to do next :");
	Scanner scn = new Scanner(System.in);
	String input1 = scn.next();
	char input2 = input1.charAt(0);
	switch(input2)
	{
	case 'm':	
	case 'M':
		//System.out.println("Does it work?");
		menu(designers, seasons, designersPerSeason, counter);
		break;

	case 'q':
	case 'Q':
		//System.out.println("Does it work?");
		finalStats(counter);
		System.exit(0);
		break;

	default:
	System.out.println(" error please try again");
	//input1 = scan.next();
	}
}
}

public static void menu(ArrayList<Designer> designers , ArrayList<Integer> seasons, ArrayList<Integer> designersPerSeason, int[] counter)
{

boolean run = true;

while(run)
{
	Scanner scn = new Scanner (System.in);
	System.out.println("What would you like to do?");
	System.out.println("Enter [L or l] - list All; [D or d] - Designer Report; [S or s] - Season Report;"+
						"[M or m] - Salary Report;[T or t] - Status Report;[Q or q] - returns to Main Menu;");
	
	String input3 = scn.next();
	char input4 = input3.charAt(0);
	switch(input4)
	{
	case 'l': 
	case 'L':
	listall(designers, designersPerSeason);
	counter[0]++;
	//run = false;
	
	break;
	
	case 'd':
	case 'D':
	designerReport(designers);
		counter[1]++;

	//run = false;

	break;
	
	case 's':
	case 'S':

	seasonReport(designers, seasons, designersPerSeason);
		counter[2]++;

		//run = false;

	break;
	
	case 'm':
	case 'M':
	salaryReport(designers);
		counter[3]++;

		//run = false;

	break;
	
	case 't':
	case 'T':
	//statusReport();
		counter[4]++;

		run = false;

	break;
	
	case 'q':
	case 'Q':
	//main();
		counter[5]++;

		run = false;

	break;
	
	case 'o':
	case 'O':
	sortList(designers);
		counter[5]++;

		run = false;

	break;
	
	default:
	System.out.println("error please try again");
	counter[6]++;
	break;
	
	}
	}
	}
	

	
	public static void  listall(ArrayList<Designer> designers, ArrayList<Integer> designersPerSeason) // passing the value from menu  
	{
	int i = 0; //I did this way because I didn't do the season.get from the beginning.this code give us the seasons.
	int k = 0;
	for(int j=0; j<designersPerSeason.size();j++)
	{		
		for (i = 0; i< designersPerSeason.get(j); i++)
		{	
		designers.get(i+k).display();
		System.out.print("   [Designer from Season "+(j+1)+"]\n");
		}
		k += designersPerSeason.get(j);
	}
	}
					
	public static boolean designerReport(ArrayList<Designer> designers) //  we have to search for user by entering last name
	{
	System.out.print(" please enter user last Name :");
	Scanner scan= new Scanner (System.in);
	String t= scan.next();
	boolean flagger = false;
	for (int i=0; i<designers.size();i++)
	{
		if (designers.get(i).getLastName().equals(t))
		{
			System.out.println("Season "+designers.get(i).getSeason()+" designer; Designer's name: "
			+designers.get(i).getFirstName()+" "+designers.get(i).getLastName()+" and favorite tv show is "
			+designers.get(i).getFavoritetv());
			flagger=true;
		}	
			
	}
	if(!flagger) 
		System.out.println(" no designer found");
	return flagger;	
	}
	
		// this method suppose to give us a summary  information for each season in terms of designers 
		// and their profile.
	public static boolean seasonReport(ArrayList<Designer> designers , ArrayList<Integer> seasons, ArrayList<Integer> designersPerSeason) //  seasonReport() method 
	{
	boolean tseas = false;
	Scanner scan = new Scanner (System.in);
	System.out.print("enter a season you would like to search [enter a season number or, all]");
	String input0= scan.next();
	
	if (input0.equals("all"))    // if they wanna search for all
	{
	for (int i =0; i <seasons.size(); i++)
	{
		double avgsalary = 0; // initialization  
		double tsalary = 0;
		int counter = 0;
		System.out.println("Season "+seasons.get(i));
		for (int j =0; j < designers.size(); j++)
		{
			if(designers.get(j).getSeason() == seasons.get(i))
			{
			System.out.println("Designer's name :"+designers.get(j).getLastName()+
			"  "+designers.get(j).getFirstName()+"; age "+designers.get(j).getAge()+" and salary is "+designers.get(j).getSalary());
			
			tsalary += designers.get(j).getSalary(); // suming up designer salaries for the season
			counter++;		// counting number of designers in each season	
			}			
		}
		
		avgsalary = tsalary/counter; // calculating average salary
		System.out.println("total salary for season "+(i+1)+" is "+tsalary);  
		System.out.println("average salary for season "+(i+1)+" is "+avgsalary);
	}
	}
	// checking if the user input is equal to any of the seasons in the seasons arrays
	else {
	
		int ss = Integer.parseInt(input0);  //parsing string to int
		for(int k = 0; k <seasons.size(); k++)  
		{
			if(ss == seasons.get(k)) 
			{
			double avgsalary = 0;
			double tsalary = 0;
			int counter = 0;
			System.out.println("Season "+ss);
			for (int j =0; j < designers.size(); j++)
			{
				if(designers.get(j).getSeason() == ss)
				{
				System.out.println("Designer's name :"+designers.get(j).getLastName()+
				"  "+designers.get(j).getFirstName()+"; age "+designers.get(j).getAge()+" and salary is "+designers.get(j).getSalary());
				
				tsalary += designers.get(j).getSalary();
				counter++;			
				}			
			}
			avgsalary = tsalary/counter; //calculating
			System.out.println("total salary for season "+ss+" is "+tsalary);
			System.out.println("average salary for season "+ss+" is "+avgsalary);
			tseas = true;
			}
		}
	}
	if(!tseas) 
	{
	System.out.println("No season found");
	return false;
	}
			
	return true;
	}
	
	public static boolean salaryReport(ArrayList<Designer> designers)

	{
	Scanner scan = new Scanner (System.in);
	System.out.println ( " please enter Designer last name u want to search for [or , all]");
	String input5 = scan.next();
	boolean tmsalary = false;
	
	if (input5.equals ("all"))
	{
		for (int i =0; i<designers.size(); i++)	
		{
		System.out.println("Designer's name :"+designers.get(i).getLastName()+
				"  "+designers.get(i).getFirstName()+" and salary is "+designers.get(i).getSalary());
			tmsalary = true;
		}
	}
	else 
	{//parsing string to int
		for(int k = 0; k <designers.size(); k++)
		{
			if(input5.equals(designers.get(k).getLastName())) 
			{
			System.out.println("Designer's name :"+designers.get(k).getLastName()+
				"  "+designers.get(k).getFirstName()+" and salary is "+designers.get(k).getSalary());
			tmsalary = true;					
			}
		}
	}
	if(!tmsalary) 
	{
	System.out.println("No designer found");
	return false;
	}
	return tmsalary;
}
	
	public static boolean statusReport(ArrayList<Designer> designers)
	{
	 boolean tstatic= true;
	Scanner scan = new Scanner (System.in);
	System.out.print("what would u like to search for(a , p) Or the word all");
	String input6 = scan.next();
	
	
	if (input6.equals("all"))    // if they wanna search for all
	{
		for (int i =0; i < designers.size(); i++)
		{
			Designer d = designers.get(i);
			if(d.getStatus() == 'a' ){
				
				System.out.println("Designer's name :"+d.getLastName()+
				"  "+d.getFirstName() + " CURRENTALY AMATURE");
				tstatic = true;	
			}
		}
		for (int i =0; i < designers.size(); i++)
		{
			Designer d = designers.get(i);
			if (d.getStatus() == 'p'){
			
			System.out.println("Designer's name :"+d.getLastName()+
				"  "+d.getFirstName() +" " + d.getAge() + " " + d.getSalary() + " " + d.potentialEarnings());
			tstatic = true;	
			}
		}
	}
	else if( input6.charAt(0) == 'a') {
		for (int i =0; i < designers.size(); i++)
		{
			Designer d = designers.get(i);
			if(d.getStatus() == 'a' ){
				
				System.out.println("Designer's name :"+d.getLastName()+
				"  "+d.getFirstName() + " CURRENTALY AMATURE");
				tstatic = true;	
			}
		}
	}
	else if(input6.charAt(0) == 'p')
	{
		for (int i =0; i < designers.size(); i++)
		{
			Designer d = designers.get(i);
			if (d.getStatus() == 'p'){
			
			System.out.println("Designer's name :"+d.getLastName()+
				"  "+d.getFirstName() +" " + d.getAge() + " " + d.getSalary() + " " + d.potentialEarnings());
			tstatic = true;	
			}
		}
	}
	if(!tstatic)
		System.out.println("No status found.");
	return tstatic;
	}
	
	public static void finalStats(int[] counter)
	{
	System.out.println( "the numner of L's entered is "+counter[0]);
	System.out.println( "the numner of D's entered is "+counter[1]);
	System.out.println( "the numner of S's entered is "+counter[2]);
	System.out.println( "the numner of M's entered is "+counter[3]);
	System.out.println( "the numner of T's entered is "+counter[4]);
	System.out.println( "the numner of Q's entered is "+counter[5]);
	System.out.println( "the numner of others entered is "+counter[6]);
	return;
	} 
	
	// this the extra credit part 

	public static void sortList(ArrayList<Designer> D)
	{
	
	ArrayList<Designer> Temp = new ArrayList<Designer>();
	
	String [] lname = new String[D.size()];
	String [] fname = new String[D.size()];
	
	
	for(int i = 0; i < D.size(); i++) {
		lname[i] = D.get(i).getLastName();
	}
	Arrays.sort(lname);
	for(int j = 0;j<lname.length;j++)
	System.out.println(lname[j]);		
	for(int j = 0; j < lname.length; j++) {
	    for(int k =0; k< D.size(); k++) {
		if(lname[j].equals(D.get(k).getLastName())) {Temp.add(D.get(k));
		D.remove(k);}
		}
	}
	
	System.out.println(Temp.get(15).getFirstName());
	for(int l = 0;l < D.size(); l++)
	{
		while(Temp.get(l).getLastName().equals(Temp.get(l+1).getLastName()))
		{
			if((Temp.get(l).getFirstName().compareTo(Temp.get(l+1).getFirstName())) < 0)
			{
				Designer Tmp = Temp.get(l);
				//Temp.remove(l);
				Temp.set(l,Temp.get(l+1));
				//Temp.remove(l+1);
				Temp.set(l+1,Tmp);
			}
			l++;
		}
	}
	
	for(int m =0; m < Temp.size(); m++) Temp.get(m).display();
	return;
	} 
}
	//end of class
	
	