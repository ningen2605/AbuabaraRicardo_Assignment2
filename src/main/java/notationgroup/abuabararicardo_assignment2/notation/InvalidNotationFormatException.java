package notationgroup.abuabararicardo_assignment2.notation;

public class InvalidNotationFormatException  extends QueueException{
	public InvalidNotationFormatException() {
		System.out.print("There is an Invalid Notation Format!" 
				+ "");
	}
	
	public InvalidNotationFormatException(String Exceptionmsg) {
		super(Exceptionmsg);
	}

}
