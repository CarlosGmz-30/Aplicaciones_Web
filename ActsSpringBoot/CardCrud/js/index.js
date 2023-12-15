// Método para registrar
document.getElementById('forms1').addEventListener('submit', function (event) {
    event.preventDefault();
    let cardName = document.getElementById('cardName_post').value;
    let creditLimit = document.getElementById('creditLimit_post').value;
    let cardNumber = document.getElementById('cardNumber_post').value;

    fetch('http://localhost:8080/api/v1/card/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ cardName, creditLimit, cardNumber })

    })

        .then(response => response.json())
        .then(data => {
            document.getElementById('response').innerHTML = JSON.stringify(data);
            alert("Tarjeta registrada exitosamente");

            document.getElementById('cardName_post').value = "";
            document.getElementById('creditLimit_post').value = "";
            document.getElementById('cardNumber_post').value = "";
        })
        .catch(error => {
            console.error('Error:', error);
            alert("Hubo un error al registrar la tarjeta");

        });
})

// Método para actualizar
document.addEventListener("DOMContentLoaded", function () {
    var id = localStorage.getItem("id_card");

    if (id) {
        fetch("http://localhost:8080/api/v1/card/" + id)
            .then(response => {
                if (!response.ok) {
                    throw new Error("!ERROR¡");
                }
                return response.json();
            })
            .then(data => {
                document.getElementById("id_put").value = data.idCard;
                document.getElementById("cardName_put").value = data.nameCard;
                document.getElementById("creditLimit_put").value = data.creditLimit;
                document.getElementById("cardNumber_put").value = data.cardNumber;
            })
            .catch(error => console.error("Fetch error:", error));
    }
});

// Método para actualizar tarjeta
document.getElementById("forms2").addEventListener("submit", function (event) {
    event.preventDefault();

    var idCard = document.getElementById("id_put").value;
    var cardName = document.getElementById("cardName_put").value;
    var creditLimit = document.getElementById("creditLimit_put").value;
    var cardNumber = document.getElementById("cardNumber_put").value;

    fetch("http://localhost:8080/api/v1/card/" + idCard, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ idCard, cardName, creditLimit, cardNumber })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("!ERROR¡");
            }
            return response.json();
        })
        .then(data => {
            console.log("Update successful:", data);
            alert("Tarjeta actualizada exitosamente");
            document.getElementById("id_put").value = "";
            document.getElementById("cardName_put").value = "";
            document.getElementById("creditLimit_put").value = "";
            document.getElementById("cardNumber_put").value = "";
        })
        .catch(error => console.error("Update error:", error));
});



// Método para borrar
document.getElementById('forms3').addEventListener('submit', function (event) {
    event.preventDefault();
    let id = document.getElementById('id_delete').value;

    let url = 'http://localhost:8080/api/v1/card/'
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
    fetch("http://localhost:8080/api/v1/card/")
        .then(function (response) {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(function (data) {
            console.log("Data received:", data);
            var cardTable = document.getElementById("card");
            cardTable.innerHTML = "";
            data.forEach(function (card) {
                console.log("Card:", card);
                cardTable.innerHTML += `
                    <tr>
                        <td>${card.idCard}</td>
                        <td>${card.nameCard}</td>
                        <td>${card.creditLimit}</td>
                        <td>${card.cardNumber}</td>
                    </tr>`;
            });
        })
        .catch(function (error) {
            console.error("Fetch error:", error);
        });
});