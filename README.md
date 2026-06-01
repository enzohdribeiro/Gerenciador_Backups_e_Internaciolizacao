# Gerenciador de Backups com Internacionalização (I18N)

Este projeto simula de forma simplificada um sistema utilitário de infraestrutura corporativa para automação de rotinas de backup e movimentação de logs, utilizando NIO e ResourceBundle para internaciolização.
## Tecnologias e Ferramentas Aplicadas

* **Java OpenJDK**
* **Java NIO.2:** Manipulação moderna de sistemas de arquivos usando as classes `Path`, `Paths` e `Files`.
* **Java IO Clássico:** Fluxos de escrita otimizados com `BufferedWriter` e `FileWriter`.
* **API `java.time`:** Gerenciamento temporal usando `LocalDate` para rotacionamento de arquivos.
* **Internacionalização (I18N):** Mecanismo de localização de mensagens através de `ResourceBundle` e `Locale`.

---

## Conceitos e Conhecimentos Demonstrados

### Internacionalização Dinâmica (I18N)
O sistema adapta toda a sua interface de console e escrita de relatórios com base na região do sistema operacional configurada pelo `Locale.getDefault()`. Utiliza a infraestrutura de arquivos `.properties` independentes (`messages_pt_BR` e `messages_en_US`) gerenciados via `ResourceBundle`.

### Manipulação Estrutural com NIO.2
Substituição das antigas operações baseadas na classe `File` pela API NIO.2, garantindo operações atômicas e tratamento robusto do sistema de arquivos:
* Criação automatizada e idempotente de diretórios com `Files.createDirectories()`.
* Escrita simplificada e segura com `Files.writeString()`.
* Movimentação de arquivos entre volumes de armazenamento combinada com renomeação temporal dinâmica.

### Ciclo de Vida e Separação de Serviços
Divisão clara de responsabilidades no pacote `service`:
* `MainService`: Simula o ecossistema da aplicação gerando dados brutos de operação.
* `BackupService`: Atua como um microsserviço isolado e utilitário, responsável pela governança, expurgo e registro dos backups.
