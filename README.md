# EL MAESTRO

**Perfumaria masculina de luxo** — aplicação web em Java, com identidade visual premium em preto, bege e dourado.

## Tecnologias

- Java 21
- Spring Boot 3.5
- Maven
- Thymeleaf, HTML, CSS e JavaScript
- MariaDB pelo XAMPP
- Spring Security e BCrypt para autenticação e hash de senhas

## Requisitos

- JDK 21 instalado e disponível no PATH
- Maven 3.9 ou superior
- Git
- XAMPP com MariaDB iniciado

## Preparar o banco de dados (XAMPP)

1. Abra o painel do XAMPP e inicie **MySQL** (MariaDB).
2. Acesse http://localhost/phpmyadmin.
3. Crie um banco chamado `el_maestro`, com codificação `utf8mb4`.
4. Por padrão, a configuração local usa `localhost:3306`, usuário `root` e senha vazia. Se sua instalação tiver outra senha, configure as variáveis abaixo.

## Configuração

A aplicação lê estas variáveis de ambiente:

| Variável | Padrão local |
|---|---|
| `DB_URL` | `jdbc:mariadb://localhost:3306/el_maestro` |
| `DB_USERNAME` | `root` |
| `DB_PASSWORD` | vazio |
| `SERVER_PORT` | `8080` |

Nunca envie senhas, tokens ou outros segredos para o GitHub. O arquivo `.env` é ignorado pelo Git; `.env.example` contém apenas valores de exemplo.

## Executar no Windows

No PowerShell, dentro da pasta do projeto:

```powershell
java -version
mvn -version
mvn spring-boot:run
```

Depois abra http://localhost:8080.

## Funcionalidades e estado do projeto

- [x] Base Java + Spring Boot
- [x] Catálogo inicial com 30 fragrâncias masculinas
- [x] Preço e estoque iniciais de R$ 250,00 e 30 unidades
- [x] Página inicial e páginas individuais de produto
- [x] Cadastro e login com senha armazenada usando BCrypt
- [x] Restrição inicial de rotas administrativas
- [x] Estrutura inicial do painel de produtos
- [ ] Carrinho persistente e validação de estoque no servidor
- [ ] Pedidos, endereços e cálculo de frete
- [ ] Integração real de pagamentos Pix e cartão
- [ ] Gestão completa de clientes e pedidos
- [ ] Testes automatizados e validação de implantação

**Atenção:** a aplicação ainda está em desenvolvimento. O checkout não processa pedidos nem pagamentos reais. Não use em produção antes de implementar e testar as etapas pendentes, configurar HTTPS, credenciais seguras, backups e políticas de privacidade.

## Licença

Este projeto está licenciado sob a **Apache License 2.0**. Consulte o arquivo [LICENSE](LICENSE).
