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
  $('.api-index .report-example').tooltip({placement: 'bottom'});
}

function sendReportExampleEvent(event) {
    const element = event.target;
    window.ga('send', 'event', 'api', 'report-example', element.dataset.functionName);
    window.ga(() => {
        element.classList.remove('btn-primary', 'btn-default');
        element.classList.add('btn-success');
        element.innerText = element.dataset.reportedText;
        element.disabled = 'disabled';
    });
}

function initReportExampleButtons() {
    Array.from(document.querySelectorAll('.report-example')).forEach((reportElement) => {
        reportElement.addEventListener('click', sendReportExampleEvent);
    })
}

$(function() {
    initTooltips();
    initSnippets();
    initReportExampleButtons();
});
