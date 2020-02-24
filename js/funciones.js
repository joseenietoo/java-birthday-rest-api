function consultar() {
    var f=document.formulario;
    var nombreCompleto = f.name.value
    var fechaNacimiento = f.birthday.value
    var url = "http://localhost:8080/persona?nombreCompleto="+nombreCompleto+"&fechaNacimiento="+fechaNacimiento;
    myWindow = window.open(url, '', 'width=1000,height=1000,scrollbars=1');
    myWindow.focus();
}
