import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Crud crud = new Crud();

        String menu = "";

        do {
            menu = JOptionPane.showInputDialog(null,"------ Cadastro de Funcionário ------"
                    + "\nDigite a opção desejada:\n"
                    + "1) Cadastrar\n"
                    + "2) Editar\n"
                    + "3) Excluir\n"
                    + "4) Visualizar tudo\n"
                    + "5) Visualizar um funcionário\n"
                    + "6) Sair");

            if(menu.equals("1")) {
                String nome = JOptionPane.showInputDialog(null, "Digite o nome:");
                String cargo = JOptionPane.showInputDialog(null, "Digite o cargo:");
                String celular = JOptionPane.showInputDialog(null, "Digite o telefone:");
                crud.cadastrar(nome,cargo,celular);
            } else if(menu.equals("2")) {
                String aux = JOptionPane.showInputDialog(null, "Digite o id:");
                int id = Integer.parseInt(aux);
                String nome = JOptionPane.showInputDialog(null, "Digite o nome:");
                String cargo = JOptionPane.showInputDialog(null, "Digite o cargo:");
                String celular = JOptionPane.showInputDialog(null, "Digite o telefone:");
                crud.editar(id, nome,cargo,celular);
            }
            else if(menu.equals("3")) {
                String aux = JOptionPane.showInputDialog(null, "Digite o id:");
                int id = Integer.parseInt(aux);
                crud.excluir(id);
            }
            else if(menu.equals("4")) {
                JOptionPane.showMessageDialog(null, crud.selecionaTudo());
            }
            else if(menu.equals("5")) {
                String aux = JOptionPane.showInputDialog(null, "Digite o id:");
                int id = Integer.parseInt(aux);
                JOptionPane.showMessageDialog(null, crud.selecionaComFiltro(id));
            }
        } while(!menu.equals("6"));

    }

}
