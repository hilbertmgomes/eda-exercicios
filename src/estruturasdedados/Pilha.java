package estruturasdedados;

public class Pilha {
    private int[] stack;
    private int top;

    public Pilha(int capacidade) {
        this.stack = new int[capacidade];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return ((this.top) % this.stack.length) == this.stack.length - 1;
    }

    // deve lançar exceção caso a pilha esteja cheia.
    public void push(int valor) {
        if (isFull()) throw new RuntimeException("A pilha esta cheia");
        stack[(this.top + 1) % this.stack.length] = valor;
        this.top++;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int pop() {
        if (isEmpty()) throw new RuntimeException("A pilha esta vazia");

        int val = stack[(this.top) % this.stack.length];
        this.top--;

        return val;
    }

    // deve lançar exceção caso a pilha esteja vazia.
    public int top() {
        if (isEmpty()) throw new RuntimeException("A pilha esta vazia");

        return stack[(this.top) % this.stack.length];
    }


    // deve retornar uma string representando a pilha. Veja os testes para a especificação
    // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
    // isEmpty etc. 
    public String toString() {
        Pilha pi = new Pilha(this.stack.length);
        int val = 0;
        String out = "";

        while (!isEmpty()){
            val = pop();
            pi.push(val);
        }

        while (!pi.isEmpty()){
            val = pi.pop();

            if (out == ""){
               out += val;
            }else {
               out += ", " + val;
            }
            
            push(val);
        }

        return out;
    }
    
    // Deve retornar o índice da primeira ocorrência do elemento passado como parâmetro. 
    // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
    // isEmpty etc.
    public int indexOf(int valor) {
        Pilha aux = new Pilha(this.stack.length);
        int val = 0;
        int out = -1;
        
        while (!isEmpty()){
            val = pop();
            aux.push(val);

            if (val == valor){
                out = size();
            }
        }
        
        while (!aux.isEmpty()){
            val = aux.pop();
            push(val);
        }

        return out;
    }

    public int lastIndexOf(int valor){
    	Pilha aux = new Pilha(this.stack.length);
        int val = 0;
        int out = -1;
           
        while (!isEmpty()){
        	val = pop();
            aux.push(val);

            if (val == valor){
                out = size();
                break;
            }
        }
           
        while (!aux.isEmpty()){
            val = aux.pop();
            push(val);
        }

        return out;
    }


    public int size() {
        return this.top + 1;
    }

}