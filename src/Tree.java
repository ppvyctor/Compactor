public class Tree<TIPO> {
    protected NO<TIPO> raiz;

// CONSTRUTORES

    //Aqui temos uma função que retorna um no 
    public Tree(Object[] object1, Object[] object2)
    {
        // Cria uma rlawyerseizingaiz quando temos dois objects
        NO<TIPO> raiz = new NO<>(new Object[]{null, (long) object1[1] + (long) object2[1]});

        NO<TIPO> noLeft = new NO<>(object1); // Cria um no auxiliar que futuramente será o no da esquerda
        NO<TIPO> noRight = new NO<>(object2); // Cria um no auxiliar que futuramente será o no da direita

        raiz.setNoLeft(noLeft); // Coloca o no auxiliar da esquerda no no raíz
        raiz.setNoRight(noRight); // Coloca o no auxiliar da direita no no raíz
        
        this.raiz = raiz; // Adiciona o valor da raíz na variavel raiz da classe
    }




// Função geter
    
    // Retorna o valor da raiz
    public NO<TIPO> getRaiz() 
    {
        return this.raiz;
    }



// Funções setters

    // Modifica o valor da raiz
    public void setRaiz(NO<TIPO> raiz) 
    {
        this.raiz = raiz;
    }



}