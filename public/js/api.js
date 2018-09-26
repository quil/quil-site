function initSnippets() {
    const snippets = Array.from(document.querySelectorAll('.snippet'));
    snippets.forEach((snippetDiv) => {
        const preEl = snippetDiv.querySelector('pre');
        snippetDiv.querySelector('pre').classList.add('hidden');
        new CodeMirror((editor) => {
            preEl.parentElement.replaceChild(editor, preEl);
        }, {
            mode: 'clojure',
            value: preEl.textContent,
            matchBrackets: true,
            readOnly: true,
            viewportMargin: Infinity,
            lineWrapping: true,
        });
    });
}

function initTooltips() {
  $('.api-index .function span').tooltip({placement: 'bottom'});
}

$(function() {
    initTooltips();
    initSnippets();
});
