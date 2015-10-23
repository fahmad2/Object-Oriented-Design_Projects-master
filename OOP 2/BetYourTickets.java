import java.util.*;
public class BetYourTickets extends TravelAgents  
{
	public BetYourTickets()
	{
		super();
	}
	public int getRandom() 
	{
		int number = 0;
		boolean flag=true;
        
		Customers custom=new Customers();
		Vector <Customers> customer= custom.getCustomerData();

        
			
            while (flag)
            {
				number=(int)(-22*Math.log(Math.random()));
				int x=custom.binarySearchVector(customer,number,20,24);
				
				if (number==x)
					flag = false;
				
				else
					flag=true;
            }	 
            	return number;	
	}
}

