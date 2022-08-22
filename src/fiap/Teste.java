/* Daniel Henrique Alcantara Oliveira Martins  RM: 94615
* Luís Felipe Garcia Menezes  RM: 94051
* Pedro Victor Saraiva de Sá  RM: 93627
*/

package fiap;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {
		String escolha = "sim";
		int opcao;

		while (escolha.equalsIgnoreCase("sim")) {
			try {
				opcao = Integer.parseInt(
						JOptionPane.showInputDialog("Escolha: \n(1) Código \n(2) Título \n(3) Gênero \n(4) Produtora"));
				switch (opcao) {
				case 1:
					modificaCodigo();
					listaCodigo();
					break;
				case 2:
					modificaTitulo();
					listaTitulo();
					break;
				case 3:
					modificaGenero();
					listaGenero();
					break;
				case 4:
					modificaProdutora();
					modificaProdutora();
					break;
				default:
					System.out.println("Escolha incorreta de classe!");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar? (sim ou não)");
		}	

	}
}
