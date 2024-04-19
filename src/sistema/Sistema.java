package sistema;

import java.util.Scanner;
import service.HandleMenu;
import service.HandleMenuProduto;

public class Sistema {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HandleMenu hm = new HandleMenu();
        HandleMenuProduto hmp = new HandleMenuProduto();
        int menuPrincipal = 0;
        int Usuario = 0;
        int Produto = 0;

        do {
            System.out.println(
                    "1 - Sistema de Usuarios\n2 - Sistema de Produtos\n3 - Sair\n");
            menuPrincipal = sc.nextInt();
            switch (menuPrincipal) {
                case 1: {
                    do {
                        System.out.println("Sistema de Usuarios");
                        System.out.println(
                                "1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n5 - Listar Especifico \n6 - Login\n7 - Voltar ao Menu Principal");
                        Usuario = sc.nextInt();

                        switch (Usuario) {
                            case 1: {
                                hm.criar();
                                break;
                            }
                            case 2: {
                                hm.editar();
                                break;
                            }
                            case 3: {
                                hm.deletar();
                                break;
                            }
                            case 4: {
                                hm.listar();
                                break;
                            }
                            case 5: {
                                hm.listarEspecifico();
                                break;
                            }
                            case 6: {
                                hm.login();
                                break;
                            }
                            case 7:{
                            	continue;
                            }
                            default:
                                break;
                        }
                    } while (Usuario != 7);
                    break; 
                }
                case 2: {
                    do {
                        System.out.println("Sistema de Produtos");
                        System.out.println("1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n5 - Listar Especifico\n6 - Voltar ao Menu Principal");
                        Produto = sc.nextInt();

                        switch (Produto) {
                            case 1: {
                                hmp.criarProduto();
                                break;
                            }
                            case 2: {
                                hmp.editarProduto();
                                break;
                            }
                            case 3: {
                                hmp.deletarProduto();
                                break;
                            }
                            case 4: {
                                hmp.listarProduto();
                                break;
                            }
                            case 5: {
                                hmp.listarEspecificoProduto();
                                break;
                            }
                            case 6:{
                            	continue;
                            }
                            default:
                                break;
                        }
                    } while (Produto != 6); 
                    break;
                    
                    
                }
                case 3:{
                	System.exit(0);
                }
                default:
                    break;
            }
        } while (menuPrincipal != 3); 
        sc.close();
    }
}
