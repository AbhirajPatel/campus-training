import java.util.Scanner;


public class login_mode {
	public static void main(String[] args)
	{
		System.out.println("login with,facebook,google,linkdin");
	    String s;
	    Scanner scn=new Scanner(System.in);
	    s=scn.next();
	    working wk=new working();
	    interFace obj=wk.intanses(s);
	    obj.spec();
	    
	}

}
