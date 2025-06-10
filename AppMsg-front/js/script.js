document.getElementById('form').addEventListener('submit', async function (e) {
    e.preventDefault()

    console.log("Passei do default")
    const name = document.getElementById('desc').value

    const desc = { name }

    try {
        const resposta = await fetch('http://localhost:8080/help', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(desc)
        })

        if(resposta.ok){
            alert('Enviado')
        }
        else{
            alert('Erro ao enviar')
        } 
        
    }
    catch(erro){
        console.error('Erro', erro)
        alert("Erro de rede")
    }

})

document.getElementById('formget').addEventListener('submit', async function (e) {
    e.preventDefault()

    console.log("Passei do default")
    const name = document.getElementById('desc').value

    const desc = { name }

    try {
        
        const resposta = await fetch('http://localhost:8080/help')
        const problems = await resposta.json()

        const ul = document.getElementById('problems')

        problems.forEach(problem => {
            const problemli = document.createElement('li')
            problemli.textContent = problem.name
            ul.appendChild(problemli)  
        });
            
    }

        
    
    catch(erro){
        console.error('Erro', erro)
        alert("Erro de rede")
    }

})