import java.util.TreeMap;

public class Cliente {
    String id;
    TreeMap<ContaCorrente, ContaPoupança> contas;

    Cliente(String id){
        this.id = id;
        this.contas = new TreeMap<>();
    }

    // void cliente(String id){
    //     this.id = id;
    //     contas.put(new ContaCorrente(0, 0, id, "CC"), new ContaPoupança(1, 0, id, "CP"));
    // }

    public String toString(){
        return id + contas.values().toString();
    }
}