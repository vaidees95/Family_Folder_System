<?php

$response = array();
//if (isset($_POST['uid']))
if(1)
{
//$uid="12345678";
 $uid = $_POST['uid'];
$fld=$_POST['fld'];
    require_once __DIR__ . '/db_connect.php';
    $db = new DB_CONNECT();
    $result = mysql_query("Insert into uid values('$fld','$uid')");
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
   