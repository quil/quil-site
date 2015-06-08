var editor;

function showErrorAlert(error) {
    var alert = $('<div></div>')
        .addClass('alert')
        .addClass('alert-danger')
        .attr('role', 'alert')
        .text(error.message)
        .insertBefore('#source');
}

function setErrors(errors) {
    editor.getOption('lint').options.cljsErrors = errors;
    $('#source-content .alert-danger').remove();
    errors.forEach(showErrorAlert);
    CodeMirror.signal(editor, 'change', editor);
}

function runSketch(id, size) {
    var src = '/sketches/html/' + id;
    var width = size ? size[0] : 500;
    var height = size ? size[1] : 500;
    $('#result iframe')
        .attr('src', src)
        .css('width', width + 'px')
        .css('height', height + 'px');
    $('#result a')
        .attr('href', src);
    $('#ajax-status').addClass('hidden');
    setErrors([]);
    if (window.history  && window.history.replaceState) {
        window.history.replaceState({}, '', '/sketches/show/' + id);
    }
}

function showError(response) {
    $('#ajax-status').addClass('hidden');
    $('#source-tab').tab('show');
    setErrors([response]);
}

function send() {
    editor.clearGutter('CodeMirror-lint-markers');
    var data = {cljs: editor.getValue()};
    $.ajax({
        url: '/sketches/create',
        method: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function(resp) {
            if (resp.result === 'ok') {
                runSketch(resp.id, resp.size);
            } else if (resp.result === 'error') {
                showError(resp);
            }
        }
    });
    $('#result').addClass('hidden');
    $('#ajax-status').removeClass('hidden');
    $('#result-tab').tab('show');
    $('head').append(
        $('<link/>')
            .attr('rel', 'prefetch')
            .attr('href', '/js/preload.js'));
}

$(function() {
    CodeMirror.registerHelper('lint', 'clojure', function(text, options) {
        return options.cljsErrors.map(function(error) {
            return {
                from: CodeMirror.Pos(error.line - 1, error.column - 2),
                to: CodeMirror.Pos(error.line - 1, error.column - 1),
                message: error.message
            }
        });
    });

    editor = CodeMirror.fromTextArea($('#source')[0], {
        mode: 'clojure',
        lineNumbers: true,
        gutters: ["CodeMirror-lint-markers"],
        lint: {
            options: {cljsErrors: []},
        },
        viewportMargin: Infinity
    });

    $.ajax({
        url: '/sketches/info/' + $('#source').data('sketch-id'),
        method: 'GET',
        success: function(resp) {
            editor.setValue(resp.cljs);
        }
    });
    $('#send').on('click', send);
    $('#result iframe').load(function() {
        $('#result').removeClass('hidden');
    });

});
