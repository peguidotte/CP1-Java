public class Produto {
    private String nome;
    private double preco;
    private int quantidadeDisponivel;
    private int tempoPreparo;
    private double nota;

    public Produto(){
        this.nome = "Indefinido";
        this.preco = 0;
        this.quantidadeDisponivel = 0;
        this.tempoPreparo = 0;
        this.nota = 0;
    }

    public Produto(String nome, double preco, int quantidadeDisponivel, int tempoPreparo, double nota) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.tempoPreparo = tempoPreparo;
        this.nota = nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getTempoPreparo() { return tempoPreparo; }
    public double getNota() { return nota; }


    public boolean estoqueFaltando(int quantidade) {
        if (quantidade > quantidadeDisponivel) {
            return false;
        }
        quantidadeDisponivel -= quantidade;
        return true;
    }
}