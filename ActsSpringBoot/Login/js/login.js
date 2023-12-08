document.getElementById('forms').addEventListener('submit', function(event) {
    event.preventDefault();

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }, 
        body: JSON.stringify({username, password})
    }).then(response => response.json())
    .then(data => {
        document.getElementById('response').innerHTML = JSON.stringify(data);
        if(data && data.token) {
            localStorage.setItem('token', data.token);
            window.location.href = 'principal.html'
        }
    });
});
