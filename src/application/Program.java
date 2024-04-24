package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import user.Account;

public class Program {
	public static Set<Account> accounts = new HashSet<>();
	static Account contaAtual = null;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		carregarContas();
		int codigo = 0;
		
		while(codigo != 3) {
			if(contaAtual != null) {
				acessarPerfil();
			}
			
			System.out.println("=== MENU ===");
			System.out.println("1 - Criar nova conta");
			System.out.println("2 - Fazer login");
			System.out.println("3 - Sair \n");
			System.out.print("Digite o código: ");
			
			try {
				codigo = sc.nextInt();

				System.out.println("-------------- \n");
				
				switch (codigo) {
				case 1:cadastrar();
					break;
				case 2: login();
					break;
				case 3: break;
	
				default:
					System.out.println("!Código Inválido! \n");
					pause(1000);
					break;
				}
			}catch(InputMismatchException e) {

				System.out.println("!Código Inválido! \n");
				sc.nextLine();
				codigo = 0;
				pause(1000);
			}
		}
		sc.close();
	}
	
	//================================
	// CADASTRO E LOGIN
	
	static void cadastrar() {
		System.out.println("=== CADASTRO ===");
		System.out.println("(digite 'q' a qualquer momento para cancelar) \n");
		
		String nome = null;

		sc.nextLine();
		do {
			System.out.print("Digite seu nome: ");

			nome = sc.nextLine();
			
			if(nome.equals("q")) {
				System.out.println("*Ação cancelada* \n");
				return;
			}
		}while(!Account.nomeValido(nome));
		
		String email = null;
		
		do {
			System.out.print("Informe o e-mail: ");
			email = sc.next();
			
			if(email.equals("q")) {
				System.out.println("*Ação cancelada* \n");
				return;
			}
		}while(!Account.emailValido(email));
		
		String senha = null;
		
		do {
			System.out.print("Crie uma senha: ");
			senha = sc.next();
			
			if(senha.equals("q")) {
				System.out.println("*Ação cancelada* \n");
				return;
			}
		}while(!Account.senhaValida(senha));
		
		accounts.add(new Account(nome, email, senha));
		salvarContas();
		System.out.println("*Conta salva com sucesso* \n");
		pause(1000);
		
	}
	
	//----------------------------------------------
	
	static void login() {
		if(accounts.size() == 0) {
			System.out.println("Você ainda não tem nenhuma conta salva!");
			pause(1000);
			return;
		}
		
		System.out.println("=== LOGIN ===");
		System.out.println("(digite 'q' a qualquer momento para cancelar) \n");
		
		Account conta = null;
		do {
			System.out.print("Informe o e-mail: ");
			
			String email = null;
			email = sc.next();
			
			if(email.equals("q")) {
				System.out.println("*Ação cancelada* \n");
				return;
			}
				
			for(Account a: accounts) {
				if(a.getEmail().equals(email)) {
					conta = a;
				}
			}
			if(conta == null) {
				System.out.println("E-mail incorreto ou inexistente!");
				pause(1000);
			}
		}
		while(conta == null);
		

		System.out.println("Você está entrando na conta de: "+conta.getName());
		String senha = null;
		do {
			System.out.print("Digite a senha: ");
			senha = sc.next();
			if(senha.equals("q")) {
				System.out.println("*Ação cancelada* \n");
				return;
			}
			
		}while(!conta.verificarSenha(senha));
		contaAtual = conta;
		
	}
	//==========================================
	
	static void acessarPerfil() {
		int codigo = 0;
		do {
			System.out.println("\n === PERFIL === \n");
			System.out.println("Olá, "+ contaAtual.getName()+"!");
			System.out.println(contaAtual.getEmail());
			System.out.println("-----------------\n");
			pause(1000);
			System.out.println("1 - Excluir conta");
			System.out.println("2 - Sair da conta \n");
			
			try {
				System.out.print("Digite o código: ");
				codigo = sc.nextInt();
				
				
			}catch(InputMismatchException e) {
	
				System.out.println("!Código Inválido! \n");
				sc.nextLine();
				codigo = 0;
				pause(1000);
			}
			
			if(codigo == 1) {
				excluirContaAtual();
				return;
			}else if(codigo != 2){
				System.out.println("Código Invalido!");
			}
			
		}while(codigo != 2);
	}
	
	//========================================
	// FUNÇÕES ADICIONAIS
	
	public static void pause(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//------------
	
	static void salvarContas() {
		File contas = new File("src\\contas.txt");
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(contas))){
			for(Account a: accounts) {
				bw.write(a.getName()+";"+a.getEmail()+";"+a.getPassword());
				bw.newLine();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//--------------
	
	static void carregarContas() {
		File contas = new File("src\\contas.txt");
		
		try(BufferedReader br = new BufferedReader(new FileReader(contas))){
			String linha = br.readLine();
			while(linha != null) {
				String[] info = linha.split(";");
				accounts.add(new Account(info[0], info[1], info[2]));
				linha = br.readLine();
			}
		}catch(Exception e) {
		}
	}
	
	//--------------------
	
	static void excluirContaAtual() {
		accounts.remove(contaAtual);
		contaAtual = null;
		salvarContas();
		System.out.println("*Conta excluída*");
		System.out.println("----------------- \n");
		pause(1000);
	}
	
	//=====================================

}
