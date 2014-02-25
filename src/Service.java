import java.util.LinkedList;

/*
 * Assumptions:
 * 1. For time being I have Assumed Messages to be String
 * 2. We can use generics to make it more scalable and we can support more 
 *    services in the future. because of time constraints I didn't do that.
 *    
 */

public class Service {
	/*
	 * enqueue will put message into a message queue associated with url's host. 
	 * The method should return -1 if queue associated the URL cannot never send
	 * Otherwise, the method should return queue length associated with the URL's host.
	 * 
	 */
	public  int enqueue(String message, final String url){

		//Error checking
		if(message == null || url == null || message.length() == 0 || url.length()==0){
			return  - 1;
		}

		//Based on the URL get Queue and add the element in the Queue
		LinkedList<String> q = this.getValidQueue(url);

		if(q != null){
			q.add(url);
			return q.size();
		}

		return -1;
	}

	/*
	 *     This method removes the first occurrence of message from the message 
	 *     queue associated with the url's host if we can find
	 *     the message.
	 */
	public void remove(String message, final String url){


		//Error checking
		if(message == null || url == null || message.length() == 0 || url.length()==0){
			return  ;
		}

		//Based on the URL get Queue and remove first occurance of message in the Queue, if exist
		LinkedList<String> q = this.getValidQueue(url);
		if(q != null){
			q.remove(message);
		}
	}

	/*
	 * Internal method to get Valid Queue
	 * input the string url
	 * output required Queue
	 */
	public LinkedList<String> getValidQueue(String url){
		//Error checking
		if( url == null || url.length()==0){
			return null;
		}

		//Based on the URL get Queue and add the element in the Queue
		LinkedList<String> q = Queue.getInstance().getQueue(url);
		return q;
	}

	/*
	 *     It sends a message from one of the queues. 
	 *     Which queue to process first depends on the number of
	 *	   messages in the queue and successful rate. 
	 */
	public void send(){
		//Steps to implement
		// 1. Get sizes of all queues
		// 2. Get status of each hosts
		//	  If host is up then and then only send messages from that Queue
		// not yet implemented
	}

}
