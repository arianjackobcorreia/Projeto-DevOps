package model;

public enum TiposCarta {
    FINANCEIRO(1, "Financeiro"),
    AMOR(2, "Amor"),
    MOTIVACAO(3, "Motivação"),
    DESCULPAS(4, "Desculpas!"),
    PARABENS(5, "Parabéns!"),
    AVISO(6, "Aviso!"),
    REFLEXAO(7, "Reflexão..."),
    PERSEVERANCA(8, "Perseverança!"),
    DESPEDIDA(9, "Despedida"),
    POETICA(10, "*Poética*");

    private int codigo;
    private String descricao;

    TiposCarta(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getDescricao(){
        return descricao;
    }

    public static TiposCarta fromCodigo(int codigo){
        for (TiposCarta t : values()){
            if (t.codigo == codigo)
                return t;
        }
        return null;
    }
}
