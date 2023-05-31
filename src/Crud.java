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
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/atividade_emily","root","");
            System.out.println("Feito!");
        }catch (Exception erro){
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }
    }

    public void cadastrar(String nome, String cargo, String celular){
        try{
            consulta =  con.prepareStatement("INSERT INTO cadastro_funcionarios (nome, cargo,celular) VALUES (?,?,?)");
            consulta.setString(1, nome);
            consulta.setString(2, cargo);
            consulta.setString(3, celular);
            consulta.executeUpdate();
            System.out.println("Cadastro realizado com sucesso!");
        }catch (Exception erro){
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }

    }
    public void excluir(int id){
        try{
            consulta.executeUpdate("DELETE from cadastro_funcionarios where id = " + id);
            System.out.println("Cadastro excluído com sucesso!");
        }catch (Exception erro){
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }
    }

    public void editar(int id,String nome, String cargo, String celular){
        try{
            consulta.executeUpdate("UPDATE cadastro_funcionarios set nome = '"+nome+"', cargo = '"+cargo+"', celular = '"+celular+"'  where id = " + id);
            System.out.println("Cadastro editado com sucesso!");
        }catch (Exception erro){
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }
    }

    public String selecionaTudo() {
        try {
            ResultSet tabela = consulta.executeQuery("SELECT * FROM cadastro_funcionarios");

            //String format = "%s -> %6s | %-4.1f | %-5.1f | %-6d | %-6d\n";

            String relatorio = "ID\t NOME\t CARGO\t CELULAR\t \n";

            while(tabela.next()) {
                relatorio += tabela.getString("id") + "\t"
                        + tabela.getString("nome") + "\t"
                        + tabela.getString("cargo") + "\t"
                        + tabela.getString("celular") + "\n";
            }
            return relatorio;
        } catch(Exception erro) {
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }
        return null;
    }

    public String selecionaComFiltro(int id) {
        try {
            ResultSet tabela = consulta.executeQuery("SELECT * FROM cadastro_funcionarios where id = " + id);

            String relatorio = "ID\t NOME\t CARGO\t CELULAR\t \n";

            while(tabela.next()) {
                relatorio += tabela.getString("id") + "\t"
                        + tabela.getString("nome") + "\t"
                        + tabela.getString("cargo") + "\t"
                        + tabela.getString("celular") + "\n";
            }
            return relatorio;
        } catch(Exception erro) {
            System.out.println("Ops! Atenção ao erro: " + erro.getMessage());
        }
        return null;
    }

}


