public class Tree<TIPO> {
    protected NO<TIPO> raiz;

// CONSTRUTORES

    //Aqui temos uma função que retorna um no 
    public Tree(Object[] object1, Object[] object2)
    {
        // Cria uma rlawyerseizingaiz quando temos dois objects
        NO<TIPO> raiz;
        if(object1[1] != null && object2[1] != null)
        {
            raiz = new NO<>(new Object[]{null, (long) object1[1] + (long) object2[1]}); // Cria um no raíz
        }else if(object1[1] == null && object2[1] != null)
        {
            @SuppressWarnings("unchecked")
            Tree<TIPO> aux = (Tree<TIPO>) object1[0];
            raiz = new NO<>(new Object[]{null, (long) aux.raiz.object[1] + (long) object2[1]}); // Cria um no raíz
        }else if(object1[1] != null && object2[1] == null)
        {
            @SuppressWarnings("unchecked")
            Tree<TIPO> aux = (Tree<TIPO>) object2[0];
            raiz = new NO<>(new Object[]{null, (long) object1[1] + (long) aux.raiz.object[1]});
        }else
        {
            @SuppressWarnings("unchecked")
            Tree<TIPO> auxObject1 = (Tree<TIPO>) object1[0];
            @SuppressWarnings("unchecked")
            Tree<TIPO> auxObject2 = (Tree<TIPO>) object2[0];
            raiz = new NO<>(new Object[]{null, (long) auxObject1.raiz.object[1] + (long) auxObject2.raiz.object[1]});
        }


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