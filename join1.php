<?php

$response = array();
if(1)
{
    require_once __DIR__ . '/db_connect.php';
    $db = new DB_CONNECT();


$sql = mysql_query("truncate table health1");
$sql = mysql_query("SELECT * FROM familydetails INNER JOIN familymember ON familydetails.family_folder_no=familymember.family_folder_no INNER JOIN uid ON familymember.family_folder_no=uid.family_folder_no  ORDER BY uid.uid");
  
$num_rows = mysql_num_rows($sql);

if(! $sql )
{
 die('Could not get data: ' . mysql_error());
}
$str=999;
while($row = mysql_fetch_assoc($sql))
{

$a=$row['family_folder_no'];
$b=$row['date_of_survey'];
$c=$row['employee_no'];
$d=$row['door_no'];
$e=$row['area'];
$f=$row['dist'];
$g=$row['taluk'];
$h=$row['pincode'];
$i=$row['latitude'];
$j=$row['longitude'];
$k=$row['total_no_family'];
$l=$row['family_type'];
$m=$row['religion'];
$n=$row['family_inc'];
$o=$row['house'];
$p=$row['house_type'];
$q=$row['source_of_water'];
$r=$row['type_of_toilet'];
$s=$row['infant'];
$t=$row['under5'];
$u=$row['adolescent'];
$v=$row['antenatal'];
$w=$row['postnatal'];
$x=$row['geriatric'];
$y=$row['rice'];
$z=$row['wheat'];
$aa=$row['sugar'];
$bb=$row['salt'];
$cc=$row['oil'];
$dd=$row['family_planing'];
$ee=$row['under5_immunization'];
$ff=$row['rcrd_crct_dt'];
$gg=$row['created_by'];
$hh=$row['site_clinic'];



$ii=$row['sl_no'];
$jj=$row['name'];
$kk=$row['relation_to_head'];
$ll=$row['date_of_birth'];
$mm=$row['occupation'];

$oo=$row['gender'];
$pp=$row['marital_status'];
$qq=$row['education'];
$rr=$row['weight'];
$ss=$row['height'];
$tt=$row['bmi'];
$uu=$row['sys_bp'];
$vv=$row['diast_bp'];
$ww=$row['chronic_illness'];
$xx=$row['smoking'];
$yy=$row['alcohol'];
$zz=$row['aadhar_no'];


$aaa=$row['uid'];
if($str==$a)
{


  $result = mysql_query("Insert into health1 values('$a','$b','$c','$d','$e','$f','$g','$h','$i','$j','$k','$l','$m','$n','$o','$p','$q','$r','$s','$t','$u','$v','$w','$x','$y','$z','$aa','$bb','$cc','$dd','$ee','$ff','$gg','$hh','$ii','$jj','$kk','$ll','$mm','$oo','$pp','$qq','$rr','$ss','$tt','$uu','$vv','$ww','$xx','$yy','$zz','$aaa')");
}
else
{

$result = mysql_query("Insert into health1 values('$a','$b','$c','$d','$e','$f','$g','$h','$i','$j','$k','$l','$m','$n','$o','$p','$q','$r','$s','$t','$u','$v','$w','$x','$y','$z','$aa','$bb','$cc','$dd','$ee','$ff','$gg','$hh','$ii','$jj','$kk','$ll','$mm','$oo','$pp','$qq','$rr','$ss','$tt','$uu','$vv','$ww','$xx','$yy','$zz','$aaa')");

$str=$a;
}















    echo "{$row['family_folder_no']}".
       "{$row['dist']} <br> ".
         
     "{$row['taluk']} <br> ".
	
         "{$row['pincode']} <br> ".
         
         "--------------------------------<br>";







}
echo "Fetched data successfully\n";
}
?>
   