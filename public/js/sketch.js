var editor;

function send() {
    var data = {cljs: editor.getValue()};
    $.ajax({
        url: '/sketches/create',
        method: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function(resp) {
            var src = '/sketches/html/' + resp.id;
            $('#result').attr('src', src);
            $('#result').removeClass('hidden');
            $('#ajax-status').addClass('hidden');
        }
    });
    $('#result').addClass('hidden');
    $('#ajax-status').removeClass('hidden');
}

$(function() {
    editor = CodeMirror.fromTextArea($('#source')[0], {
        mode: 'clojure'
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
