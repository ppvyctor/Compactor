import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class FilaDePrioridade
{
    private byte[] fileByte;
    protected ArrayList<Object[]> listByte = new ArrayList<>();





    public FilaDePrioridade(Path path) throws Exception
    {
        try
        {
            this.fileByte = Files.readAllBytes(path);

            int pos;
            Object[] aux;
            // O objeto da esquerda é o byte e o da direita é a quantidade de aparecimentos do byte.
            this.listByte.add(new Object[]{this.fileByte[0], 1L});

            for(int i = 1; i < fileByte.length; i++)
            {
                pos = 0;
                while(true)
                {
                    if((byte) this.listByte.get(pos)[0] == this.fileByte[i])
                    {
                        this.listByte.get(pos)[1] = (long) this.listByte.get(pos)[1] + 1;
                        aux = this.listByte.get(pos);

                        if(this.listByte.size() != 1 && pos < this.listByte.size() - 1)
                        {    
                            this.listByte.remove(pos);

                            while(true)
                            {
                                if((long) this.listByte.get(pos)[1] >= (long) aux[1])
                                {
                                    this.listByte.add(pos, aux);
                                    break;
                                }
                                
                                if(pos == this.listByte.size() - 1)
                                {
                                    this.listByte.add(aux);
                                    break;
                                }
                                pos++;
                            }

                            break;
                        }

                        break;
                    }

                    if(pos == this.listByte.size() - 1)
                    {
                        this.listByte.add(0, new Object[]{this.fileByte[i], 1L});
                        break;
                    }

                    pos++;
                }
            }
        }catch(Exception e)
        {
            throw new Exception("O Caminho: \"" + path + "\" não pode ser convertido para byte.");
        }
    }





// Funções geters
    public byte[] getFileByte()
    {
        return this.fileByte;
    }






    public ArrayList<Object[]> getFilaDePrioridade()
    {
        return this.listByte;
    }
}