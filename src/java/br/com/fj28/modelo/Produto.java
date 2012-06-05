package br.com.fj28.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author danielcarlos
 */
@Entity
public class Produto {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;

     //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Double getPreco() {
        return preco;
    }
    
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    //</editor-fold>
    
    
}
