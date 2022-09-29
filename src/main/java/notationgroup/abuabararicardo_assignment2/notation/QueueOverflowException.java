package notationgroup.abuabararicardo_assignment2.notation;

public class QueueOverflowException extends QueueException{
	
	public QueueOverflowException() {
		System.out.print("There is a queue overflow! You called a push method on a full queue" 
				+ "");
	}
	
	public QueueOverflowException(String Exceptionmsg) {
		super(Exceptionmsg);
	}
}

