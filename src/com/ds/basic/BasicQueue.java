package com.ds.basic;

public class BasicQueue<X> {
	private X[] data;
	private int front;
	private int end;
	
	public BasicQueue() {
		this(1000);
	}
	
	public BasicQueue(int size) {
		data = (X[])new Object[size];
		this.front = -1;
		this.end = -1;
	}
	
	public int size() {
		// if the queue is empty, return 0
		if(front == -1 && end == -1) {
			return 0;
		}
		return end - front + 1;
	}
	
	public void enQueue(X newItem) {
		// first check the queue is full
		if( (end+1) % data.length == front) {
			throw new IllegalStateException("The Queue is full");
		}
		// otherwise check to see if any items have been added to the queue yet
		else if(size() == 0) {
			front ++;
			end ++;
			data[end] = newItem;
		}
		// otherwise add the item to the end of the queue
		else {
			end ++;
			data[end] = newItem;
		}
	}
	
	public X deQueue() {
		X item = null;
		
		// if the queue is empty we can't deQueue anything
		if(size() == 0) {
			throw new IllegalStateException("Can't deque because the queue is empty");
		}
		
		// otherwise if this is the last item on the queue, the queue needs to get reset to empty
		else if(front == end) {
			item = data[front];
			data[front] = null;  	// free up space after grabbing the element
			front = -1;
			end = -1;
		}
		
		// otherwise grab the front of the queue, return it and adjust the pointer
		else {
			item = data[front];
			data[front] = null;  	// free up space after grabbing the element
			front ++;
		}
		
		return item;
	}
	
	public boolean contains(X item) {
		boolean found = false;
		
		// if thye queue is empty, just immediately returns false
		if(size() == 0) {
			return found;
		}
		
		for( int i = front; i < end; i++) {
			if(data[i].equals(item)) {
				found = true;
				break;
			}
		}
		
		return found;
	}
	
	public X access(int position) {
		
		if(size() == 0 || position > size()) {
			throw new IllegalArgumentException("No items in the queue or the position is greater than the one which the queue holds");
		}
		
		int trueIndex = 0;  // Since the front is not always fixed to 0, it's moves ups down
		for( int i = front; i < end; i++) {
			if(trueIndex == position) {
				return data[i];
			}
			trueIndex++;
		}
		// if we didn't find the item throw an exception
		throw new IllegalArgumentException("Couldn't get queue item at position: "+position);
		
	}
	
	
}
