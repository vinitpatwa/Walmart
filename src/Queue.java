import java.util.LinkedList;

/*
 * Singleton class for Queue
 * It will host list of Queues
 * It will return appropriate queue based on url 
 */
public class Queue {

	private static boolean hasObject = false;
	private static Queue queueObject = null;

	String beacon = "https://www.walmart.com/beacon";
	String log =  "https://www.walmart.com/log";
	String checkout = "https://checkout.walmart.com/";
	String walmart = "https://www.walmart.com/";

	LinkedList<String> q_walmart=new LinkedList<String>();
	LinkedList<String> q_beacon=new LinkedList<String>();
	LinkedList<String> q_checkout=new LinkedList<String>();

	public synchronized static Queue getInstance() {
		if (hasObject) {
			return queueObject;
		} else {
			hasObject = true;
			queueObject = new Queue();
			return queueObject;
		}
	}

	private Queue() {
		// Initialize your object.
	}

	/*
	 * Based on the url it will send appropriate Queue
	 * if url is not supported, then it will return null
	 */
	public LinkedList<String> getQueue(String url) {

		if(url.equals(beacon) || url.equals(log)){
			return q_walmart;
		}else if (url.equals(checkout)) {
			return q_checkout;
		}else if (url.equals(walmart) ){
			return q_beacon;
		}
		//wrong url
		return null;
	}
}
