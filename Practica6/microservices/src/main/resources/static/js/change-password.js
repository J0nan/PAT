document.addEventListener("DOMContentLoaded", function(event) {

    tokenVerification();

    var form = document.getElementById("myform");
    form.addEventListener("submit", function(e) {
        e.preventDefault();
        return sendForm();
    });
});

function tokenVerification() {

    if (typeof Cookies.get('token') === 'undefined') {
        console.log("Cookie not detected");
        console.log(Cookies.get('token'));
        document.location.href="index.html";
    }
    console.log("Cookie detected");
}

function sendForm() {
    try {
        var inputValue1 = document.getElementById("current_password").value;
        var inputValue2 = document.getElementById("new_password1").value;
        var inputValue3 = document.getElementById("new_password2").value;
        const data = { currentPassword: inputValue1, newPassword: inputValue2, newPassword2: inputValue3 };
        const address = '/api/users/update-password';
        fetch(address, {
            method: 'POST',
            headers: {
                'Authorization': 'Bearer '+Cookies.get('token'),
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
            })
            .then(response => {
                if (response.ok) {
                    alert("Contraseña cambiada")
                    document.location.href="/home.html";
                } else if(response.status==401){ //Unauthorized
                    alert("Contraseña erronea");
                    document.getElementById("current_password").style="border: 3px solid red"
                    document.getElementById("new_password1").style="border: 1px solid black"
                    document.getElementById("new_password2").style="border: 1px solid black"
                } else if(response.status==400){ //BAD_REQUEST
                    alert("Contraseñas no coinciden")
                    document.getElementById("current_password").style="border: 1px solid black"
                    document.getElementById("new_password1").style="border: 3px solid red"
                    document.getElementById("new_password2").style="border: 3px solid red"
                }
            });

    } catch (err) {
        console.error(err.message);
    }
    return false;
}