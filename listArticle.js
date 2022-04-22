document.addEventListener('DOMContentLoaded', function () {
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const data = JSON.parse(xhr.responseText);
            const table = document.querySelector('#table-name');
            for (let i = 0; i < data.length; i++) {
                const element = data[i];
                console.log(new Date(element.create_at));
                table.innerHTML +=
                    `<tr>
                        <th scope="row">${element.id}</th>
                            <th scope="row">${element.title}</th>  
                            <th scope="row">${element.description}</th>
                            <th scope="row">${element.image}</th>
                            <th scope="row">${element.category}</th>
                            <th scope="row">${new Date(element.create_at)}</th>
                            <th scope="row">${new Date(element.update_at)}</th>
                            <th scope="row">${element.status} </th>
                            <th>
                                <a href="formArticle.html?id=${element.id}" class="btn btn-primary" >Update</a>
                                <span onclick='deleteProduct(${element.id})'>DELETE</span>
                            </th>
                    </tr>`
            }
        }
    };
    xhr.open('GET', 'http://localhost:8080/api/v1/article/', false);
    xhr.send();

});
function deleteProduct (id){
    console.log("radfads");
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
        xhr.open('DELETE','http://localhost:8080/api/v1/article/' + id,false);
        xhr.send();
    }
}

