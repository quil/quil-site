function initSnippets() {
    const snippets = Array.from(document.querySelectorAll('.snippet'));
    snippets.forEach((snippetDiv) => {
        const code = snippetDiv.querySelector('pre').textContent;
        snippetDiv.querySelector('pre').classList.add('hidden');
        new CodeMirror(snippetDiv, {
            mode: 'clojure',
            value: code,
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
