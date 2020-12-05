try {
    var selects = document.getElementsByTagName("select")
    for (let i=0; i<selects.length; i++){
        selects[i].classList.add("form-control");
    }
}
catch (e) {
}

try {
    var labels = document.getElementsByTagName("label")
    for (let i=0; i<labels.length; i++){
        labels[i].classList.add("text-left");
    }
}
catch (e) {

}

try{

    var inpust = document.getElementsByTagName("input")
    for (let i=0; i<inpust.length; i++){
        inpust[i].classList.add("form-control");
    }
}
catch (e) {

}