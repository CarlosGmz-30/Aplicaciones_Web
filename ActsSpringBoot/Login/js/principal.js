document.getElementById('forms_branch').addEventListener('submit', function(event) {
    event.preventDefault();

    let name = document.getElementById('name').value;
    let address = document.getElementById('address').value;
    let code = document.getElementById('code').value;


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