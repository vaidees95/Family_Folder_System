<?php

$response = array();

if(isset($_POST['dos']) && isset($_POST['ffno']) && isset($_POST['emplyno']) && isset($_POST['drno']) && isset($_POST['area']) && isset($_POST['taluk']) && isset($_POST['pincode']) && isset($_POST['lat']) && isset($_POST['long1']) && isset($_POST['nooffmly']) && isset($_POST['fmlyty']) && isset($_POST['relgn']) && isset($_POST['fmlyinc']) && isset($_POST['house']) && isset($_POST['housetyp']) && isset($_POST['watersupply']) && isset($_POST['toilet']) && isset($_POST['infant']) && isset($_POST['under5']) && isset($_POST['adolescent']) && isset($_POST['antenatal']) && isset($_POST['postnatal']) && isset($_POST['geriatric']) && isset($_POST['rice']) && isset($_POST['wheat']) && isset($_POST['sugar']) && isset($_POST['salt']) && isset($_POST['oil']) && isset($_POST['fp']) && isset($_POST['under5imun']) && isset($_POST['rcrdcrtd']) && isset($_POST['crtdby']) && isset($_POST['site'])) 
{
$a=$_POST['dos'];
$b=$_POST['ffno'];
$c=$_POST['emplyno'];
$d=$_POST['drno'];
$e=$_POST['area'];
$f=$_POST['taluk'];
$g=$_POST['pincode'];
$h=$_POST['lat'];
$i=$_POST['long1'];
$j=$_POST['nooffmly'];
$k=$_POST['fmlyty'];
$l=$_POST['relgn'];
$m=$_POST['fmlyinc'];
$n=$_POST['house'];
$o=$_POST['housetyp'];
$p=$_POST['watersupply'];
$q=$_POST['toilet'];
$r=$_POST['infant'];
$s=$_POST['under5'];
$t=$_POST['adolescent'];
$u=$_POST['antenatal'];
$v=$_POST['postnatal'];
$w=$_POST['geriatric'];
$x=$_POST['rice'];
$y=$_POST['wheat'];
$z=$_POST['sugar'];
$aa=$_POST['salt'];
$bb=$_POST['oil'];
$cc=$_POST['fp'];
$dd=$_POST['under5imun'];
$ee=$_POST['rcrdcrtd'];
$ff=$_POST['crtdby']; 
$gg=$_POST['site'];
$hh=$_POST['dist'];
	
    require_once __DIR__ . '/db_connect.php';
    $db = new DB_CONNECT();
    $result = mysql_query("Insert into familydetails values('$a','$b','$c','$d','$e','$hh','$f','$g','$h','$i','$j','$k','$l','$m','$n','$o','$p','$q','$r','$s','$t','$u','$v','$w','$x','$y','$z','$aa','$bb','$cc','$dd','$ee','$ff','$gg')");

    if ($result)
	{
        $response["success"] = 1;
        $response["message"] = "Registration successfully.";
        echo json_encode($response);
    }
	else
	{
      $response["success"] = 0;
      $response["message"] = "Oops! An error occurred.";
      echo json_encode($response);  
    }
}
else
{
echo "failure";
}  
?>