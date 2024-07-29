import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
public class Compactor
{

    // Printando arvore
    public static void printTree(NO<Object> no)
    {
        if(no.left != null) printTree(no.left);
        System.out.println("[" + no.object[0] + ", " + no.object[1] + "]");
        if(no.right != null) printTree(no.right);
    }

    public static void main(String[] args)
    {
        String stringPath, stringAux, string[];
        char res, stringPathList[];
        StringBuilder stringBuilder;
        int pos;
        Path path;
        Tree<Object> tree;
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());


        while (true)
        {
            // Verificar se o arquivo é vazio
            
            
            System.out.print("Coloque o caminho do diretório ou arquivo do seu arquivo: ");
            stringPath = scanner.nextLine().replace("\\", "/").replace("& ", "").replace("&", "");
            
            stringPathList = stringPath.toCharArray();
            stringBuilder = new StringBuilder(stringPathList.length - 1);

            if(stringPathList[0] == '\'')
            {
                for(int i = 1; i < stringPathList.length; i++)
                {
                    stringBuilder.append(stringPathList[i]);
                }

                stringPath = stringBuilder.toString();
            }

            stringPathList = stringPath.toCharArray();
            stringBuilder = new StringBuilder(stringPathList.length - 1);

            if(stringPathList[stringPathList.length - 1] == '\'')
            {
                pos = 0;
                while(pos != stringPathList.length - 1)
                {
                    stringBuilder.append(stringPathList[pos]);
                    pos++;
                }

                stringPath = stringBuilder.toString();
            }
            
            File file = new File(stringPath);

            // Checking if the file isn't empty
            if(file.length() == 0L)
            {
                System.out.println("O arquivo: \"" + stringPath + file.length() + "\" está vazio.\n");
            } else{
                path = Paths.get(stringPath);

                // Checking if file exist
                if(Files.exists(path))
                {
                    // Checking if the path is a directory
                    if(Files.isDirectory(path))
                    {
                        System.out.println("Diretório");
                    } else if(Files.isRegularFile(path)) // Checking if is a file
                    {

                        stringAux = Arrays.toString(stringPath.split("\\."));
                        stringAux = stringAux.substring(1, stringAux.length() - 1); // tirar os parentesis

                        // Dividir novamente a string pela vírgula e espaço
                        string = stringAux.split(", ");

                        // Checking if the file is a comp file
                        if(string[string.length - 1] != "comp")
                        {
                            FilaDePrioridade fila;
                            try
                            {   
                                fila = new FilaDePrioridade(path);
                                if(fila.listByte.size() != 1)
                                {
                                    while(true)
                                    {
                                        System.out.println("Em cima: " + fila.listByte.size());

                                        
                                        tree = new Tree<>(fila.listByte.get(0), fila.listByte.get(1));
                                        

                                        // Removendo os valores adicionados a arvore
                                        fila.listByte.remove(0);
                                        fila.listByte.remove(0);

                                        if(fila.listByte.size() == 0)
                                        {
                                            fila.listByte.add(new Object[]{tree, null});
                                            break;
                                        }


                                        pos = 0;
                                        while(true)
                                        {
                                            System.out.println("LOOP 2: ");

                                            if(pos == fila.listByte.size())
                                            {
                                                fila.listByte.add(new Object[]{tree, null});
                                                break;
                                            }
                                            if(fila.listByte.get(pos)[1] != null)
                                            {
                                                if((long) tree.raiz.object[1] <= (long) fila.listByte.get(pos)[1])
                                                {
                                                    fila.listByte.add(pos, new Object[]{tree, null});
                                                    break;
                                                }
                                            }else
                                            {
                                                @SuppressWarnings("unchecked")
                                                Tree<Object> aux = (Tree<Object>) fila.listByte.get(pos)[0];
                                                if((long) tree.raiz.object[1] <= (long) aux.raiz.object[1])
                                                {
                                                    fila.listByte.add(pos, new Object[]{tree, null});
                                                    break;
                                                }
                                            }
                                            pos++;
                                        }
                                    }



                                    printTree(tree.raiz);
                                }else
                                {
                                    System.out.println("O arquivo: \"" + stringPath + "\" é muito pequeno para ser compactado.\n");
                                }

                            }catch(Exception e)
                            {
                                System.out.println(e.getMessage());
                            }
                        }else
                        {
                            // Colocar código de descompactação
                        }

                    }else
                    {
                        System.out.println("O caminho: \"" + path + "\" não é válido, pois não é um diretório nem um arquivo.\n");
                    }
                }else
                {
                    System.out.println("O caminho: \"" + path + "\" não é válido, pois não existe.\n");
                }
            }


            // Perguntar se o usuário quer compactar mais
            System.out.print("Digite qualquer coisa diferente de \"n ou N\" para compactar outros arquivos ou pastas: ");
            res = scanner.nextLine().toUpperCase().charAt(0);
            

            if(res == 'N') break;
        }
        scanner.close();
        System.out.println("\nOBRIGADO POR USAR ESTE PROGRAMA!!\nVOLTE SEMPRE!!");
    }
}


/*
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption; 


Pegar cada byte de um arquivo
byte[] fileBytes = Files.readAllBytes(Paths.get(PATH DO ARQUIVO));

Verificar se o path é válido, retorna boolean
Files.exists(COLOCAR PATH)

Verificar se é arquivo
Files.isRegularFile(COLOCAR PATH)

Verificar se é diretório
Files.isDirectory(COLOCAR PATH)

Descompactar um arquivo, depois de já ter transformado de número para bytes
Files.write(Paths.get(PATH DO ARQUIVO), fileBytes, StandardOpenOption.CREATE);
*/