package notationgroup.abuabararicardo_assignment2.notation;

public class StackUnderflowException extends QueueException{
	public StackUnderflowException() {
		System.out.print("There is a stack underflow! You called a dequeue method on a empty stack" + "");
	}
	
	public StackUnderflowException(String Exceptionmsg) {
		super(Exceptionmsg);
}
}