/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



//function isChecked(checkbox) {
//    var checkboxs = document.getElementsByName("answer");
//    checkboxs.forEach((chk) => {
//        if (chk !== checkbox)
//            chk.checked = false;
//    })
//}

const option = document.getElementById('ans_1');
option.addEventListener('input', disableChkBox);

function disableChkBox(e)
{
    if (e.target.value.trim() === '')
    {
        document.getElementById('option_1').disabled = true;
    } else {
        document.getElementById('option_1').disabled = false;
    }
}

const option2 = document.getElementById('ans_2');
option2.addEventListener('input', disableChkBox2);

function disableChkBox2(e)
{
    if (e.target.value.trim() === '')
    {
        document.getElementById('option_2').disabled = true;
    } else {
        document.getElementById('option_2').disabled = false;
    }
}

const option3 = document.getElementById('ans_3');
option3.addEventListener('input', disableChkBox3);

function disableChkBox3(e)
{
    if (e.target.value.trim() === '')
    {
        document.getElementById('option_3').disabled = true;
    } else {
        document.getElementById('option_3').disabled = false;
    }
}

const option4 = document.getElementById('ans_4');
option4.addEventListener('input', disableChkBox4);

function disableChkBox4(e)
{
    if (e.target.value.trim() === '')
    {
        document.getElementById('option_4').disabled = true;
    } else {
        document.getElementById('option_4').disabled = false;
    }
}

