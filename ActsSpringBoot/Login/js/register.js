document.getElementById('forms_container').addEventListener('submit', function(event) {
    event.preventDefault();

    let username = document.getElementById('username').value;
    let name = document.getElementById('name').value;
    let password = document.getElementById('password').value;
    let firstname = document.getElementById('firstname').value;
    let lastname = document.getElementById('lastname').value;
    let country = document.getElementById('country').value;


    fetch('http://localhost:8080/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }, 
        body: JSON.stringify({username, name, password, firstname, lastname, country})
    }).then(response => response.json())
    .then(data => {
        document.getElementById('response').innerHTML = JSON.stringify(data);
        if(data && data.token) {
            localStorage.setItem('token', data.token);
            window.location.href = 'principal.html'
        }
    });
});