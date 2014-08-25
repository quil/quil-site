var editor;

function runSketch(id) {
    var src = '/sketches/html/' + id;
    $('#result').attr('src', src);
    $('#result').removeClass('hidden');
    $('#ajax-status').addClass('hidden');
}

function showError(response) {
    console.log(response);
    $('#ajax-status').addClass('hidden');
}

function send() {
    var data = {cljs: editor.getValue()};
    $.ajax({
        url: '/sketches/create',
        method: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function(resp) {
            if (resp.result === 'ok') {
                runSketch(resp.id);
            } else if (resp.result === 'error') {
                showError(resp);
            }
        }
    });
    $('#result').addClass('hidden');
    $('#ajax-status').removeClass('hidden');
    $('#result-tab').tab('show');
}

$(function() {
    editor = CodeMirror.fromTextArea($('#source')[0], {
        mode: 'clojure',
        lineNumbers: true
    });

    $.ajax({
        url: '/sketches/info/basic',
        method: 'GET',
        success: function(resp) {
            editor.setValue(resp.cljs);
        }
    });
    $('#send').on('click', send);

});
