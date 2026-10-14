package estruturasdedados;

public class Fila {
	private int[] queue;
	private int head;
	private int tail;
	private int size;
	
    // sua fila deve seguir a abordagem circular que vimos em sala de aula.
    // isso implica em dizer quer adições e remoções são O(1).
    public Fila(int capacidade) {
        this.queue = new int[capacidade];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == -1 && this.tail == -1;
    }

    public boolean isFull() {
        return ((this.tail + 1) % this.queue.length) == (this.head % this.queue.length);
    }

    // deve lançar exceção caso a fila esteja cheia.
    public void addLast(int valor) {
        if (isFull()) throw new RuntimeException("A fila está cheia");
        
        if (isEmpty()) {
        	this.head = (this.head + 1) % this.queue.length;
        }
        
        this.tail = (this.tail + 1) % this.queue.length;
        this.queue[this.tail] = valor;
        this.size++;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
    	if (isEmpty()) throw new RuntimeException("A fila está vazia");
    
    	int val = this.queue[this.head];
    	
    	if(this.head == this.tail) {
    		this.head = -1;
    		this.tail = -1;
    	}else {
    		this.head = (this.head + 1) % this.queue.length;
    	}
    	
    	this.size--;
        return val;
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o primeiro da fila, sem
    // remover;
    public int getFirst() {
    	if (isEmpty()) throw new RuntimeException("A fila está vazia!");
    	
        return this.queue[this.head];
    }

    // deve lançar exceção caso a fila esteja vazia. apenas retorna o último da fila, sem
    // remover;
    public int getLast() {
    	if (isEmpty()) throw new RuntimeException("A fila está vazia!");
    	
        return this.queue[this.tail];
    }

    // deve retornar uma string representando a fila. 
    public String toString() {
        Fila fi = new Fila(this.queue.length);
        int val = 0;
        String out = "";

        while (!isEmpty()){
            val = removeFirst();
            fi.addLast(val);
            
            if (out == ""){
                out += val;
             }else {
                out += ", " + val;
             }
            
        }

        while (!fi.isEmpty()){
            val = fi.removeFirst();
            addLast(val);
        }

        return out;
    }
    
    // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. 
    public int indexOf(int valor) {
        Fila aux = new Fila(this.queue.length);
        int val = 0;
        int out = -1;
        int count = 0;
        
        while (!isEmpty()){
            val = removeFirst();
            aux.addLast(val);

            if (val == valor){
                out = count;
                break;
            }
            
            count++;
        }
        
        if (!isEmpty()) {
        	while (!isEmpty()) {
        		val = removeFirst();
                aux.addLast(val);
        	}
        }
        
        while (!aux.isEmpty()){
            val = aux.removeFirst();
            addLast(val);
        }

        return out;
    }

    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
    	Fila aux = new Fila(this.queue.length);
        int val = 0;
        int out = -1;
        int count = 0;
        
        while (!isEmpty()){
            val = removeFirst();
            aux.addLast(val);

            if (val == valor){
                out = count;
            }
            
            count++;
        }
        
        while (!aux.isEmpty()){
            val = aux.removeFirst();
            addLast(val);
        }

        return out;
    }
    
    public int size() {
        return this.size;
    }

}
