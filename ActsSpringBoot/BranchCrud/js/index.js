document.getElementById('forms').addEventListener('submit', function (event) {
    event.preventDefault();
    let name = document.getElementById('name').value;
    let address = document.getElementById('address').value;
    let code = document.getElementById('code').value;

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

            document.getElementById('name').value = "";
            document.getElementById('address').value = "";
            document.getElementById('code').value = "";
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Hubo un error al crear el usuario");

        });
})


document.getElementById('forms2').addEventListener('submit', function (event) {
    event.preventDefault();
    let id = document.getElementById('id').value;
    let name = document.getElementById('name').value;
    let address = document.getElementById('address').value;
    let code = document.getElementById('code').value;

    fetch(`http://localhost:8080/api/v1/branch/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name, address, code })
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('response').innerHTML = JSON.stringify(data);
            alert("Usuario actualizado exitosamente");

            document.getElementById('id').value = "";
            document.getElementById('name').value = "";
            document.getElementById('address').value = "";
            document.getElementById('code').value = "";
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Hubo un error al actualizar el usuario");
            document.getElementById('id').value = "";
            document.getElementById('name').value = "";
            document.getElementById('address').value = "";
            document.getElementById('code').value = "";
        });
});


document.getElementById('borrar').addEventListener('submit', function (event) {
    event.preventDefault();
    let id = document.getElementById('id_borrar').value;

    let url = 'http://localhost:8080/api/v1/branch/'
    let url1 = url + id;
    console.log(url1);
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

})