import java.util.*;
public class Coldwire  extends TravelAgents
{
	public Coldwire()
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
				number=(int)(-5.5*Math.log(Math.random()));
				int x=custom.binarySearchVector(customer,number,1,10);
				
				if (number==x)
					flag = false;
				
				else
					flag=true;
		}
            		return number;
	}
}

