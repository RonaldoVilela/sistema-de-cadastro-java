package user;


import application.Program;

public class Account{
	
	private String name;
	private String email;
	private String password;
	
	
	public Account() {}
	public Account(String name, String email, String pasword) {
		this.name = name;
		this.email = email;
		this.password = pasword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPasword(String pasword) {
		this.password = pasword;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static boolean nomeValido(String nome) {
		if(nome.contains(";") || nome.contains(":") || nome.contains("!") || nome.contains("?")) {
			System.out.println("!No nome, não é permitido o uso de caracteres especiais como: [;:!?]!");
			Program.pause(1000);
			return false;
		}
		return true;
	}
	
	public static boolean emailValido(String email) {
		if(email.contains(" ") || email.contains(";")) {
			System.out.println("\"E-mail invalido!\"");
			Program.pause(1000);
			return false;
		}
		if(!email.contains("@")) {
			System.out.println("E-mail invalido!");
			Program.pause(1000);
			return false;
		}
		
		try {
			String end = email.split("@")[1];
			
			if(end.substring(0,end.lastIndexOf(".")).length() < 1) {
				System.out.println("E-mail invalido!");
				Program.pause(1000);
				return false;
			}
			if(end.substring(end.lastIndexOf("."), end.length() - 1).length() < 3) {
				System.out.println("E-mail invalido!");
				Program.pause(1000);
				return false;
			}
		}catch(Exception e) {
			System.out.println("E-mail invalido!");
			Program.pause(1000);
			return false;
		}
		
		for(Account a: Program.accounts) {
			if(a.getEmail().equals(email)) {
				System.out.println("E-mail já existente!");
				Program.pause(1000);
				return false;
			}
		}
		return true;
	}
	
	public static boolean senhaValida(String senha) {
		if(senha.contains(" ") || senha.contains(";") || senha.contains(".") || senha.contains(":")) {
			System.out.println("!Na senha, não é permitido o uso de espaço ou caracteres especiais como: [;:.]!");
			Program.pause(1000);
			return false;
		}
		if(senha.length() < 4) {
			System.out.println("A senha deve ter pelo menos 4 caracteres!");
			Program.pause(1000);
			return false;
		}
		return true;
	}
	
	
	public boolean verificarSenha(String senha) {
		if(password.equals(senha)) {
			return true;
		}
		System.out.println("Senha Incorreta!");
		Program.pause(1000);
		return false;
	}
}
