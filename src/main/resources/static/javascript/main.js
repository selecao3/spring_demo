var befor_id = 0;
$(function () {
    $('div.folder').click(function () {
        var id = $(this).attr("id");
        if (befor_id !== id) {
            $('#menu' + befor_id).hide();
        }
        $('#menu' + id).toggle();
        befor_id = id;
    })
        })