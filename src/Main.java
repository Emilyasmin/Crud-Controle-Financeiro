import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Crud crud = new Crud();

        String menu = "";

        do {
            menu = JOptionPane.showInputDialog(null,"------ Controle de Gastos ------"
                    + "\nDigite a opção desejada:\n"
                    + "1) Inserir novo\n"
                    + "2) Editar\n"
                    + "3) Excluir\n"
                    + "4) Visualizar todos\n"
                    + "5) Visualizar apenas um\n"
                    + "6) Sair");

            if(menu.equals("1")) {
                String nome = JOptionPane.showInputDialog(null, "Digite o nome:");

                String aux = JOptionPane.showInputDialog(null, "Digite o valor:");
                int valor = Integer.parseInt(aux);
                String data = JOptionPane.showInputDialog(null, "Digite a data de pagamento:");
                String situacao = JOptionPane.showInputDialog(null, "Digite a situacao do pagamento:");
                crud.cadastrar(nome,valor,data,situacao);
            } else if(menu.equals("2")) {
                String aux = JOptionPane.showInputDialog(null, "Digite o id:");
                int id = Integer.parseInt(aux);
                String nome = JOptionPane.showInputDialog(null, "Digite o nome:");
                String aux2 = JOptionPane.showInputDialog(null, "Digite o valor:");
                int valor = Integer.parseInt(aux2);
                String data = JOptionPane.showInputDialog(null, "Digite a data de pagamento:");
                String situacao = JOptionPane.showInputDialog(null, "Digite a situacao do pagamento:");
                crud.editar(id,nome,valor,data,situacao);
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
