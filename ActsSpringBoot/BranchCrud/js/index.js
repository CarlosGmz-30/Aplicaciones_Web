document.getElementById('forms1').addEventListener('submit', function (event) {
    event.preventDefault();
    let name = document.getElementById('name_post').value;
    let address = document.getElementById('address_post').value;
    let code = document.getElementById('code_post').value;

    fetch('http://localhost:8080/api/v1/branch/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name, address, code })

    })

        .then(response => response.json())
        .then(data => {
            document.getElementById('response').innerHTML = JSON.stringify(data);
            alert("Usuario creado exitosamente");

            document.getElementById('name_post').value = "";
            document.getElementById('address_post').value = "";
            document.getElementById('code_post').value = "";
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Hubo un error al crear el usuario");

        });
})


document.getElementById('forms2').addEventListener('submit', function (event) {
    event.preventDefault();
    let id_branch = document.getElementById('id_put').value;
    let name = document.getElementById('name_put').value;
    let address = document.getElementById('address_put').value;
    let code = document.getElementById('code_put').value;

    let url = 'http://localhost:8080/api/v1/branch/'
    let url1 = url + id_branch;
    fetch(url1, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id_branch, address, code, name })
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('response').innerHTML = JSON.stringify(data);
            alert("Usuario actualizado exitosamente");

            document.getElementById('id_put').value = "";
            document.getElementById('name_put').value = "";
            document.getElementById('address_put').value = "";
            document.getElementById('code_put').value = "";
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Hubo un error al actualizar el usuario");
            document.getElementById('id_put').value = "";
            document.getElementById('name_put').value = "";
            document.getElementById('address_put').value = "";
            document.getElementById('code_put').value = "";
        });
});

/*
document.getElementById('borrar').addEventListener('submit', function (event) {
    event.preventDefault();
    let id = document.getElementById('id_borrar').value;

    let url = 'http://localhost:8080/api/v1/branch/'
    let url1 = url + id;
    fetch(url1, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }

    })
        .then(data => {
            document.getElementById('response').innerHTML = JSON.stringify(data);
            alert("Usuario borrado exitosamente");
        })

})*/