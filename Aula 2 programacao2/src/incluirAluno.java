@Override
public void incluir(Aluno entidade) {
        try {
        PreparedStatement ps = getConnection().prepareStatement(
        "INSERT INTO ALUNO VALUES (?, ?, ?)");
        ps.setString(1, entidade.matricula);
        ps.setString(2, entidade.nome);
        ps.setInt(3, entidade.ano);
        ps.executeUpdate();
        closeStatement(ps);
        } catch (Exception e) { }
        }
@Override
public void excluir(String chave) {
        try {
        PreparedStatement ps = getConnection().prepareStatement(
        "DELETE FROM ALUNO WHERE MATRICULA = ?");
        ps.setString(1, chave);
        ps.executeUpdate();
        closeStatement(ps);
        } catch (Exception e) { }
        }
@Override
public void alterar(Aluno entidade) {
        try {
        PreparedStatement ps = getConnection().prepareStatement(
        "UPDATE ALUNO SET NOME = ?, ENTRADA = ? "+
        " WHERE MATRICULA = ?");
        ps.setString(1, entidade.nome);
        ps.setInt(2, entidade.ano);
        ps.setString(3, entidade.matricula);
        ps.executeUpdate();
        closeStatement(ps);
        } catch (Exception e) { }
        }
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="" xmlns:xsi=""
        xsi:schemaLocation="">
<persistence-unit name="ExemploJavaDB01PU"
        transaction-type="RESOURCE_LOCAL">
<provider>
		           org.eclipse.persistence.jpa.PersistenceProvider
</provider>
<class>modelJPA.Aluno</class>
<properties>
<property name="javax.persistence.jdbc.url"
        value="jdbc:derby://localhost:1527/escola"/>
<property name="javax.persistence.jdbc.user"
        value="escola"/>
<property name="javax.persistence.jdbc.driver"
        value="org.apache.derby.jdbc.ClientDriver"/>
<property name="javax.persistence.jdbc.password"
        value="escola"/>
</properties>
</persistence-unit>
</persistence>
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("ExemploJavaDB01PU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Aluno.findAll",Aluno.class);
        List<Aluno> lista = query.getResultList();
        lista.forEach(aluno->{
        System.out.println(aluno.getNome());
        });