function send() {
    var data = {cljs: $('#source').val()};
    $.ajax({
        url: '/sketches/create',
        method: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function(resp) {
            var src = '/sketches/html/' + resp.id;
            $('#result').attr('src', src);
        }
    });
}

$(function() {
    $('#send').on('click', send);
});
