import java.util.*;
public class GetYourTickets extends TravelAgents
{
	public GetYourTickets ()
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
				number=(int)(rg.nextGaussian()*1.0+10.0);

				int x=custom.binarySearchVector(customer,number,1,19);
				
				if (number==x)
					flag = false;
				else
					flag=true;
	    }
            		return number;
      	}
	
}
