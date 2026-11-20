# EL MAESTRO

Perfumaria masculina de luxo. Nova versão construída em Java 21 + Spring Boot, Thymeleaf e MariaDB (XAMPP).

## Requisitos
- JDK 21
- Maven 3.9+
- XAMPP com MariaDB ativo

## Configuração local
1. Inicie o MySQL/MariaDB pelo painel do XAMPP.
2. Crie o banco `el_maestro` no phpMyAdmin.
3. Copie `.env.example` para `.env` (ou configure as variáveis no terminal).
4. Execute `mvn spring-boot:run`.
5. Acesse http://localhost:8080.

O checkout e pagamentos reais precisam de integração com um provedor, validação no servidor e configuração de produção antes de aceitar pedidos reais.
