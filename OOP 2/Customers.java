import java.util.*;
import java.io.*;
public class Customers implements Serializable  
{
	AgencyType agencyType;
	TravelAgencyType tAt;
	String firstName = "";
	String lastName = "";
	String customerType = "";
	int lotteryNumber = 0;
	int miles = 0;
	double dollars = 0;
	public static int customerID=0;
	int currentID=0;
	String finalDestination = "";
	Vector Customers = new Vector(); 
	
	public Customers()
	{
	}
	public Customers(String fName, String lName, String ctype, int num)
	{
		firstName = fName;
		lastName = lName;
		customerType = ctype;
		lotteryNumber= num;
		customerID++;
		currentID=customerID;
	}

	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getCustomerType()
	{
		return customerType;
	}
	public AgencyType getAgencyType()
	{
		return agencyType;
	}
	public TravelAgencyType getTravelAgencyType()
	{
		return tAt;
	}
	public int getMiles()
	{
		return miles;
	}
	public double getDollars()
	{
		return dollars;
	}
	public String getDestination()
	{
		Award award=new Award();
		finalDestination=award.ticketResult(award.Converter(miles));
		return finalDestination;
	}
	public int getLotteryNumber()
	{
		return lotteryNumber;
	}
	public int getCurrentID()
	{
		return currentID;
	}
	
	public void setDestination(String destination)
	{
		finalDestination = destination;
	}
	public void setMiles(int mi)
	{
		miles = mi;
	}
	public void setDollars(double dol)
	{
		dollars = dol;
	}
	public void setAgencyType(AgencyType aT)
	{
		this.agencyType = aT;
	}
	public void setTravelAgencyType(TravelAgencyType tAT)
	{
		this.tAt= tAT;
	}
	
	public String toString()
	{	
		String str= "Agency Type: \t "+agencyType+"\tFirst Name: "+firstName+"\tLast Name: "+lastName+"   \tCustomer Type: "+customerType+"\tPerson ID: "+lotteryNumber+"\tLottery Number: "+lotteryNumber+"  \t \t\t Travel Agency Type:  " + "\tMiles Earned: "+miles+" \tDollar Amount: "+dollars ;
			return str;
	}

	public Vector getCustomerData()
	{
		try
		{
			File ifile = new File("Customers.txt");
			Scanner scan = new Scanner(ifile);
			while (scan.hasNextLine())
			{
				String line = scan.nextLine();
				StringTokenizer st = new StringTokenizer(line,",");
				String tok1 = st.nextToken();
				String tok2 = st.nextToken();
				String tok3 = st.nextToken();
				String tok4 = st.nextToken();
				int lotteryNum = Integer.parseInt(tok4);
				String tok5 = st.nextToken();

				Customers customer= new Customers (tok1,tok2,tok3,lotteryNum);
				
				if (tok5.equals("EXPEDIAR"))
					{
						customer.setAgencyType(AgencyType.EXPEDIAR);
						Customers.add(customer);
					}
				else if (tok5.equals("GETYOURTICKETS"))
					{
						customer.setAgencyType(AgencyType.GETYOURTICKETS);
						Customers.add(customer);
					}
				else if (tok5.equals("BETYOURTICKETS"))
					{
						customer.setAgencyType(AgencyType.BETYOURTICKETS);
						Customers.add(customer);
					}
				else if (tok5.equals("COLDWIRE"))
					{
						customer.setAgencyType(AgencyType.COLDWIRE);
						Customers.add(customer);
					}
				else if (tok5.equals("CHEAPTICKETS"))
					{
						customer.setAgencyType(AgencyType.CHEAPTICKETS);
						Customers.add(customer);
					}			
			}
		}
		catch (IOException ioe)
		{
			System.out.println(ioe.toString());
		}
		return Customers;
	}
	public int binarySearchVector(Vector<Customers> custom, int key, int start , int end)
	{
		if ( start <= end )
		{
			int middle = ( start + end ) / 2;  
			
			if ( custom.elementAt(middle).getLotteryNumber() == key ) 
				return custom.elementAt(middle).getLotteryNumber();   
			
			else if ( custom.elementAt(middle).getLotteryNumber()> key ) 
				return binarySearchVector(custom, key, start, middle-1);  
				
			else				     
				return binarySearchVector(custom, key, middle+1, end );
		}
		else	
   			return -1;  

		}
}
