public abstract class Zona implements Comparable{
    protected String nome;

    public Zona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String relatorio(){
        return "Relatório da Zona: " + nome + "\n";
    }

    @Override
    public int compareTo(Object obj){
        return (obj instanceof Zona && this.nome.equals(((Zona) obj).nome) ? 0 : 1);
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Zona && this.nome.equals(((Zona) obj).nome));
    }
}
