package main;

import java.util.Scanner;

import DAO.produtoDAO;
import DAO.usuarioDAO;
import entity.Produto;
import entity.usuario;

public class Main {
    
    public static void main (String[] args) {

        Scanner ler = new Scanner(System.in);
        usuario pessoa = new usuario();
        Produto produto = new Produto();
        usuarioDAO usuario = new usuarioDAO();
        produtoDAO produtoDAO = new DAO.produtoDAO();
        int menu=99;

        System.out.println("[1] Usuário\n[2] Produto\nInforme a opção desejada: ");
        menu = ler.nextInt();

        switch (menu) {
            
            case 1:
                int opcao_usuario = 3;

                System.out.print("[1] Cadastrar usuario\n[2] Consultar usuario\n[3] Editar usuário\nInforme a opção desejada: ");
                opcao_usuario = ler.nextInt();

                if (opcao_usuario == 1) {
                    
                    System.out.print("Informe o cpf do usuário: ");
                    pessoa.setCpf(ler.next());

                    System.out.print("Informe o nome do usuário: ");
                    pessoa.setNome(ler.next());

                    System.out.print("Informe o email do usuário: ");
                    pessoa.setEmail(ler.next());

                    System.out.print("Informe a senha do usuário: ");
                    pessoa.setSenha(ler.next());

                    usuario.cadastrar_usuario(pessoa);
                
                }  else if (opcao_usuario == 2) {
                    System.out.println("Consultando usuário");
                    System.out.print("Informe o CPF no formato '000.000.000-00': ");
                    pessoa.setCpf(ler.next());

                    usuario.consultar_usuario(pessoa);

                    System.out.print("\n\nCPF: " + pessoa.getCpf()
                                + "\nNome: " + pessoa.getNome()
                                + "\nEmail: " + pessoa.getEmail()
                                + "\nSenha: " + pessoa.getSenha());
                }
                else if(opcao_usuario == 3){
                    pessoa = new usuario();
                    System.out.println("Editanto usuário");
                    System.out.print("Informe o CPF no formato '000.000.000-00': ");
                    pessoa.setCpf(ler.next());
                    usuario.consultar_usuario(pessoa);
                    if(pessoa.getNome().equals(null)){
                        System.out.println("Algum problema aconteceu ...");
                    }else{
                        System.out.println("Nome atual é:"+pessoa.getNome());
                        System.out.println("Quer editar o nome? [s/n]");
                        ler.nextLine();
                        String op = ler.nextLine();
                        if(op.equals("S")||op.equals("s")){                           
                            System.out.print("Novo nome: ");
                            pessoa.setNome(ler.nextLine());
                        }
                        
                        System.out.println("Email atual é:"+pessoa.getEmail());
                        System.out.println("Quer editar o email? [s/n]");
                        op = ler.nextLine();
                        if(op.equals("S")||op.equals("s")){
                            
                            System.out.print("Novo email: ");
                            pessoa.setEmail(ler.next());
                        }
                        ler.nextLine();
                        System.out.println("Senha atual é:"+pessoa.getSenhaEncrypted());
                        System.out.println("Quer editar a senha? [s/n]");
                        op = ler.nextLine();
                        if(op.equals("S")||op.equals("s")){
                            
                            System.out.print("Nova senha: ");
                            pessoa.setSenha(ler.nextLine());
                        }
                        usuario.editarUsuario(pessoa);
                    }

                }
                break;

            case 2:

                int opcao_produto = 3;

                System.out.print("[1] Cadastrar produto\n[2] Consultar produto\nInforme a opção desejada: ");
                opcao_produto = ler.nextInt();

                if (opcao_produto == 1) {
                    ler.nextLine();
                    System.out.print("Informe a decrição do produto: ");
                    produto.setDescricao(ler.nextLine());

                    System.out.print("Informe valor do produto: ");
                    produto.setValor(ler.nextDouble());

                    produtoDAO.cadastrar_produto(produto);
                } else if (opcao_produto == 2) {
                    System.out.print("Informe o código do produto: ");
                    produto.setCodigo(ler.nextInt());

                    produtoDAO.consultar_produto(produto);

                    System.out.print("\n\nCódigo: " + produto.getCodigo()
                                + "\nDescrição: " + produto.getDescricao()
                                + "\nValor: R$" + produto.getValor());
                }
                break;

        }
        
        ler.close();
    }
}
