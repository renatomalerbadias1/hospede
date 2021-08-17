
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *Classe responsavel por armazenar atributo do obj aluno
 * @author Renato Dias
 * @since 10/03/2021
 */

@Entity
@Table(name = "chekin")
public class Chekin implements Serializable {
    
    //declarando os atributos
    
    @Id
    @GeneratedValue
    @Column(name = "id_chekin")
    private int idChekin;//auto incremento
    
    @Column(name = "nome")
    @Basic(optional = false)
    private String nome;
    
    @Column(name = "dataEntrada")
    @Basic(optional = false)
    private String dataEntrada;
    
    @Column(name = "dataSaida")
    @Basic(optional = false)
    private String  dataSaida;
    
     @Column(name = "nomedocumento")
    @Basic(optional = false)
    private String nomedocumento;
    
     @Column(name = "telefone")
    @Basic(optional = false)
    private String telefone;
     
    
     
      @Column(name = "valor")
    @Basic(optional = false)
    private String valor;
     

    public int getIdChekin() {
        return idChekin;
    }

    public void setIdChekin(int idChekin) {
        this.idChekin = idChekin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getNomedocumento() {
        return nomedocumento;
    }

    public void setNomedocumento(String nomedocumento) {
        this.nomedocumento = nomedocumento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    

    

   
    
    
    
}
