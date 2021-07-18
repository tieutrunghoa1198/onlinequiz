/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function validateForm()
{
    var a = document.forms["form"]["ans_1"].value;
    var b = document.forms["form"]["ans_2"].value;
    var c = document.forms["form"]["ans_3"].value;
    var d = document.forms["form"]["ans_4"].value;
    
    if (a === null || a === "", b === null || b === "", c === null || c === "", d === null || d === "")
    {
        alert("Please Fill In All Required Fields");
        console.log("check validate " + a);
        return false;
    }
}
