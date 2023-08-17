@Entity
@Table(name = "ALUNO")
@NamedQueries({
        @NamedQuery(name = "Aluno.findAll",
                query = "SELECT a FROM Aluno a")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MATRICULA")
    private String matricula;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "ENTRADA")
    private Integer ano;

    public Aluno() {
    }

    public Aluno(String matricula) {
        this.matricula = matricula;
    }
    // getters e setters para os atributos internos
}