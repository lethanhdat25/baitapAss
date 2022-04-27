const params = new Proxy(new URLSearchParams(window.location.search), {
    get: (searchParams, prop) => searchParams.get(prop),
});

document.addEventListener('DOMContentLoaded', function () {
    const id = params.id;

    if(id){
        const getArticleDetailUrl = `http://localhost:8080/api/v1/article/${id}`;
        const xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    var element = JSON.parse(xhr.responseText);
                    console.log(element);
                    document.forms['article-form']['name'].value = element.name;
                    document.forms['article-form']['wage'].value = element.wage;
                } else {
                    alert('Khong the load.');
                }
            }
        }
        xhr.open('GET', getArticleDetailUrl, false);
        xhr.send();
    }

})

const handleSubmit = () =>{
    const id = params.id;
    const name = document.forms['article-form']['name'].value;
    const wage = document.forms['article-form']['wage'].value;
    const data = JSON.stringify({id:parseInt(id),name,wage})
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200){
            alert("Success");
            window.location.href = 'listArticle.html';
        }
    };
    if (!id){
        xhr.open('POST','http://localhost:8080/api/v1/employees',false);
        xhr.setRequestHeader("Content-Type", "application/json;charset = UTF-8");
        xhr.send(data);
    }else{
        xhr.open('PUT','http://localhost:8080/api/v1/employees/' + id,false);
        xhr.setRequestHeader("Content-Type", "application/json;charset = UTF-8");
        xhr.send(data);
    }
}
