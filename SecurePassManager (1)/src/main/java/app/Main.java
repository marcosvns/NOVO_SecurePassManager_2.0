package app;

import app.service.*;
import app.util.PasswordGenerator;
import java.util.Scanner;

//Permite interagir com o usuário para adicionar, listar e verificar senhas
//executa autenticação 2FA antes de liberar o acesso
public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            AuthService authService = new AuthService();
            PasswordService passwordService = new PasswordService();
            LeakChecker leakChecker = new LeakChecker();

            System.out.println("Configurando 2FA...");
            authService.setup2FA();

            System.out.print("Digite o código do Google Authenticator: ");
            int code = scanner.nextInt();

            if (!authService.validateCode(code)) {
                System.out.println("Código inválido!");
                return;
            }

            while (true) {
                System.out.println("\n1. Adicionar senha\n2. Listar senhas\n3. Gerar senha forte\n4. Verificar vazamento\n5. Sair");
                int opcao = scanner.nextInt(); scanner.nextLine();

                switch (opcao) {
                    //exibe uma lista de opções para o usuário
                    case 1:
                        System.out.print("Serviço: ");
                        String servico = scanner.nextLine();
                        System.out.print("Usuário: ");
                        String usuario = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();
                        
                        if (leakChecker.isPasswordLeaked(senha)) {
                        System.out.println("⚠️ Senha vazada!");
                        System.err.println("\nDeseja continuar com esta senha?: (S/N)");
                        String armazenar = scanner.nextLine().toUpperCase();

                            if (armazenar.equals("S")) {
                                passwordService.addCredential(servico, usuario, senha);
                            } 
                            else {
                                System.err.println("Encerrando o salvamento de senha...");
                                break;
                            }
                        }
                        else {
                            passwordService.addCredential(servico, usuario, senha);
                        }
                        break;
                     
                     // Lista as credenciais armazenadas
                    case 2:
                        passwordService.listCredentials();
                        break;
                    // Gera uma senha forte aleatória de 16 caracteres 
                    case 3:
                        System.out.println("Senha forte: " + PasswordGenerator.generate(16));
                        break;
                    // Verifica se a senha foi vazada    
                    case 4:
                        System.out.print("Senha para verificar: ");
                        String senhaVerificar = scanner.nextLine();
                        boolean vazada = leakChecker.isPasswordLeaked(senhaVerificar);
                        System.out.println(vazada ? "⚠️ Senha vazada!" : "✅ Senha segura.");
                        break;
                    // Encerra o programa    
                    case 5:
                        System.exit(0);
                        break;
                }
            }
        }
    }
}
