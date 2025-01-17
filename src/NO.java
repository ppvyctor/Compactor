public class NO<TIPO> {
    protected long qtd_aparecimentos;
    protected byte get_byte;
    protected NO<TIPO> left;
    protected NO<TIPO> right;


    // Construtor que recebe um object
    public NO(Object[] object)
    {
        this.qtd_aparecimentos = (long) object[1];
        this.get_byte = (byte) object[0];
        this.left = null;
        this.right = null;
    }


// ABAIXO TEMOS FUNÇÕES GETERS

    // Retorna o object de um no
    public byte getByte()
    {
        return this.get_byte;
    }


    public long getAparecimentos()
    {
        return this.qtd_aparecimentos;
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
        this.get_byte = (byte) object[0];
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
        System.out.println("[" + this.get_byte + ", " + this.qtd_aparecimentos + "]");
    }
}