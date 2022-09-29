package notationgroup.abuabararicardo_assignment2.notation;

public class QueueUnderflowException extends QueueException {
	public QueueUnderflowException() {
		System.out.print("There is a queue underflow! You called a dequeue method on an empty queue."
				+ "");
	}
	
	public QueueUnderflowException(String Exceptionmsg) {
		super(Exceptionmsg);
	}
}
