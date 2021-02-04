import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Fone{
    String label;
    String number;

    Fone(String label, String number){
        this.label = label;
        this.number = number;
    }

    public static boolean validate(String number){
        String validos = "123456789-()";
        for(int i=0; i < number.length(); i++)
            if(validos.indexOf(number.charAt(i)) == -1)
                return false;
        return true;
    }

    public String toString(){
        return label + ":" + number;
    }
}

class Contato{
    String name;
    boolean starred;
    ArrayList<Fone> fones;

    Contato(String name){
        this.name = name;
        this.fones = new ArrayList<>();
    }

    void addFone(String label, String number){
        if(Fone.validate(number)){
            fones.add(new Fone(label, number));
        }
        //Fazer uma excessão aqui
    }

    void rmFone(int index){
        if(fones.get(index) != null){
            fones.remove(index);
        }
        //Fazer uma excessão aqui
    }

    public String toString(){
        StringBuilder saida = new StringBuilder();
        int i=0;
        for (Fone fones : fones) {
            saida.append("[" + i + ":" + fones + "]");
            i++;
        }
        return saida.toString();
    }
}

class Agenda{
    TreeMap<String, Contato> contatos;
    TreeMap<String, Contato> bookMarks;

    Agenda(){
        this.contatos = new TreeMap<>();
        this.bookMarks = new TreeMap<>();
    }

    void addContato(String name, List<Fone> fones){
        if(!this.contatos.containsKey(name))
            contatos.put(name, new Contato(name));
        for(int i=0; i < fones.size(); i++)
            contatos.get(name).addFone(fones.get(i).label, fones.get(i).number);
    }

    void rmContato(String name){
        if(this.contatos.containsKey(name)){
            contatos.remove(name);
        }else if(this.bookMarks.containsKey(name))
            bookMarks.remove(name);
        //}else
            //Erro aqui
    }

    void addFavorito(String id){
        Contato contato = contatos.get(id);
        if(!contatos.get(id).starred){
            contato.starred = true;
            bookMarks.put(id, contato);
        }
        //Fail aqui
    }

    void removerFavorito(String id){
        Contato contato = contatos.get(id);
        if(this.contatos.get(id).starred){
            contato.starred = false;
            bookMarks.remove(id);
        }
        //Erro aqui
    }

    ArrayList<Contato> search(String patter){
        ArrayList<Contato> busca = new ArrayList<>();
        if(this.contatos.containsKey(patter))
            busca.add(contatos.get(patter));
        return busca;
    }

    ArrayList<Contato> getStarred(){
        ArrayList<Contato> favoritos = new ArrayList<>();
        favoritos.addAll(bookMarks.values());
        return favoritos;
    }

    public String toString(){
        StringBuilder saida = new StringBuilder();
        for(Contato contato : this.contatos.values())
            if(bookMarks.containsKey(contato.name)){
                saida.append("@ " + contato.name + " " + contato.fones + "\n");
            }else
                saida.append("- " + contato.name + " " + contato.fones + "\n");
        return saida.toString();
    }
}

public class Sistema{
    public static void main(String[] agrs){

        Agenda agenda = new Agenda();

        //Adicionando contatos
        agenda.addContato("eva", Arrays.asList(new Fone("oio", "8585"), new Fone("cla", "9999")));
        agenda.addContato("ana", Arrays.asList(new Fone("Tim", "3434")));
        agenda.addContato("bia", Arrays.asList(new Fone("viv", "5454")));
        agenda.addContato("ana", Arrays.asList(new Fone("cas", "4567"), new Fone("oio", "8754")));
        System.out.println(agenda);
    
        // //case favoritando
        agenda.addFavorito("eva");
        agenda.addFavorito("ana");
        
        for(Contato favoritos : agenda.getStarred())
            System.out.println(favoritos);

    //    //Removendo contato
    //     agenda.rmContato("ana");
    //     System.out.println(agenda);

    //     //Removendo favorito
    //     agenda.removerFavorito("eva");
    //     System.out.println(agenda.bookMarks + "\n");

    //     //Procurando contato
    //     System.out.println(agenda.search("bia"));
    }
}