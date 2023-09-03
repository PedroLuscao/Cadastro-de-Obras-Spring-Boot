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
Responsáveis: <br>

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
        <td>Cadastra um responsável através do JSON enviado no BODY. O JSON deverá conter um campo "cpf" e um "nome". Exemplo: {"cpf": "326.901.680-81","nome": "Luana"}</td>
    </tr>
</table>
