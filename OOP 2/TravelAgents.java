public abstract class TravelAgents 
{
	AgencyType agencyType;

	public TravelAgents()
	{
	}

	public AgencyType getAgencyType()
	{
		return agencyType;
	}
	public void setAt(AgencyType aT)
	{
		this.agencyType = aT;
	}
 
	public abstract int getRandom();
 
}
