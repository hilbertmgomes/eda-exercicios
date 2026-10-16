package estruturasdedados;

import java.util.Arrays;

public class ArrayList {
	private int[] list;
	private static final int DEFAULT_SIZE = 10;
	private int tail;
	
	public ArrayList() {
		this.list = new int[DEFAULT_SIZE];
		this.tail = -1;
	}
	
    public ArrayList(int capacidadeInicial) {
        this.list = new int[capacidadeInicial];
        this.tail = -1;
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }
    
    public int getTail() {
    	return this.tail;
    }
    
    public void addFirst(int valor) {
    	assegureCapacidade(tail + 1);
    	
      	this.tail++;
    	shiftRight(0);
    	this.list[0] = valor;
    	
    }

    public void addLast(int valor) {
        assegureCapacidade(tail + 1);
        
        this.tail++;
        this.list[tail] = valor;
    }

    // adiciona um valor no índice passado como parâmetro
    public void add(int index, int valor) {
    	if (index < 0 || index > tail + 1) throw new IndexOutOfBoundsException("Indice " + index + " invalido para tamanho " + this.tail);
        assegureCapacidade(tail + 1);
        
      	this.tail++;
        shiftRight(index);
        
        this.list[index] = valor;
    }

    public void assegureCapacidade(int capacidadePretendida) {
    	if (capacidadePretendida >= this.list.length) {
    		resize(Math.max(this.list.length * 2, capacidadePretendida));
    	}
    }

    public int getFirst() {
    	if (isEmpty()) throw new RuntimeException("Lista esta vazia");
        return this.list[0];
    }

    public int getLast() {
    	if (isEmpty()) throw new RuntimeException("Lista esta vazia");
        return this.list[this.tail];
    }

    // retorna o elemento no índice passado como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
    	if (index < 0 || index > tail) throw new IndexOutOfBoundsException("Indice " + index + " invalido para tamanho " + this.tail);
        return this.list[index];
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {
        if (isEmpty()) throw new RuntimeException("Lista esta vazia");
        
        int val = this.list[0];
        
        shiftLeft(0);
        this.tail--;
        
        return val;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public void removeLast() {
    	 if (isEmpty()) throw new RuntimeException("Lista esta vazia");
         this.tail--;
    }

    // remove o valor no índice passado como parâmetro. 
    // lançar exceção se o índice não for válido.
    public void remove(int index) {
    	 if (index < 0 || index > tail) throw new IndexOutOfBoundsException("Indice " + index + " invalido para tamanho " + this.tail);
         
         shiftLeft(index);
         this.tail--;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada.
    public void removeByValue(int value) {
    	int idx = indexOf(value);
    	
    	if (idx == -1) return;
    	
    	shiftLeft(idx);
        this.tail--;
    	
    }

    // retorna o índice da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
    	int idx = -1;
    	
    	for (int i = 0; i <= this.tail; i++) {
    		if (this.list[i] == value) {
    			idx = i;
    			break;
    		}
    	}
    	
    	return idx;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {
    	int idx = -1;
    	
    	for (int i = 0; i <= this.tail; i++) {
    		if (this.list[i] == valor) {
    			idx = i;
    		}
    	}
    	
    	return idx;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
    	String out = "";
    	
    	
    	for (int i = 0; i <= this.tail; i++) {
    		if (i == 0) {
    			out += this.list[i];
    		}else {
    			out += ", " + this.list[i];
    		}
    		
    	}
    	
        return out;
    }
    
    public int size() {
        return this.tail + 1;
    }
    
    // você vai precisar desse método quando tentar adicionar e a fila já estiver cheia
    private void resize(int novaCapacidade) {
    	int[] newList = new int[novaCapacidade];
       
        for (int i = 0; i <= this.tail; i++) {
    	    newList[i] = this.list[i];
        }
        
        this.list = newList;
    }
    
    private void shiftRight(int stop) {
    	for (int i = this.tail; i > stop; i--) {
    		this.list[i] = this.list[i-1];
    	}
    	
    }
    
    private void shiftLeft(int ini) {
    	for (int i = ini; i <= this.tail-1; i++) {
    		this.list[i] = this.list[i+1];
    	}
    }
}