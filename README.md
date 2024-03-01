# Microserviço de Endereço (CompassUOL)
O projeto foi desenvolvido para o desafio 3 do programa de Bolsas da Compass UOL | Back-end Journey (Spring Boot) - AWS Cloud Context. Esse é um microserviço para buscar e guardar informações mais detalhadas do cep de um usuário do microserviço [msuser](https://github.com/kropsz/msuser). Quando alguma rota como a de registro, login e atualização de usuário é chamada no msuser esse microserviço é chamado via OpenFeign e busca no banco de dados o endereço completo, caso não encontre ele utiliza a API do VIACEP para salvar esse novo endereço. A aplicação também possui integração direta para serviços AWS

## Tecnologias Utilizadas
![AWS](https://img.shields.io/badge/aws-%5300f.svg?style=for-the-badge&logo=aws&logoColor=blue)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

### Dependências
Gerenciador de Dependências : Maven

- Spring Boot 3
- Spring Web
- Spring Doc OpenAPI Swagger
- Spring DevTools
- Spring Cloud OpenFeign
- Lombok
- ModelMapper
- Mockito
- JUnit 5
- Banco de dados MySql

## Endpoints

* `GET`  - `/get-address-by-cep/{cep}` - Listar Endereço pelo Cep 

* `RESPONSE`  - Utilizado para retorno de informações de um endereço.
```JSON
{
  "street": "Avenida Luiz Boali Porto Salman",
  "neighborhood": "Centro",
  "complemento": "até 1188 - lado par",
  "city": "Teófilo Otoni",
  "state": "MG",
  "cep": "39802-000"
}

```

# Como executar o projeto
### JDK 17
O projeto foi desenvolvido com a linguagem Java, fazendo uso do Java Development Kit (JDK) versão 17. Assim, para rodar o projeto, é necessário ter o JDK 17 instalado no seu computador. Você pode fazer o download do mesmo através do link fornecido -> [Download Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).

### Escolha a sua IDE:
* VSCode
* IntelliJ
* Spring Tools 4 (Eclipse)
  
### Configurações de Banco de Dados

É necessário  configurar o banco de dados MYSQL:
Navegue até a pasta  `src/main/resources` onde está o arquivo `application.yml` e altere as propriedades:
<div>
<img src="https://github.com/kropsz/compassuol-challenge-e-commerce/assets/114687669/76552929-fd39-4aa1-abe1-f3b381bfe9ee" width="500px" />
</div>

 Substitua as variáveis de ambiente pelos seus dados de acesso ao Banco de Dados: 

*  `url` : Informe o endereço do seu banco de dados MySql.
*  `username`: Informe o nome de usuário do banco de dados MySql.
*  `password`: Informe a senha do seu usuário do banco de dados MySql

## Integração com AWS

![AWS](https://img.shields.io/badge/ec2-%2300f.svg?style=for-the-badge&logo=ec2&logoColor=blue)
![AWS](https://img.shields.io/badge/rds-%1333f.svg?style=for-the-badge&logo=rds&logoColor=blue)
* O microserviço é implantado e executado em instâncias do Amazon EC2 para garantir escalabilidade e flexibilidade.
* Os dados são armazenados de forma segura no Amazon RDS, proporcionando gerenciamento fácil e alto desempenho.

## Configuração

Para configurar a integração com a AWS, siga as instruções abaixo:

1. **EC2 Instances:**
   - Inicie instâncias do Amazon EC2 com a configuração adequada para o seu microserviço.
   - Certifique-se de que as instâncias têm as permissões necessárias para acessar outros serviços da AWS como o RDS.

2. **Amazon RDS:**
   - Configure seu banco de dados utilizando o Amazon RDS. Forneça as informações de conexão necessárias ao seu microserviço
  
      <div>
      <img src="https://github.com/kropsz/msuser/assets/114687669/f456c3f9-2974-41e5-95af-ccac53052e8f" width="500px" />
      </div>


### Conclusão

Esse microseviço representa um componente essencial no ecossistema integrado do projeto. Com foco na busca e armazenamento de informações detalhadas sobre o CEP dos usuários do Microserviço msuser, este microserviço desempenha um papel crucial na garantia da precisão dos dados associados aos perfis dos usuários.
