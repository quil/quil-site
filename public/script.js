console.log('123');

function renderSketch(id) {
    var url = '/sketches/run/' + id;
    document.querySelector('#sketch').src = url;
}

function submit() {
    var request = new XMLHttpRequest();
    request.open('POST', '/sketches/create');
    request.setRequestHeader('Content-Type', 'application/json');
    request.onreadystatechange = function() {
        if (request.readyState !== 4) {
            return;
        }
        var id = JSON.parse(request.response).id;
        console.log(id);
        renderSketch(id);
    };
    var snippet = document.querySelector('#snippet').value;
    var payload = {cljs: snippet};
    request.send(JSON.stringify(payload));
}
