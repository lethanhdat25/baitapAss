const params = new Proxy(new URLSearchParams(window.location.search), {
    get: (searchParams, prop) => searchParams.get(prop),
});

document.addEventListener('DOMContentLoaded', function () {
    const id = params.id;
    const getArticleDetailUrl = `http://localhost:8080/api/v1/article/${id}`;
    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var element = JSON.parse(xhr.responseText);
                console.log(element);
                document.forms['article-form']['title'].value = element.id;
                document.forms['article-form']['description'].value = element.title;
                document.forms['article-form']['image'].value = element.description;
                document.forms['article-form']['category'].value = element.category;
                document.forms['article-form']['status'].value = element.status;
            } else {
                alert('Khong the load tin tuc');
            }
        }
    }
    xhr.open('GET', getArticleDetailUrl, false);
    xhr.send();
})


const updateArti =()=>{
    const id = params.id;

    const title = document.forms['article-form']['title'].value;
    const description = document.forms['article-form']['description'].value;
    const image = document.forms['article-form']['image'].value;
    const category = document.forms['article-form']['category'].value;
    const status = document.forms['article-form']['status'].value;
    const data = JSON.stringify({id:parseInt(id),title,description,image,category,status})
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200){
            alert("Success");
            window.location.href = 'listArticle.html';
        }
    };
    console.log(data);
    xhr.open('PUT','http://localhost:8080/api/v1/article/' + id,false);
    xhr.setRequestHeader("Content-Type", "application/json;charset = UTF-8");
    xhr.send(data);
}
