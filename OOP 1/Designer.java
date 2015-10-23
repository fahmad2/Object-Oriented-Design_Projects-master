//Taha Monasar 
public class Designer
{
	private String lastName;
	private String firstName;
	private int age;
	private double salary;
	private char status;
	private String favoriteTv;
	private int season;
	final int maxAge = 75;
	final int minAge = 16;
 
 public Designer()
 {
	 lastName = "Doe";
	 firstName= "Jon";
	 age = 24;
	 salary = 850000;
	 status = 'a';
	 favoriteTv = "soccer";
	 season = 1;
 }
 // accessor methods
 public String getLastName()
 {
	return lastName;
 }
 public String getFirstName()
 {
	return firstName;
 }
 
 public int getAge()
 {
	return age;
 }
 public double getSalary()
 {
	return salary;
 }
 public char getStatus()
 {
	return status;
 }
 public String getFavoritetv()
 {
	return favoriteTv;
 }
 public int getSeason()
 {
 return season;
 } 
 public void setSeason(int s)
 {
 season = s;
 }
 
 

 //mutator methods
 
 public void setLastName(String ln)
 {
	lastName = ln;
 }
 
 public void setFirstName(String fn)
 {
	firstName=fn;
 }
 public void setAge(int a)
 {
	 if ( age >= minAge ){
		 // minimum age is 16 
		 age =a;
		 return;
	 
	 }
	System.out.println(" age is invalid");
 }
 
 public void setSalary(double s)
 {
	if ( salary > 0 && salary < 1000000)
		{
		salary =s;
		return;
		}
}

public void setStatus(char b)
{
if ( status == 'a' || status == 'p')
status = b;
}

public void setFavoritetv( String F)
{
	favoriteTv = F;
}

public void display()
{
	System.out.println (toString());
}

public String toString()
{
	String irt= "The designer's is name is "+getFirstName()+" "+getLastName() +" age is "+getAge() +
	" salary is "+getSalary()+" Status is "+getStatus()+" Favorite TV show is "+getFavoritetv();
	return irt;
}	



public boolean equals(Designer d )
{
	return (d.getLastName().equals(this.getLastName()) 
		&& d.getFirstName().equals(this.getFirstName())
		&& d.getAge()== this.getAge() 
		&& d.getSalary()==this.getSalary() 
		&& d.getStatus()== this.getStatus() 
		&& d.getFavoritetv().equals(this.getFavoritetv()));
}

public double potentialEarnings(){
	double earnings = ((maxAge - age)*412000) + ((age - minAge) * salary);
	
	return Math.max(earnings, 10000000);
}
}
 
 
 
 
 