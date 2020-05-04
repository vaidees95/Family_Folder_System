<?php

$response = array();

if (isset($_POST['ffno']) && isset($_POST['sino']) && isset($_POST['name']) && isset($_POST['relationtohead']) && isset($_POST['dob']) && isset($_POST['gender']) && isset($_POST['maritalstatus']) && isset($_POST['education']) && isset($_POST['wt']) && isset($_POST['hght']) && isset($_POST['bmi']) && isset($_POST['sysbp']) && isset($_POST['diastbp']) && isset($_POST['chronicill']) && isset($_POST['smoking']) && isset($_POST['alcohol']) && isset($_POST['aadhar'])) 
{  
    $ffno = $_POST['ffno'];
    $sino = $_POST['sino'];
    $name=$_POST['name'];
    $relationtohead=$_POST['relationtohead'];
    $dob=$_POST['dob'];
$occupation=$_POST['occupation'];
    $gender=$_POST['gender'];
    $maritalstatus=$_POST['maritalstatus'];
    $education=$_POST['education'];
    $wt=$_POST['wt'];
    $hght=$_POST['hght'];
    $bmi=$_POST['bmi'];
    $sysbp=$_POST['sysbp'];
    $diastbp=$_POST['diastbp'];
    $chronicill=$_POST['chronicill'];
    $smoking=$_POST['smoking'];
    $alcohol=$_POST['alcohol'];
    $aadhar=$_POST['aadhar'];

    require_once __DIR__ . '/db_connect.php';
    $db = new DB_CONNECT();
    $result = mysql_query("Insert into familymember values('$ffno','$sino','$name','$relationtohead','$dob','$occupation','$gender','$maritalstatus','$education','$wt','$hght','$bmi','$sysbp','$diastbp','$chronicill','$smoking','$alcohol','$aadhar')");

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
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
    echo json_encode($response);
 } 
?>