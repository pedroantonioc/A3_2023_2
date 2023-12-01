package util;

public class Lista {

	private Node head;
	
	//método para adicionar elemento na lista
	public void add(String pessoa) {
		Node node = new Node();
		node.setPessoa(pessoa);
		
		node.setNext(head);
		head = node;
	}
	
	//imprimir lista
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("[");
		Node p = head;
		while (p!= null) {
			sb.append(p.getPessoa() + " ");
			p = p.getNext();
		}
		sb.append("]");
		return sb.toString();
	}
	

	
	
}

