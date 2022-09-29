package notationgroup.abuabararicardo_assignment2.notation;

public class StackOverflowException extends QueueException{
	public StackOverflowException() {
		System.out.print("There is a stack overflow! You called a push method on a full stack" 
				+ "");
	}
	
	public StackOverflowException(String Exceptionmsg) {
		super(Exceptionmsg);
	
}
}
