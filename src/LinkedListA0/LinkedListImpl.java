/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedListA0;

public class LinkedListImpl implements LIST_Interface {
	Node root;// this will be the entry point to your linked list (the head)
	
	// Create a secondary tail to keep track of the end of the linked list
	Node tail;
	
	// Size of the LinkedList
	private int size;

	public LinkedListImpl() {// this constructor is needed for testing purposes. Please don't modify!
		// Setup the root and tail and connect to each other
		root = new Node(0); 
		tail = new Node(0);
		
		root.next = tail;
		tail.prev = root;
		
		// Setup the empty size of the list
		this.size = 0;
	}

	// implement all methods in interface, and include the getRoot method we
	// made for testing purposes. Feel free to implement private helper methods!

	public Node getRoot() { 
		// Utility method required by default
		return root;
	}

	@Override
	public boolean insert(Node n, int index) {
		// Check simple edge cases
		if (index < 0 || index > this.size)
			return false;
		
		// Iterate through to the address
		int i = 0;
		Node temp = root;
		while (i < index) {
			temp = temp.next;
			i++;
		}
		
		// Upon reaching the address, insert the Node, and redo linkages
		n.prev = temp;
		temp.next.prev = n;
		n.next = temp.next;
		temp.next = n;
		
		// Increase size
		this.size++;
		
		// Return indication of successful operation
		return true;
	}

	@Override
	public boolean remove(int index) {
		// Check simple edge cases
		if (index < 0 || index > this.size)
			return false;
		
		// Iterate through to the address
		int i = 0;
		Node temp = root;
		while (i <= index) {
			temp = temp.next;
			i++;
		}
		
		// Upon reaching the address, remove the Node and fix linkages
		temp.next.prev = temp.prev;
		temp.prev.next = temp.next;
		
		// Decrease size
		this.size--;
		
		// Return indication of successful operation
		return true;
	}

	@Override
	public Node get(int index) {
		// Check if the index exists
		if (index < 0 || index > this.size)
			return null;
		
		
		int i = 0;
		Node temp = root;
		while (i <= index) {
			temp = temp.next;
			i++;
		}
		
		// Return successfully fetched object
		return temp;
	}

	@Override
	public int size() {
		// Return automatically tracked size
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public void clear() {
		// Connect the head solely to the tail
		root.next = this.tail;
		this.tail.prev = this.root;

		// Reset the size
		this.size = 0;
	}
}