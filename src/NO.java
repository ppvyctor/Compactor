public class NO<TIPO> {
    protected Object[] object;
    protected NO<TIPO> left;
    protected NO<TIPO> right;


    // Construtor que recebe um object
    public NO(Object[] object)
    {
        this.object = object;
        this.left = null;
        this.right = null;
    }


// ABAIXO TEMOS FUNÇÕES GETERS

    // Retorna o object de um no
    public Object[] getObject()
    {
        return this.object;
    }


    // Retorna o no da direita
    public NO<TIPO> getNoRight()
    {
        return this.right;
    }


    // Retorna o no da esquerda
    public NO<TIPO> getNoLeft()
    {
        return this.left;
    }


// ABAIXO TEMOS FUNÇÕES SETERS

    // Modifica o valor do object
    public void setObject(Object[] object)
    {
        this.object = object;
    }


    // Modifica o no da direita
    public void setNoRight(NO<TIPO> no)
    {
        this.right = no;
    }


    // Modifica o no da esquerda
    public void setNoLeft(NO<TIPO> no)
    {
        this.left = no;
    }

// Print no
    public void printNo()
    {
        System.out.println("[" + this.object[0] + ", " + this.object[1] + "]");
    }
}