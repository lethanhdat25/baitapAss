document.addEventListener('DOMContentLoaded', function () {
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const data = JSON.parse(xhr.responseText);
            const table = document.querySelector('#table-name');
            for (let i = 0; i < data.length; i++) {
                const element = data[i];
                const wage = element.wage.toLocaleString('vi', {style : 'currency', currency : 'VND'})
                table.innerHTML +=
                    `<tr>
                        <th scope="row">${element.id}</th>
                            <th scope="row">${element.name}</th>  
                            <th scope="row">${wage}</th>
                    </tr>`
            }
        }
    };
    xhr.open('GET', 'http://localhost:8080/api/v1/employees/', false);
    xhr.send();

});
function deleteProduct (id){
    if(id === undefined || id === null){
        return;
    }
    if (confirm("Are you sure ?")){
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if(xhr.readyState === 4 && xhr.status === 200){
                alert("Success");
                window.location.href = 'listArticle.html';
            }
        };
        xhr.open('DELETE','http://localhost:8080/api/v1/employees/' + id,false);
        xhr.send();
    }
}

