import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("O que deseja?");

        while(true){
            String input = scanner.nextLine();
            String[] entry = input.split("");
            System.out.println("$" + input);

            if(entry[0].equals("break;")){
                break;
            }else if(entry[0].equals("add")){
                Cliente cliente =  new Cliente();
                cliente.cliente(entry[1]);
            }else if(entry[0].equals("show")){
                Agencia agencia = new Agencia();
                System.out.println(agencia);
            }
        }
        scanner.close();
    }
}
