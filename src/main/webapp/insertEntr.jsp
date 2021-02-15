<!DOCTYPE html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">

<html>
<head>
    <title>Insert Data</title>
</head>
<body>

</section>


<!-- Give Servlet reference to the form as an instances
GET and POST services can be according to the problem statement-->
<form action="./insertEntr" method="get">
  <%--  <p>ID:</p>
    <input type="text" name="id"/>
    <br/>--%>

    <p>Type:</p>
    <input type="text" name="type"/>
    <br/>
    <p>Numero:</p>
    <input type="text" name="numero"/>
    <br/><br/><br/>
    <p>Solde:</p>
    <input type="text" name="solde"/>
    <br/><br/><br/>
    <p>Entreprise Nom:</p>
    <input type="text" name="nom"/>
    <br/><br/><br/>

    <input type="submit"/>
</form>


</body>
</html>
