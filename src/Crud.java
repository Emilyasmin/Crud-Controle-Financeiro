import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Crud {
    Connection con;
    PreparedStatement consulta;



    public Crud(){
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/controle_fluxos","root","");
            System.out.println("Feito!");
        }catch (Exception erro){
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }
    }

    public void cadastrar(String nome, int valor, String data, String situacao){
        try{
            consulta =  con.prepareStatement("INSERT INTO controle_financeiro (nome,valor,data,situacao) VALUES (?,?,?,?)");
            consulta.setString(1, nome);
            consulta.setInt(2, valor);
            consulta.setString(3, data);
            consulta.setString(4, situacao);

            consulta.executeUpdate();
            System.out.println("Cadastro realizado com sucesso!");
        }catch (Exception erro){
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }

    }
    public void excluir(int id){
        try{
            consulta.executeUpdate("DELETE from controle_financeiro where id = " + id);
            System.out.println("Débito excluído com sucesso!");
        }catch (Exception erro){
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }
    }

    public void editar(int id,String nome, int valor, String data, String situacao){
        try{
            consulta.executeUpdate("UPDATE controle_financeiro set nome = '"+nome+"', valor = '"+valor+"', data = '"+data+"',situacao = '"+situacao+"'  where id = " + id);
            System.out.println("Débito editado com sucesso!");
        }catch (Exception erro){
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }
    }

    public String selecionaTudo() {
        try {
            ResultSet tabela = consulta.executeQuery("SELECT * FROM controle_financeiro");

            String relatorio = "ID\t        NOME\t                 VALOR\t            DATA\t                SITUAÇÃO\n";

            while (tabela.next()) {
                String id = tabela.getString("id");
                String nome = tabela.getString("nome");
                String valor = tabela.getString("valor");
                String data = tabela.getString("data");
                String situacao = tabela.getString("situacao");

                String linha = String.format("%-8s\t%-30s\t%-15s\t%-20s\t%-20s\n", id, nome, valor, data, situacao);
                relatorio += linha;
            }
            return relatorio;
        } catch(Exception erro) {
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }
        return null;
    }

    public String selecionaComFiltro(int id) {
        try {
            ResultSet tabela = consulta.executeQuery("SELECT * FROM controle_financeiro where id = " + id);

            String relatorio = "ID\t NOME\t VALOR\t DATA\t SITUAÇÃO\t\n";

            while(tabela.next()) {
                relatorio += tabela.getString("id") + "\t"
                        + tabela.getString("nome") + "\t"
                        + tabela.getString("valor") + "\t"
                        + tabela.getString("data") + "\t"
                        + tabela.getString("situacao") + "\n";
            }
            return relatorio;
        } catch(Exception erro) {
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }
        return null;
    }

}


