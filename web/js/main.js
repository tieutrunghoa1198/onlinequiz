/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function isChecked(checkbox) {
    var checkboxs = document.getElementsByName("answer");
    checkboxs.forEach((chk) => {
        if (chk !== checkbox)
            chk.checked = false;
    })
}



