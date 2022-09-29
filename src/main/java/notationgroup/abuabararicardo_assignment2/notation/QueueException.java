package notationgroup.abuabararicardo_assignment2.notation;

public class QueueException extends Exception {


		public QueueException() {
			System.out.print("There was an error with the queue!!!");
		}
		public QueueException(String exceptionMsg) {
			super(exceptionMsg);
		}
		
	}

