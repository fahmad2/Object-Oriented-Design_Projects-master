import java.util.*;
public class CheapTickets extends TravelAgents  
{
	public CheapTickets()
	{
		super();
	}
	
	public int getRandom()
	{
		int number = 0;
		boolean flag=true;
        
		Customers custom=new Customers();
		Vector <Customers> customer= custom.getCustomerData();
		Random rg=new Random();
		

            while (flag)
            {
				number=(int)((rg.nextGaussian()*1.0)+40.5);
				int x=custom.binarySearchVector(customer,number,0,45);
				
				if (number==x)
					flag = false;
				
				else
					flag=true;

            }

      return number;
	}
}




