package br.com.fivestarsbank.BlueBank.models;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Length(min = 8, max = 20 , message = "Telefone entre 8 a 20 caracteres.")
    private String telefone;

    private String contato_tel;

    @NotNull
    @Length(max = 10, message = "Descrição na máximo 20 caracteres.")
    private String descricao;

    @NotNull
    @Length(min = 10 , max = 50, message = "E-mail com máximo 50 caracteres.")
    private String email;

    @NotNull
    @ManyToOne
    private Cliente cliente;

    //
    public Contato() {

    }

    public Contato(@NotNull @Length(min = 8, max = 20, message = "Telefone entre 8 a 20 caracteres.") String telefone,
                   String contato_tel, @NotNull @Length(max = 10, message = "Descrição na máximo 20 caracteres.") String descricao,
                   @NotNull @Length(min = 10, max = 50, message = "E-mail com máximo 50 caracteres.") String email,
                   @NotNull Cliente cliente) {
        super();
        this.telefone = telefone;
        this.contato_tel = contato_tel;
        this.descricao = descricao;
        this.email = email;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getContato_tel() {
        return contato_tel;
    }
    public void setContato_tel(String contato_tel) {
        this.contato_tel = contato_tel;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contato other = (Contato) obj;
        return Objects.equals(id, other.id);
    }
}
