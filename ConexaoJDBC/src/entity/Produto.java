package entity;

public class Produto {

    private int codigo;
    private String descricao;
    private double valor;
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }


    
}
