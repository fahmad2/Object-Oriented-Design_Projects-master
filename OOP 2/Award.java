import java.lang.*;
public class Award extends Customers
{
	double dollarAmount = 0;
	String agency = "";
	String boughtTicket="";
	int A = 0;
	int B = 0;
	int C = 0;
	int D = 0;
	int E = 0;


	public String decideAgency()
	{
		int number = (int)(1+Math.random()*(5));
		if ((number == 1)&&(A < 2))
		{
			A++;
			agency = "EXPEDIAR";
		}
		if ((number == 2)&&(B < 2))
		{
			B++;
			agency = "COLDWIRE";
		}

		if ((number == 3)&&(C < 2))
		{
			C++;
			agency = "GETYOURTICKETS";
		}

		if ((number == 4)&&(D< 2 ))
		{
			D++;
			agency = "BETYOURTICKETS";
		}

		if ((number == 5)&&(E < 2))
		{
			E++;
			agency = "CHEAPTICKETS";
		}
		return agency;
	}

	public int milesAwarded()
	{
		 miles = (int)(1000+Math.random()*(35000));
		 return miles;
	}

	public double Converter(int mil)
	{
		dollars = mil*0.06;
		return dollars;
	}


	
	public String ticketResult(double tR)
	{
		if ( tR<300)
		{
			finalDestination = "Travel to Nowhere";
			return finalDestination;
		}
		else if ( tR>=300 &&  tR<600)
		{
			finalDestination = "Travel within the Continental US";
			return finalDestination;
		}
		else if ( tR>=600 &&  tR<1000)
		{
			finalDestination = "Travel To Mexico OR within the Continental US";
			return finalDestination;
		}
		else if (tR>=1000 && tR<1500)
		{
			finalDestination= "Travel to Europe, Mexico OR within the Continental US";
			return finalDestination;
		}
		else
			finalDestination = "Travel to Asia, Europe, Mexico OR within the Continental US";
			return finalDestination;
	} 
	

}
