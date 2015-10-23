import java.util.*;
import java.lang.*;
public class Expediar extends TravelAgents
{
	int lotNum;
	int count = 0;
	boolean flag = true;
	int expRand[] = new int[4];

	public Expediar()
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
				number=(int)(1+Math.random()*(45));
				
				int x=custom.binarySearchVector(customer,number,1,45);
				
				if (number==x)
					flag = false;
				else
					flag=true;
		 }
            		return number;
	}
}
			