# Cadastro-de-Obras-Spring-Boot 

CRUD de Obras (Publicas ou Privadas) e Responsáveis. Uma obra pode ser associada a vários responsáveis, assim como um responsável pode ser associado a várias obras. <br>

O programa não possui telas gráficas. <br>

Todos as funcionalidades podem ser acessadas através de uma REST API, pelos métodos GET, POST, PUT, DELETE que serão detalhados posteriormente. <br>

Tecnologias utilizadas: <br>
• Java <br>
• Spring Boot com JPA <br>
• MySql <br>
<br>
Requisitos: <br>
• MySql instalado e configurado para que o programa possa criar um database <br>
• Java instalado (Versão utilizada é a 20) <br>
• JDK instalado <br>
<br>
Base da api: http://localhost:8080/ <br>
<br>
Responsáveis:
<table border="1">
    <tr>
        <th>Metodo</th>
        <th>Parametro</th>
        <th>Obs</th>
    </tr>
    <tr>
        <td>GET</td>
        <td>responsavel</td>
        <td>Listar todos os responsáveis cadastrados</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>responsavel</td>
        <td>Cadastra um responsável através do JSON enviado no BODY. O JSON deverá conter um campo "cpf" e um "nome". Exemplo: {"cpf": "326.901.680-81","nome": "Luana"}. Não é necessário informar o código do responsável, o programa criará automaticamente</td>
    </tr>
    <tr>
        <td>DELETE</td>
        <td>responsavel/:id</td>
        <td>Deleta um responsponsável. Exemplo: "http://localhost:8080/responsavel/1" irá deletar o responsável com código 1</td>
    </tr>
</table>
<br>
Obras:
<table border="1">
    <tr>
        <th>Metodo</th>
        <th>Parametro</th>
        <th>Obs</th>
    </tr>
    <tr>
        <td>GET</td>
        <td>obra</td>
        <td>Listar todas as obras cadastradas, Públicas ou Privadas, com seus respectivos responsáveis. Ordenado pelo número</td>
    </tr>
    <tr>
        <td>DELETE</td>
        <td>obra/:id</td>
        <td>Deleta uma obra. Exemplo: "http://localhost:8080/obra/1" irá deletar a obra de número 1</td>
    </tr>
</table>
<br>
Obras Privadas:
<table border="1">
    <tr>
        <th>Metodo</th>
        <th>Parametro</th>
        <th>Obs</th>
    </tr>
    <tr>
        <td>GET</td>
        <td>obraprivada</td>
        <td>Listar todas as obras privadas cadastradas, com seus respectivos responsáveis. Ordenado pelo número</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>obraprivada</td>
        <td>Cadastra uma obra privada através do JSON enviado no BODY. O JSON deverá conter os campos "descricao", "zona" (RURAL ou URBANA) e "areaTotal". Exemplo: {"descricao": "Construção de casinha","zona": "URBANA","areaTotal": 250.0}. Não é necessário informar o numero da obra, o programa criará automaticamente</td>
    </tr>
</table>
