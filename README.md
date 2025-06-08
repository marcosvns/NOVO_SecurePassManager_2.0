# 🔐 SecurePassManager

> Um gerenciador de senhas seguro feito em **Java puro**, com **criptografia AES**, **autenticação 2FA**, **geração de senhas fortes** e **verificação contra vazamentos** — tudo **sem banco de dados**.

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange.svg" alt="Java">
  <img src="https://img.shields.io/badge/Maven-3.6+-blue.svg" alt="Maven">
  <img src="https://img.shields.io/badge/Storage-InMemory-red.svg" alt="In-Memory Storage">
  <img src="https://img.shields.io/badge/2FA-TOTP-blueviolet.svg" alt="2FA">
  <img src="https://img.shields.io/badge/API-HaveIBeenPwned-yellow.svg" alt="HIBP">
</p>

---

## ✨ Funcionalidades

- ✅ Armazenamento seguro com criptografia **AES**
- ✅ Autenticação em duas etapas (**2FA**) via **TOTP**
- ✅ Geração de **senhas aleatórias fortes**
- ✅ Verificação de senhas com a API do **HaveIBeenPwned**
- ✅ Interface de linha de comando simples e intuitiva
- ✅ Código testado com **JUnit 5**

---

## 🚀 Como Executar

### ⚙️ Pré-requisitos

- Java 17+
- Maven 3.6+

### 📦 Compilação

```bash
mvn clean install
````
### ▶️ Execução

```bash
mmvn exec:java -Dexec.mainClass="app.Main"
````
```bash
mvn test
````
---

## 📁 Estrutura do Projeto

```bash
SecurePassManager/
├── src/
│   ├── main/
│   │   └── java/app/
│   │       ├── model/         # Classe Credential
│   │       ├── service/       # Serviços de autenticação, criptografia, etc
│   │       ├── util/          # Gerador de senha segura
│   │       └── Main.java      # Classe principal com CLI
│   └── test/
│       └── java/app/          # Testes unitários (JUnit 5)
├── pom.xml                    # Configuração do Maven
└── README.md                  # Este arquivo
````
---

## ❓ Observações Importantes

-Todas as senhas são armazenadas apenas em memória RAM durante a execução, nada é salvo em disco.

-O código é 100% Java [sem frameworks web ou banco de dados]

---

## 📝 Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

## 📧 Contato

Marcos Vinícius: marcosvn0803@gmail.com
