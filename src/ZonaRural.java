
public class ZonaRural extends Zona {

    public ZonaRural(String nome) {
        super(nome);
    }
    public String relatorio(){
        return super.relatorio() + "Zona sem sensores instalados. Monitoramento indireto via satélite. \n";
    }
}
