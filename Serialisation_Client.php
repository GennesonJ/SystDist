<?php

$montant =  10;
$clientSoap = new SoapClient("http://localhost:8989/?wsdl");

$param= new stdClass();

$param->mt=$montant;

$resultat = $clientSoap->__soapCall("convertir", array($param));

?>

<html>
<title> php Client </title>

<body>
<form action="phpClient.php" method="get">
    <input type="text" name="mt">

    <button> Convertir</button>

</form>
<?php

echo "Le résultat renvoyé par le service est $resultat->return";

$functions = $clientSoap->__getFunctions ();
var_dump ($functions);



?>

</body>

</html>