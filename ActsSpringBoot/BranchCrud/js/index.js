// Método para registrar
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

// Método para actualizar
document.addEventListener("DOMContentLoaded", function () {
    var id = localStorage.getItem("id_branch");

    if (id) {
        fetch("http://localhost:8080/api/v1/branch/" + id)
            .then(response => {
                if (!response.ok) {
                    throw new Error("!ERROR¡");
                }
                return response.json();
            })
            .then(data => {
                document.getElementById("id_put").value = data.id_branch;
                document.getElementById("name_put").value = data.name;
                document.getElementById("address_put").value = data.address;
                document.getElementById("code_put").value = data.code;
            })
            .catch(error => console.error("Fetch error:", error));
    }
});

// Método para actualizar
document.getElementById("forms2").addEventListener("submit", function (event) {
    event.preventDefault();

    var id_branch = document.getElementById("id_put").value;
    var name = document.getElementById("name_put").value;
    var address = document.getElementById("address_put").value;
    var code = document.getElementById("code_put").value;

    fetch("http://localhost:8080/api/v1/branch/" + id_branch, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ id_branch, name, address, code })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("!ERROR¡");
            }
            return response.json();
        })
        .then(data => {
            console.log("Update successful:", data);
            alert("Usuario actualizado exitosamente");
            document.getElementById("id_put").value = "";
            document.getElementById("name_put").value = "";
            document.getElementById("address_put").value = "";
            document.getElementById("code_put").value = "";
        })
        .catch(error => console.error("Update error:", error));
});



// Método para borrar
document.getElementById('forms3').addEventListener('submit', function (event) {
    event.preventDefault();
    let id = document.getElementById('id_delete').value;

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
            document.getElementById('id_delete').value = "";

        })

})


// Método para obtener
document.addEventListener("DOMContentLoaded", function () {
    fetch("http://localhost:8080/api/v1/branch/")
        .then(function (response) {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(function (data) {
            console.log("Data received:", data);
            var branchTable = document.getElementById("branch");
            branchTable.innerHTML = "";
            data.forEach(function (branch) {
                console.log("Branch:", branch);
                branchTable.innerHTML += `
                    <tr>
                        <td>${branch.id_branch}</td>
                        <td>${branch.name}</td>
                        <td>${branch.address}</td>
                        <td>${branch.code}</td>
                    </tr>`;
            });
        })
        .catch(function (error) {
            console.error("Fetch error:", error);
        });
});