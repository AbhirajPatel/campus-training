
public class working {
 
	public interFace intanses(String s)
	{
	if("facebook".equals(s))
		return new facebook();
	else if("google".equals(s))
		return new google();
	else if("linkedin".equals(s))
		return new linkedin();
	else
		return new error();
	
	}
	
	
}
