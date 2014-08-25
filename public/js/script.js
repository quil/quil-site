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
            $('#result').removeClass('hidden');
            $('#ajax-status').addClass('hidden');
        }
    });
    $('#result').addClass('hidden');
    $('#ajax-status').removeClass('hidden');
}

$(function() {
    $.ajax({
        url: '/sketches/info/basic',
        method: 'GET',
        success: function(resp) {
            $('#source').val(resp.cljs);
        }
    });
    $('#send').on('click', send);
});
