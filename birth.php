<?php

$response = array();
if(1)
{

$a=$_POST['spinner1'];
$b=$_POST['spinner2'];
$a="coimbatore";
$b="mettupalayam";
	
    require_once __DIR__ . '/db_connect.php';
    $db = new DB_CONNECT();
$student = mysql_query("select date_of_birth from health1 where dist='$a' AND  taluk='$b'"); 
$eighteen=$fifty=$sixty=0;
while($row = mysql_fetch_assoc($student))
{ 
$product=array();
       $dob = $row['date_of_birth'];

$date1=date_create("2013-03-15");
$date2=date("y/m/d");
$age=floor((strtotime(date('d-m-Y')) - strtotime($dob))/(60*60*24*365.2421896));
 echo $age;
echo "\n";
if($age<18)
{
$eighteen++;
}
if($age<50&$age>18)
{
$fifty++;
}
if($age>60)
{
$sixty++;
}

}

$product["eightee"]=10;
$product["fifty"]=20;
$product["sixty"]=30;
        $response["success"] = 1;
        $response["message"] = "Registration successfully.";
echo json_encode($product);
        echo json_encode($response);
    }
	else
	{
      $response["success"] = 0;
      $response["message"] = "Oops! An error occurred.";
      echo json_encode($response);  
    }

?>